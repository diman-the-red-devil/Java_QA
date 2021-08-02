package pom;

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
        driver.findElement(loginBy).sendKeys(login);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(signInBy).click();
        return new HomePage(driver);
    }
}
