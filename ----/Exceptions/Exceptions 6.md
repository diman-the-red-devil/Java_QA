* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

# 6. Окна и вкладки

## NoSuchWindowException

***NoSuchWindowException*** — исключение, которое вызывается, когда

[selenium/docs/api : NoSuchWindowException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/NoSuchWindowException.html)

### Причины

This is thrown when WebDriver tries to switch to an invalid window.

The below code can throw org.openqa.selenium.NoSuchWindowException if the window handle doesn’t exist or is not available to switch.

*Пример*

```java
driver.switchTo().window(handle_1);
```

### Решение

We would use window handles to get the set of active windows and then perform actions on the same.
Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (UnexpectedTagNameException e) {
    System.out.println(e);
}
```

In the example below, for each window handle, driver switch to is executed. Therefore chances of passing a wrong window parameter reduced.

*Пример*

```java
for (String handle : driver.getWindowHandles()) {
try {
driver.switchTo().window(handle);
} catch (NoSuchWindowException e) {
System.out.println("An exceptional case");
}
}
```

NoSuchWindowException

This one is very similar to the previous exception, applied to windows.
This happens when you try to switch to a new window (or tab), which cannot be found.
You can solve this by getting all the windows handles, then switching to the correct one:

*Пример*

```java
var windows = driver.WindowHandles;
driver.SwitchTo().Window(windows[1]);
```

NoSuchWindowException

This exception arises when WebDriver tries to switch to an invalid window. The code below can throw NoSuchWindowException if the window handle doesn’t exist or is not available to switch.
The below code can throw NoSuchWindowException if the window handle doesn’t exist or is not available to switch.

*Пример*

```java
driver.switchTo().window(handle_1);
```

## NoSuchFrameException

***NoSuchFrameException*** — исключение, которое вызывается, когда

[selenium/docs/api : NoSuchFrameException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/NoSuchFrameException.html)

### Причины

if a frame "frame_11" doesn’t exist or is not available.
The below code can throw org.openqa.selenium.NoSuchFrameException if a frame "frame_11" doesn’t exist or is not available.

*Пример*

```java
driver.switchTo().frame("frame_11");
```

### Решение

Try to give a wait command.
Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
    driver.switchTo().frame("frame_11");
} catch (NoSuchFrameException e) {
    System.out.println(e);
}
```

In the example below, WebDriver waits for 10 seconds for the frame to be available.
If the frame is available and still there is an exception, then it is caught.

*Пример*

```java
try {
WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
wait.Until(ExpectedConditions.frameToBeAvaliableAndSwitchToIt(frame_11));
try {
driver.switchTo().frame("frame_11");
} catch (WebDriverException e) {
System.out.println("An exceptional case");
}
} catch (TimeOutException e) {
System.out.println("WebDriver couldn’t locate the frame");
}
```

NoSuchFrameException

Similar to the NoSuchElementException, this Selenium exception is thrown when a frame is not found. Again, this can happen for multiple reasons:

You are using an incorrect frame Id or name. In this case, make sure that you correctly identify the frame you want to switch to.
The frame was not yet loaded. To solve this, you can use the solution above and add an implicit wait.
The frame is nested inside a different frame. In this case, you must first switch to the parent frame, then to the frame you want to use.
Nested Frames in HTML
In this example, to interact with elements inside "frame-left", you would first need to switch to "frame-top":

*Пример*

```java
driver.SwitchTo().Frame("frame-top");
driver.SwitchTo().Frame("frame-left");
```

## NoAlertPresentException

***NoAlertPresentException*** — исключение, которое вызывается, когда

[selenium/docs/api : NoAlertPresentException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/NoAlertPresentException.html)

### Причины

alert, which is not available.

org.openqa.selenium.NoAlertPresentException will be thrown If below automation code calls accept() operation on Alert() class when an alert is not yet on the screen.

*Пример*

```java
driver.switchTo().alert().accept();
```

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

*Пример*

```java
try {
driver.switchTo().alert().accept();
} catch (NoSuchAlertException e)
```

In this case, the exception is thrown even if the alert is not loaded completely.

Avoiding-And-Handling:

Always use explicit or fluent wait for a particular time in all cases where an alert is expected. If the alert is available and still there is an exception, then it is caught.

*Пример*

```java
try {
WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
wait.Until(ExpectedConditions.alertIsPresent());
try {
driver.switchTo().alert().accept();
} catch (NoAlertPresentException e) {
System.out.println("An exceptional case");
}
} catch (TimeOutException e)
System.out.println("WebDriver couldn’t locate the Alert");
}
```

NoAlertPresentException

The NoAlertPresentException is thrown when Selenium is trying to interact with an alert that is not loaded on the webpage.
If the alert is indeed not loaded at all, then you may have found a bug in your AUT, or perhaps you are missing the steps that lead to the alert opening.
Another reason can be that the alert is displayed slower than Selenium performs the actions. In this case, you can add an implicit wait to your code,
so the action performed on the alert is delayed by a few seconds:

*Пример*

```java
driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(5);
```

However, be mindful when using implicit waits, as the timespan you select will apply even if the element or alert you are waiting for has already been loaded on the page.

## UnhandledAlertException

***UnhandledAlertException*** — исключение, которое вызывается, когда

[selenium/docs/api : UnhandledAlertException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/UnhandledAlertException.html)

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

This exception is thrown when an alert is present on the page, preventing you from interacting with the elements. You can dismiss or accept the alert, as needed, and move on with the test steps:

*Пример*

```java
// Dismiss the alert
driver.SwitchTo().Alert().Dismiss();
// Accept the alert
driver.SwitchTo().Alert().Accept();
```
