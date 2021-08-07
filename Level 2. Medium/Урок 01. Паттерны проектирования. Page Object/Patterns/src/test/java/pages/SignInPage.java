package pages;

import elements.Button;
import elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Страница "Sign In"
public class SignInPage {
    // Драйвер браузера
    protected WebDriver driver;
    // Поле ввода "Логин"
    private By loginBy = By.name("login");
    // Поле ввода "Пароль"
    private By passwordBy = By.name("password");
    // Кнопка "Отправить"
    private By signInBy = By.name("commit");

    // Конструктор
    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    // Вход с логином и паролем
    public HomePage loginValidUser(String login, String password) {
        TextBox tbxLogin = new TextBox(driver.findElement(loginBy));
        tbxLogin.setText(login);
        TextBox tbxPassword = new TextBox(driver.findElement(passwordBy));
        tbxPassword.setText(password);
        Button btnSignIn = new Button(driver.findElement(signInBy));
        btnSignIn.click();
        return new HomePage(driver);
    }
}
