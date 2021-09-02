package exps.models;

import java.io.Serializable;

// Учетные данные
public class AccountJB implements Serializable {
    // Поля
    // Логин
    private String login;
    // Пароль
    private String password;

    // Конструктор
    public AccountJB(String login, String password) {
        this.login = login;
        this.password = password;
    }

    // Конструктор без параметров
    public AccountJB() {

    }

    // Геттеры и Сеттеры
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
