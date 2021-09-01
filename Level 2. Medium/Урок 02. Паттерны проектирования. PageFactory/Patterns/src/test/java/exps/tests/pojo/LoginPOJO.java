package exps.tests.pojo;

public class LoginPOJO {
    public String login;
    public String password;

    public LoginPOJO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String login() {
        return this.login;
    }

    public String password() {
        return this.password;
    }
}
