* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

[DONE:]
[TODO: Add Examples]

# 3. Свойства веб элемента

## UnexpectedTagNameException

***UnexpectedTagNameException*** — исключение, которое вызывается, когда нельзя найти веб элемент ожидаемого тега.

[selenium/docs/api : UnexpectedTagNameException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/UnexpectedTagNameException.html)

### Причины

* Фактический тег веб элемента отличается

*Пример*

```java
@Test
public void testCase7(){
    webDriver.navigate().to(file);
    Select select = new Select(webDriver.findElement(By.id("attr")));
    select.selectByIndex(0);
}
```

### Решение

Проверка тега веб элемента с которым будут выполнятся операции.
Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (UnexpectedTagNameException e) {
    System.out.println(e);
}
```
