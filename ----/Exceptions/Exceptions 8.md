* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

# 8. Разные

## JavascriptException

***JavascriptException*** — исключение, которое вызывается, когда невозможно выполнить JS скрипт.

[selenium/docs/api : JavascriptException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/JavascriptException.html)

### Причины



### Решение

Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (JavascriptException e) {
    System.out.println(e);
}
```

## ScreenshotException

***ScreenshotException*** — исключение, которое вызывается, когда невозможно снять скриншот.

Такой сценарий вероятен на веб-страницах/веб-приложениях, где конфиденциальная информация
например имя пользователя, пароль, банковская информация и т. д. вводятся пользователем.
В таких случаях снимок экрана не может быть сделан из-за .

Здесь ограничение скриншота предотвращает захват или запись экрана.

[selenium/docs/api : ScreenshotException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/remote/ScreenshotException.html)

### Причины

* Наличие ограничений на создание снимков экрана в целях безопасности

### Решение

Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (ScreenshotException e) {
    System.out.println(e);
}
```
