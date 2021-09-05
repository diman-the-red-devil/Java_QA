package exps.web.pages;

import exps.web.elements.Button;
import exps.web.elements.TextBox;
import exps.models.Account;
import exps.models.AccountJB;
import exps.models.AccountPOJO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Страница "Sign In"
public class SignInPage extends BasePage {
    // Поле ввода "Логин"
    private By loginBy = By.name("login");
    // Поле ввода "Пароль"
    private By passwordBy = By.name("password");
    // Кнопка "Отправить"
    private By signInBy = By.name("commit");

    // Конструктор
    public SignInPage(WebDriver driver){
        super(driver);
    }

    // Веб элементы
    public TextBox tbxLogin() {
        return new TextBox(driver, loginBy);
    }

    public TextBox tbxPassword() {
        return new TextBox(driver, passwordBy);
    }

    public Button btnSignIn() {
        return new Button(driver, signInBy);
    }

    // Вход с логином и паролем
    public HomePage loginValidUser(String login, String password) {
        tbxLogin().setValue(login);
        tbxPassword().setValue(password);
        btnSignIn().click();
        return new HomePage(driver);
    }

    public HomePage loginValidUser(AccountPOJO accountPOJO) {
        tbxLogin().setValue(accountPOJO.login());
        tbxPassword().setValue(accountPOJO.password());
        btnSignIn().click();
        return new HomePage(driver);
    }

    public HomePage loginValidUser(AccountJB accountJB) {
        tbxLogin().setValue(accountJB.getLogin());
        tbxPassword().setValue(accountJB.getPassword());
        btnSignIn().click();
        return new HomePage(driver);
    }

    public HomePage loginValidUser(Account account) {
        tbxLogin().setValue(account.getLogin().getLogin());
        tbxPassword().setValue(account.getPassword().getPassword());
        btnSignIn().click();
        return new HomePage(driver);
    }
}
