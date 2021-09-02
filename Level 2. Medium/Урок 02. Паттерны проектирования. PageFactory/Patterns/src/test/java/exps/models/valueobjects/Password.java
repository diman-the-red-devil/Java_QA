package exps.models.valueobjects;

import java.io.Serializable;

// Пароль
public class Password implements Serializable {
    // Поле
    private String password;

    // Конструктор
    public Password(String password) {
        if (!password.isBlank() && !password.isEmpty())
            this.password = password;
        else
            throw new IllegalArgumentException("Пароль не можеь быть пустым!");
    }

    // Геттер
    public String getPassword() {
        return this.password;
    }
}
