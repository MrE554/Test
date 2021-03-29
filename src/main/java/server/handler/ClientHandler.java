package server.handler;

import server.MyServer;

import java.io.*;
import java.net.Socket;

public class ClientHandler {
    private MyServer myServer;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String pathFileHistory;

    private String name;

    public String getName() {
        return name;
    }

    public ClientHandler(MyServer myServer, Socket socket) {
        try {
            this.myServer = myServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            this.pathFileHistory = "historyChat.txt";
            this.name = "";
            new Thread(() -> {
                try {
                    authentication();
                    readMessages();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException e) {
//            throw new RuntimeException("Проблемы при создании обработчика клиента");
            e.printStackTrace();
        }
    }

    public void authentication() throws IOException {
        while (true) {
            String str = dis.readUTF();
            if (str.startsWith("/auth")) {
                String[] parts = str.split("\\s");
                String nick = myServer.getAuthService().getNickByLoginPass(parts[1], parts[2]);
                if (nick != null) {
                    if (!myServer.isNickBusy(nick)) {
                        sendMsg("/authok " + nick);
                        name = nick;
                        myServer.broadcastMsg(name + " зашел в чат");
                        myServer.subscribe(this);
                        return;
                    } else {
                        sendMsg("Учетная запись уже используется");
                    }
                } else {
                    sendMsg("Неверные логин/пароль");
                }
            }
        }
    }

    public void readMessages() throws IOException {
//        myServer.broadcastMsg(readHistory());
        sendMsg(readHistory());
        System.out.println(readHistory());
        while (true) {
            String str = dis.readUTF();
            if (str.startsWith("/")) {
                if (str.equals("/end")) {
                    break;
                }
                if (str.startsWith("/w ")) {
                    String[] tokens = str.split("\\s");
                    String nick = tokens[1];
                    String msg = str.substring(4 + nick.length());
                    myServer.sendMsgToClient(this, nick, msg);
                }
                continue;
            }
            String namedString = name + ": " + str;
            myServer.broadcastMsg(namedString);
            writeHistory(namedString);
        }
    }

    public void sendMsg(String msg) {
        try {
            dos.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeHistory(String message) {
        byte[] data;
        message += " \n";
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(pathFileHistory, true))){
            data = message.getBytes();
            out.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readHistory() {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(pathFileHistory))){
            int data;
            do{
                data = in.read();
                stringBuilder.append((char) data);
            } while (data != -1);
        } catch (IOException e){
            e.printStackTrace();
        }
        return stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).toString();
    }

    public void closeConnection() {
        myServer.unsubscribe(this);
        myServer.broadcastMsg(name + " вышел из чата");
        try {
            socket.close();
            dis.close();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}