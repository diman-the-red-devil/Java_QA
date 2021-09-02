package exps.models.valueobjects;

import java.io.Serializable;

// Логин
public class Login implements Serializable {
    // Поле
    private String login;

    // Конструктор
    public Login(String login) {
        if (!login.isBlank() && !login.isEmpty())
            this.login = login;
        else
            throw new IllegalArgumentException("Логин не может быть пустым!");
    }

    // Геттер
    public String getLogin() {
        return login;
    }
}
