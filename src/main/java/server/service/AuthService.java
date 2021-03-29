package server.service;

public interface AuthService extends Service {
    String getNickByLoginPass(String login, String pass);
}
