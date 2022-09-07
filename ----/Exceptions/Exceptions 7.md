* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

# 7. Ожидание

## TimeoutException

***TimeoutException*** - исключение, которое вызывается, когда выполнение какой-либо
команды не завершилось в отведенный промежуток времени.

[selenium/docs/api : TimeoutException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/TimeoutException.html)

### Причины

* Искомый веб элемент не был найден за определенное время
* Страница не была загружена за определенное время

### Решение

Настроить неявное ожидание или явное ожидание.
Ниже пример перехвата исключения.

*Пример*

```java
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
try {
    driver.get("https://www.softwaretestinghelp.com");
} catch (TimeoutException e) {
    System.out.println(e);
}
```

*Пример*

```java
WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(30));
wait.until(webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState")
        .equals("complete"));
try {
    driver.get("https://www.softwaretestinghelp.com");
} catch (TimeoutException e) {
    System.out.println(e);
}
```