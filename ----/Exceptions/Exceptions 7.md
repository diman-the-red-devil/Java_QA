* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

# 7. Ожидание

## TimeoutException

***TimeoutException*** - исключение, которое вызывается, когда выполнение какой-либо
команды не завершилось в отведенный промежуток времени, так как выполнение команды занимает больше времени, чем время ожидания. 

[selenium/docs/api : TimeoutException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/TimeoutException.html)

### Причины

* Страница не была загружена за определенное время

*Пример*

В примере ниже установлено ожидание загрузки страницы в 1 миллисекунду. 
Страница не успевает загрузиться за этот промежуток времени.

```java
@Test
public void test() {
    driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(1));
    driver.manage().window().maximize();
    driver.get("https://www.mvideo.ru/");
}
```

В результате вызывается исключение **TimeoutException**

```text
org.openqa.selenium.TimeoutException: 
timeout: Timed out receiving message from renderer: 0.001
```

* Искомый веб элемент не был найден за определенное время

*Пример*

В примере ниже ожидается появление веб элемента.
Веб элемент не успевает отобразиться в отведенный промежуток времени.

```java
@Test
public void test2() {
    driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(6000));
    driver.manage().window().maximize();
    driver.get("https://www.mvideo.ru/");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()=\"ЭКСПРЕСС-ДОСТАВКА\"]")));
    driver.findElement(By.xpath("//a[text()=\"ЭКСПРЕСС-ДОСТАВКА\"]"));
}
```

В результате вызывается исключение **TimeoutException**

```text
org.openqa.selenium.TimeoutException: Expected condition failed: 
waiting for presence of element located by: By.xpath: //a[text()="Смартфоны"] 
(tried for 0 second(s) with 500 milliseconds interval)

```

### Решение

* Неявное ожидание в течение промежутка времени, за которое страница успевает загрузится

*Пример*

```java
@Test
public void test() {
    driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(6000));
    driver.manage().window().maximize();
    driver.get("https://www.mvideo.ru/");
}
```

* Явное ожидание наступления конкретного события, в течение промежутка времени, 
за которое событие успевает наступить
  
*Пример*

```java
@Test
public void test() {
    driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(6000));
    driver.manage().window().maximize();
    driver.get("https://www.mvideo.ru/");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(6000));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()=\"ЭКСПРЕСС-ДОСТАВКА\"]")));
    driver.findElement(By.xpath("//a[text()=\"ЭКСПРЕСС-ДОСТАВКА\"]"));
}
```

* Явное ожидание с применением скрипта на **JS**

*Пример*

В приведенном ниже примере после открытия страницы вызывается на **JS**

```js
return document.readyState
```

пока не будет возвращено **complete**.

```java
@Test
public void test() {
    driver.get("https://www.mvideo.ru/");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(webDriver -> ((JavascriptExecutor) webDriver)
            .executeScript("return document.readyState")
            .equals("complete"));
}
```

Ниже пример перехвата исключения.

*Пример*

```java
    @Test
public void test() {
    try {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(1));
        driver.manage().window().maximize();
        driver.get("https://www.mvideo.ru/");
    } catch(TimeoutException e) {
        logger.info("TimeoutException: " + e.getRawMessage());
    }
}
```