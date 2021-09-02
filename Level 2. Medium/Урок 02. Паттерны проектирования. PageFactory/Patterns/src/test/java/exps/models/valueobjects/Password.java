package exps.models.valueobjects;

public class Password {
    private String password;

    public Password(String password) {
        if (!password.isBlank() && !password.isEmpty())
            this.password = password;
        else
            throw new IllegalArgumentException("Пароль не можеь быть пустым!");
    }

    public String getPassword() {
        return this.password;
    }
}
