package exps.pages;

import exps.decorators.LogWebElementDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Страница "Sign In"
public class SignInPageWithDecorators {
    // Драйвер браузера
    protected WebDriver driver;
    // Поле ввода "Логин"
    private By loginBy = By.name("login");
    // Поле ввода "Пароль"
    private By passwordBy = By.name("password");
    // Кнопка "Отправить"
    private By signInBy = By.name("commit");

    // Конструктор
    public SignInPageWithDecorators(WebDriver driver){
        this.driver = driver;
    }

    // Вход с логином и паролем
    public HomePageWithDecorators loginValidUser(String login, String password) {
        LogWebElementDecorator tbxLogin = new LogWebElementDecorator(driver.findElement(loginBy));
        tbxLogin.sendKeys(login);
        LogWebElementDecorator tbxPassword = new LogWebElementDecorator(driver.findElement(passwordBy));
        tbxPassword.sendKeys(password);
        LogWebElementDecorator btnSignIn = new LogWebElementDecorator(driver.findElement(signInBy));
        btnSignIn.click();
        return new HomePageWithDecorators(driver);
    }
}
