package exps.models;

// Учетные данные
public class AccountPOJO {
    // Поля
    // Логин
    public String login;
    // Пароль
    public String password;

    // Конструктор
    public AccountPOJO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    // Получение значения логина
    public String login() {
        return this.login;
    }

    // Получение значения пароля
    public String password() {
        return this.password;
    }
}
