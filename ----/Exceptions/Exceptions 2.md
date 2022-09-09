* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

[DONE:]

# 2. Локаторы

## InvalidSelectorException

***InvalidSelectorException*** — исключение, которое вызывается, когда заданный селектор поиска не возвращает **WebElement**.

[selenium/docs/api : InvalidSelectorException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/InvalidSelectorException.html)

### Причины

* В **Xpath** выражении есть синтаксические ошибки

*Пример*

В примере ниже в **Xpath** выражении опечатка.

Должно быть:

```xpath
(//*[@class="ui-link menu-desktop__root-title"])[5]
```

А записано:

```xpath
(//*[@class="ui-link menu-desktop__root-title"])(5]
```

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    WebElement element = driver.findElement(
            By.xpath("(//*[@class=\"ui-link menu-desktop__root-title\"])(5]"));
    element.click();
}
```

В результате вызывается исключение **InvalidSelectorException**

```text
org.openqa.selenium.InvalidSelectorException: invalid selector: 
Unable to locate an element with the xpath expression 
(//*[@class="ui-link menu-desktop__root-title"])(5] 
because of the following error:
SyntaxError: Failed to execute 'evaluate' on 'Document': The string 
'(//*[@class="ui-link menu-desktop__root-title"])(5]' 
is not a valid XPath expression.
```

* **Xpath** выражение не указывает на **WebElement**

*Пример*

В примере ниже в **Xpath** выражении записано выражение:

```xpath
count(.//span)
```

Данное **Xpath** выражение не возвращает веб элемент.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    WebElement element = driver.findElement(By.xpath("count(.//span)"));
    element.click();
}
```

В результате вызывается исключение **InvalidSelectorException**

```text
org.openqa.selenium.InvalidSelectorException: invalid selector: 
Unable to locate an element with the xpath expression 
count(.//span) 
because of the following error:
TypeError: Failed to execute 'evaluate' on 'Document': 
The result is not a node set, and therefore cannot be converted to the desired type.
```

* Использование составного имени класса в **By.className**

*Пример*

В примере ниже в **By.className** записано два класса:

```css
ui-link menu-desktop__root-title
```

В **By.className** не допускается использование составного имени класса.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    WebElement element = driver.findElement(
        By.className("ui-link menu-desktop__root-title"));
    element.click();
}
```

В результате вызывается исключение **InvalidSelectorException**

```text
org.openqa.selenium.InvalidSelectorException: Compound class names not permitted
```

* Использование некорректного **CSS** селектора в **By.cssSelector**

*Пример*

В примере ниже в **By.cssSelector** записано:

```css
a <|> ul
```

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    WebElement element = driver.findElement(
        By.cssSelector("a <|> ul"));
    element.click();
}
```

В результате вызывается исключение **InvalidSelectorException**

```text
org.openqa.selenium.InvalidSelectorException: invalid selector: An invalid or illegal selector was specified
```

### Решение

* Проверка используемого **Xpath** выражения в консоли браузера

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

* Проверка параметра в **By.className**

*Пример*

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    WebElement element = driver.findElement(
            By.className("ui-link"));
    element.click();
}
```

* Проверка используемого **CSS** селектора в консоли браузера

*Пример*

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    WebElement element = driver.findElement(
            By.cssSelector("a.ui-link"));
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
            By.xpath("(//*[@class=\"ui-link menu-desktop__root-title\"])(5]"));
        element.click();
    } catch (InvalidSelectorException e) {
        logger.info("InvalidSelectorException: " + e.getRawMessage());
    }
}
```