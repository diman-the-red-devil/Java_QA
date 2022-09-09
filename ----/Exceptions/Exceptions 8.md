* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

# 8. Разные

[DONE:]

## JavascriptException

***JavascriptException*** — исключение, которое вызывается, когда невозможно выполнить JS скрипт.

[selenium/docs/api : JavascriptException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/JavascriptException.html)

### Причины

* Наличие ошибки в JS скрипте

*Пример*

В примере ниже в скрипте опечатка - вместо **return document.title;** выполняется **return dcoument.title;**

```java
@Test
public void test() {
    driver.get("https://www.dns-shop.ru/");
    JavascriptExecutor js =(JavascriptExecutor) driver;
    String title = js.executeScript("return dcoument.title;").toString();
    logger.info(title);
}
```

В результате вызывается исключение **JavascriptException**

```text
org.openqa.selenium.JavascriptException: javascript error: dcoument is not defined
```

### Решение

* Проверка работы JS скрипта в консоле браузера

*Пример*

```java
@Test
public void test() {
    driver.get("https://www.dns-shop.ru/");
    JavascriptExecutor js =(JavascriptExecutor) driver;
    String title = js.executeScript("return document.title;").toString();
    logger.info(title);
}
```

Ниже пример перехвата исключения.

*Пример*

```java
@Test
public void test() {
    driver.get("https://www.dns-shop.ru/");
    try {
        JavascriptExecutor js =(JavascriptExecutor) driver;
        String title = js.executeScript("return dcoument.title;").toString();
        logger.info(title);
    } catch (JavascriptException e) {
        logger.info("JavascriptException: " + e.getRawMessage());
    }
}
```

## ScreenshotException

***ScreenshotException*** — исключение, которое вызывается, когда невозможно снять скриншот.

[selenium/docs/api : ScreenshotException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/remote/ScreenshotException.html)

### Причины

* Наличие ограничений на создание снимков экрана в целях безопасности (пароли, банковские данные)

### Решение

* Проверка возможности на создание снимков экрана

Ниже пример перехвата исключения.

*Пример*

```java
@Test
public void test() {
    driver.get("https://www.dns-shop.ru/");
    try {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./screenshot.png"));
    } catch (ScreenshotException e) {
        logger.info("JavascriptException: " + e.getRawMessage());
    } catch (IOException e) {
        logger.info("IOException: " + e.getMessage());
    }
}
```
