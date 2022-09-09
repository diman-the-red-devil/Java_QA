* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

[DONE:]

# 3. Свойства веб элемента

## UnexpectedTagNameException

***UnexpectedTagNameException*** — исключение, которое вызывается, когда нельзя найти веб элемент ожидаемого тега.

[selenium/docs/api : UnexpectedTagNameException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/UnexpectedTagNameException.html)

### Причины

* Фактический тег веб элемента отличается

*Пример*

В примере ниже ожидается веб элемент **select**, но найденный веб элемент *a*.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    WebElement element = driver.findElement(
        By.xpath("(//*[@class=\"ui-link menu-desktop__root-title\"])[5]"));
    Select select = new Select(element);
    select.selectByIndex(0);
}
```

В результате вызывается исключение **UnexpectedTagNameException**

```text
org.openqa.selenium.support.ui.UnexpectedTagNameException: Element should have been "select" but was "a"
```

### Решение

* Проверка тега веб элемента, с которым будут выполнятся операции

*Пример*

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    WebElement element = driver.findElement(
        By.xpath("(//*[@class=\"ui-link menu-desktop__root-title\"])[5]"));
    element.click();
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
        WebElement element = driver.findElement(
            By.xpath("(//*[@class=\"ui-link menu-desktop__root-title\"])[5]"));
        Select select = new Select(element);
        select.selectByIndex(0);
    } catch (UnexpectedTagNameException e) {
        logger.info("UnexpectedTagNameException: " + e.getRawMessage());
    }
}
```
