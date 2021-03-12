package Server.service;

public interface IAuthIService extends IService {
    String getNickByLoginPass(String login, String pass);
}
