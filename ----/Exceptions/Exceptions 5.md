* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

# 5. Сложные действия с веб элементами

## InvalidCoordinatesException

***InvalidCoordinatesException*** — исключение, которое вызывается, когда
Indicates that the coordinates provided to an interactions operation are invalid.
This, most likely, means that a move operation was provided with invalid coordinates or that an action that depends on mouse position (like click) was not preceded by a move operation.

[selenium/docs/api : InvalidCoordinatesException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/interactions/InvalidCoordinatesException.html)

### Причины

### Решение

Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (UnexpectedTagNameException e) {
    System.out.println(e);
}
```

## MoveTargetOutOfBoundsException

***MoveTargetOutOfBoundsException*** — исключение, которое вызывается, когда

[selenium/docs/api : MoveTargetOutOfBoundsException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/interactions/MoveTargetOutOfBoundsException.html)

### Причины

### Решение

Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (UnexpectedTagNameException e) {
    System.out.println(e);
}
```

It takes place if the target provided to the ActionChains move() methodology is not valid. For Example, out of the document.

## ElementNotSelectableException

***ElementNotSelectableException*** — исключение, которое вызывается, когда

[selenium/docs/api : ElementNotSelectableException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/ElementNotSelectableException.html)

### Причины

### Решение

Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (UnexpectedTagNameException e) {
    System.out.println(e);
}
```

This exception comes under InvalidElementStateException class. ElementNotSelectableException indicates that the web element is present in the web page but cannot be selected.

For example, the below code can throw a ElementNotSelectableException if the id "swift" is disabled.

*Пример*

```java
Select dropdown = new Select(driver.findElement(By.id("swift")));
```

Exception Handling:

*Пример*

```java
try {
Select dropdown = new Select(driver.findElement(By.id("swift")));
} catch (ElementNotSelectableException e)
```

In this case, exception is thrown even if the element becomes enabled after a while.

Avoiding-And-Handling: We can add a wait command to wait until the element becomes clickable. If there is still an exception, it is caught.

*Пример*

```java
try {
WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
wait.Until(ExpectedConditions. elementToBeClickable(By.id("swift"));
try {
Select dropdown = new Select(driver.findElement(By.id("swift")));
} catch (WebDriverException e) {
System.out.println("Exceptional case");
}
} catch (TimeOutException e)
System.out.println("WebDriver found that this element was not selectable.");
}
```

This exception comes under InvalidElementStateException class.
ElementNotSelectableException indicates that the web element is present in the web page but cannot be selected.

For example, the below code can throw a ElementNotSelectableException if the id "swift" is disabled.

*Пример*

```java
Select dropdown = new Select(driver.findElement(By.id("swift")));
```

Exception Handling:

*Пример*

```java
try {
Select dropdown = new Select(driver.findElement(By.id("swift")));
} catch (ElementNotSelectableException e)
```

In this case, exception is thrown even if the element becomes enabled after a while.

Avoiding-And-Handling: We can add a wait command to wait until the element becomes clickable. If there is still an exception, it is caught.

*Пример*

```java
try {
WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
wait.Until(ExpectedConditions. elementToBeClickable(By.id("swift"));
try {
Select dropdown = new Select(driver.findElement(By.id("swift")));
} catch (WebDriverException e) {
System.out.println("Exceptional case");
}
} catch (TimeOutException e)
System.out.println("WebDriver found that this element was not selectable.");
}
```
