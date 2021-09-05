package exps.models;

import java.io.Serializable;

// Учетные данные
public class AccountDAO implements Serializable {
    // Поля
    private String login;
    private String password;

    // Конструктор без параметров
    public AccountDAO() {

    }

    // Конструктор
    public AccountDAO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    // Геттеры и сеттеры
    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return this.login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }
}