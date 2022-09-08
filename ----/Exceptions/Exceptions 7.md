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

Это исключение возникает, когда выполнение команды занимает больше времени, чем время ожидания. 
Ожидания в основном используются в WebDriver, чтобы избежать исключения ElementNotVisibleException.

Это исключение будет вызвано, если страница или элемент не были загружены после указанного времени ожидания. Чтобы преодолеть это, вы можете увеличить время ожидания, если вы используете неявное ожидание, или, что еще лучше, заменить неявное ожидание явным ожиданием.

[selenium/docs/api : TimeoutException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/TimeoutException.html)

### Причины

* Искомый веб элемент не был найден за определенное время
* Страница не была загружена за определенное время

*Пример*

В приведенной выше программе добавлено неявное ожидание в 10 секунд. 
Если страница www.softwaretestinghelp.com не загрузится в течение 10 секунд, 
будет выброшено исключение TimeoutException.

```java
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
driver.get("https://www.softwaretestinghelp.com");
```

*Пример*

Вышеприведенный оператор ждет до 10 секунд, прежде чем выдать исключение 
(TimeoutException — истекает через 10 секунд ожидания видимости элемента) или, если он находит элемент, он возвращается через 0–10 секунд.

```java
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("statedropdown")));
```

### Решение

Настроить неявное ожидание или явное ожидание.

мы можем вручную проверить среднее время загрузки страницы и настроить ожидание

Или мы можем добавить явное ожидание с помощью исполнителя JavaScript, пока страница не загрузится.

*Пример*

В приведенном ниже примере используется исполняющая программа JavaScript. 
После навигации по страницам мы вызываем JavaScript return document.readyState на 20 секунд, 
пока не будет возвращено «complete».

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