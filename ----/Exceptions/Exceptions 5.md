* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

# 5. Сложные действия с веб элементами

## MoveTargetOutOfBoundsException

***MoveTargetOutOfBoundsException*** — исключение, которое вызывается, когда местоположение, 
передаваемое методу перемещения, выходит за границы страницы.

[selenium/docs/api : MoveTargetOutOfBoundsException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/interactions/MoveTargetOutOfBoundsException.html)

### Причины

* Некорректные координаты

*Пример*

В примере ниже в команду **moveByOffset** переданы некорректные координаты, которые указывают на точку за пределами страницы.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    Actions actions = new Actions(driver);
    actions
        .moveToElement(driver.findElement(By.xpath("//a[text()=\"Смартфоны и гаджеты\"]")))
        .moveByOffset(-1000, -1000)
        .click()
        .perform();
}
```

В результате вызывается исключение **MoveTargetOutOfBoundsException**

```text
org.openqa.selenium.interactions.MoveTargetOutOfBoundsException: move target out of bounds
```

### Решение

* Проверка местоположения передаваемого команде перемещения

Ниже пример перехвата исключения.

*Пример*

```java
@Test
public void ttest() {
    try {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    Actions actions = new Actions(driver);
    actions
        .moveToElement(
            driver.findElement(
                 By.xpath("//a[text()=\"Смартфоны и гаджеты\"]")))
        .moveByOffset(-1000, -1000)
        .click()
        .perform();
    } catch (MoveTargetOutOfBoundsException e) {
        logger.info("MoveTargetOutOfBoundsException: " + e.getRawMessage());
    }
}
```