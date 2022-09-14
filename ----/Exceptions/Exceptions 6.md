* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

# 6. Окна и вкладки

## NoSuchWindowException

***NoSuchWindowException*** — исключение, которое вызывается, когда **Selenium WebDriver** пытается переключиться на недопустимое окно.

[selenium/docs/api : NoSuchWindowException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/NoSuchWindowException.html)

### Причины

* Дескриптора окна не существует

*Пример*

В примере ниже выполняется попытка переключиться в окно с несуществующим дескриптором окна.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    driver.switchTo().window("123456");
}
```

В результате вызывается исключение **NoSuchWindowException**

```text
org.openqa.selenium.NoSuchWindowException: no such window
```

* Дескриптор окна недоступен для переключения

*Пример*

В примере ниже было открыто три окна.
Далее последнее окно было закрыто.
Выполняется попытка переключиться в последнее закрытое окно.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    String windowHandle1 = driver.getWindowHandle();
    logger.info("windowHandle1: " + windowHandle1);
    driver.switchTo().newWindow(WindowType.WINDOW).navigate().to("https://www.dns-shop.ru/");
    String windowHandle2 = driver.getWindowHandle();
    logger.info("windowHandle2: " + windowHandle2);
    driver.switchTo().newWindow(WindowType.WINDOW).navigate().to("https://www.dns-shop.ru/");
    String windowHandle3 = driver.getWindowHandle();
    logger.info("windowHandle3: " + windowHandle3);
    driver.close();

    driver.switchTo().window(windowHandle3);
}
```

В результате вызывается исключение **NoSuchWindowException**

```text
org.openqa.selenium.NoSuchWindowException: no such window: target window already closed
```

### Решение

* Получение текущего набора активных окон, используя **getWindowHandles**

*Пример*

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    String windowHandle1 = driver.getWindowHandle();
    logger.info("windowHandle1: " + windowHandle1);
    driver.switchTo().newWindow(WindowType.TAB).navigate().to("https://www.dns-shop.ru/");
    String windowHandle2 = driver.getWindowHandle();
    logger.info("windowHandle2: " + windowHandle2);
    driver.switchTo().newWindow(WindowType.TAB).navigate().to("https://www.dns-shop.ru/");
    String windowHandle3 = driver.getWindowHandle();
    logger.info("windowHandle3: " + windowHandle3);
    for (String windowHandle : driver.getWindowHandles()) {
        if(windowHandle.contentEquals(windowHandle1)) {
            driver.switchTo().window(windowHandle);
            logger.info("windowHandle: " + windowHandle);
            break;           
        }
    }
}
```

Ниже пример перехвата исключения.

*Пример*

```java
@Test
public void test() {
    try {
        driver.manage().window().maximize();
        driver.get("https://www.dns-shop.ru/");
        driver.switchTo().window("123456");
    } catch (NoSuchWindowException e) {
        logger.info("NoSuchWindowException: " + e.getRawMessage());
    }
}
```

## NoSuchFrameException

***NoSuchFrameException*** — исключение, которое вызывается, когда **Selenium WebDriver** пытается переключиться на недопустимый фрейм.

[selenium/docs/api : NoSuchFrameException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/NoSuchFrameException.html)

### Причины

* Неверный индекс фрейма

*Пример*

В примере ниже выполняется попытка переключиться в фрейм с несуществующим индексом.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    driver.switchTo().frame(29);
}
```

В результате вызывается исключение **NoSuchFrameException**

```text
org.openqa.selenium.NoSuchFrameException: no such frame
```

* Фрейм вложен в другой фрейм
* Фрейм не успел отобразиться

### Решение

* Проверка существования фрейма
* Проверка корректности индекса фрейма
* Проверка корректности имени / идентификатора фрейма
* Переключение на родительский фрейм, а затем на целевой фрейм
* Ожидание появления фрейма

Ниже пример перехвата исключения.

*Пример*

```java
@Test
public void ttest() {
    try {
        driver.manage().window().maximize();
        driver.get("https://www.dns-shop.ru/");
        driver.switchTo().frame(29);
    } catch (NoSuchFrameException e) {
        logger.info("NoSuchFrameException: " + e.getRawMessage());
    }
}
```

## NoAlertPresentException

***NoAlertPresentException*** — исключение, которое вызывается, когда **Selenium WebDriver** пытается переключиться на алерт, который недоступен.

[selenium/docs/api : NoAlertPresentException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/NoAlertPresentException.html)

### Причины

* Алерт не отображается
  
*Пример*

В примере ниже

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    driver.switchTo().alert().dismiss();
}
```

В результате вызывается исключение **NoAlertPresentException**

```text
org.openqa.selenium.NoAlertPresentException: no such alert
```

### Решение

* Проверка возможности появления алерта
* Ожидание появления алерта

*Пример*

```java
@Test
public void test() {
    try {
        driver.manage().window().maximize();
        driver.get("https://www.dns-shop.ru/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    } catch (TimeoutException e) {
        logger.info("TimeoutException: " + e.getRawMessage());
    }
}
```

Ниже пример перехвата исключения.

*Пример*

```java
@Test
public void test() {
    try {
        driver.manage().window().maximize();
        driver.get("https://www.dns-shop.ru/");
        driver.switchTo().alert().dismiss();
    } catch (NoAlertPresentException e) {
        logger.info("NoAlertPresentException: " + e.getRawMessage());
    }
}
```

## UnhandledAlertException

***UnhandledAlertException*** — исключение, которое вызывается, когда отображается алерт, который не обрабатывается.

[selenium/docs/api : UnhandledAlertException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/UnhandledAlertException.html)

### Причины

* Появление алерта, который не обрабатывается
  
*Пример*

В примере ниже отображается алерт, который ни как не обрабатывается.
Далее была попытка нажать на ссылку.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.mvideo.ru/");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("alert(\"Hello World!\")");
    driver.findElement(By.xpath("//a[text()=\"ЭКСПРЕСС-ДОСТАВКА\"]")).click();
}
```

В результате вызывается исключение **UnhandledAlertException**

```text
org.openqa.selenium.UnhandledAlertException: unexpected alert open: {Alert text : Hello World!}
```

### Решение

* Обработка алерта

*Пример*

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.mvideo.ru/");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("alert(\"Hello World!\")");
    driver.switchTo().alert().dismiss();
    driver.findElement(By.xpath("//a[text()=\"ЭКСПРЕСС-ДОСТАВКА\"]")).click();
}
```

Ниже пример перехвата исключения.

*Пример*

```java
@Test
public void test() {
    try {
        driver.manage().window().maximize();
        driver.get("https://www.mvideo.ru/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert(\"Hello World!\")");
        driver.findElement(By.xpath("//a[text()=\"ЭКСПРЕСС-ДОСТАВКА\"]")).click();
    } catch (UnhandledAlertException e) {
        logger.info("UnhandledAlertException: " + e.getRawMessage());
    }
}
```
