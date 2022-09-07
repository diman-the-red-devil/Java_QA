* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

[DONE:]
[TODO: Add Examples]

# 2. Локаторы

## InvalidSelectorException

***InvalidSelectorException*** — исключение, которое вызывается, когда заданный селектор поиска не возвращает **WebElement**.

[selenium/docs/api : InvalidSelectorException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/InvalidSelectorException.html)

### Причины

* В **Xpath** выражении есть синтаксические ошибки
* **Xpath** выражение не указывает на **WebElement** (напр. *count(.//span)*).

*Пример*

```java
click("//button[@type='button'][100]");
```

### Решение

Проверка используемого **Xpath** выражения.
Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (InvalidSelectorException e) {
    System.out.println(e);
}
```

## IllegalLocatorException

***IllegalLocatorException*** — исключение, которое вызывается, когда **By** не может обработать переданные ему аргументы.

[selenium/docs/api : IllegalLocatorException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/IllegalLocatorException.html)

### Причины

* Использование составного имени класса в **By.className** (напр. *q qs*).

### Решение

Проверка аргументов передаваемых в **By**.
Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (IllegalLocatorException e) {
    System.out.println(e);
}
```