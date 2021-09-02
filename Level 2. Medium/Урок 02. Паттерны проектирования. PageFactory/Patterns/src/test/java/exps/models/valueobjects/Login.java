package exps.models.valueobjects;

public class Login {
    private String login;

    public Login(String login) {
        if (!login.isBlank() && !login.isEmpty())
            this.login = login;
        else
            throw new IllegalArgumentException("Логин не может быть пустым!");
    }

    public String getLogin() {
        return login;
    }
}
