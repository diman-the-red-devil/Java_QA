
* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

# 1. Куки

## InvalidCookieDomainException

***InvalidCookieDomainException*** — исключение, которое вызывается, когда куки добавляется в другой домен вместо текущего URL адреса.

[selenium/docs/api : InvalidCookieDomainException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/InvalidCookieDomainException.html)

### Причины

Добавление куки, когда страница с заданным URL еще не открыта
Добавление куки в другую страницу
Добавление куки 

### Решение


## NoSuchCookieException

***NoSuchCookieException*** — исключение, которое вызывается, когда

[selenium/docs/api : NoSuchCookieException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/NoSuchCookieException.html)

### Причины

This Exception occurs when no cookie matching with the given pathname found for all the associated cookies of the currently browsing document.

### Решение

## UnableToSetCookieException

***UnableToSetCookieException*** — исключение, которое вызывается, когда

[selenium/docs/api : UnableToSetCookieException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/UnableToSetCookieException.html)

### Причины

This occurs if a driver is unable to set a cookie.

### Решение



***



# 2. Локаторы

## InvalidSelectorException

***InvalidSelectorException*** — исключение, которое вызывается, когда заданный селектор поиска не возвращает **WebElement**.

[selenium/docs/api : InvalidSelectorException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/InvalidSelectorException.html)

### Причины

Сейчас это исключение возникает только при использовании **xpath** — когда в **xpath** выражении есть синтаксические ошибки
или выражение не указывает на **WebElement** (например, *count(.//span)»*).

### Решение

This subclass of NoSuchElementException class occurs when a selector is incorrect or syntactically invalid. This exception occurs commonly when XPATH locator is used.

Consider the below example:

clickXPathButtonAndWait("//button[@type=’button’][100]");

This would throw an InvalidSelectorExeption because the XPATH syntax is incorrect.

Avoiding and Handling: To avoid this, we should check the locator used because the locator is likely incorrect or the syntax is wrong. Using Firebug to find xpath can reduce this exception.

Below code shows how to handle it using Try/Catch

*Пример*

```java
try {
clickXPathButtonAndWait("//button[@type='button']");
} catch (InvalidSelectorException e) {
}
```

InvalidSelectorException

This Selenium exception is thrown if you are using an incorrect selector. An example of this would be using a compound class name, which is not allowed:


*Пример*

```java
private IWebElement LoginButton => driver.FindElement(By.ClassName("login button"));
```

The solution for this is to make sure that the locator is correct. In the above scenario, you can replace the ClassName locator strategy with CssSelector:


*Пример*

```java
private IWebElement LoginButton => driver.FindElement(By.CssSelector("login.button"));
```

## IllegalLocatorException

***IllegalLocatorException*** — исключение, которое вызывается, когда **By** не может обработать переданные ему аргументы.

[selenium/docs/api : TimeoutException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/IllegalLocatorException.html)

### Причины

Наиболее распространенный случай возникновения — это использование составного имени класса в **By.className**.

### Решение

***

# 3. Свойства веб элемента
 
## UnexpectedTagNameException

***UnexpectedTagNameException*** — исключение, которое вызывается, когда

[selenium/docs/api : UnexpectedTagNameException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/UnexpectedTagNameException.html)

### Причины

Happens if a support class did not get a web element as expected.

### Решение

***

# 4. Простые действия с веб элементами

## NoSuchElementException

***NoSuchElementException*** — исключение, которое вызывается, когда элемент отсутствует в **DOM** на момент вызова.

[selenium/docs/api : NoSuchElementException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/NoSuchElementException.html)

### Причины

### Решение

Решение: добавить ожидание появления веб элемента на странице.

*Пример*

```java
try {
    WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
    wait.Until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
    try {
        driver.findElement(By.id("submit")).click();
    } catch (WebDriverException e) {
        System.out.println(e);
    }
} catch (TimeOutException e) {
    System.out.println("Не найден веб элемент на странице");
}
```

NoSuchElementException

The NoSuchElementException is thrown when the element cannot be found on the web page. This can happen for a number of reasons:

You are using the wrong locator. There is no "one fits all" locator strategy, 
but you have to make sure that you are using a locator that is both unique, and correct. 
Pay extra attention if you are using CSS selectors or XPaths, and make sure they are correct.
The web page was not completely loaded and the element is not found. 
To solve it, you can use Selenium explicit waits, and wait until the element can be found on the page. 
Here’s a code example in C# (you’ll also need to install the DotNetSeleniumExtras NuGet package):


*Пример*

```java
WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
IWebElement LoginButton = wait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.ElementExists(By.Id("login")));
```
The element is not visible on the page and you have to scroll up or down to reach it. You can do this using a JavaScript executor:

*Пример*

```java
public void scrollDown()
{
IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
js.ExecuteScript("window.scrollBy(0,250)", "");
}
```

NoSuchElementException:

This occurs when WebDriver is not able to find and locate elements. 
Usually, this happens when testers write incorrect element locators in the findElement(By) method.

For example: Suppose the correct id for the text field was ‘first_field’ but the tester incorrectly mentioned it as "submit". 
In this case, WebDriver cannot locate the element and NoSuchElementException will be there.

*Пример*

```java
try{
driver.findElement(By.id("submit"));
}catch(NoSuchElementException e){
System.out.println(e.getMessage());
}
```

In this case, the exception occurs even if the element is not present.

## StaleElementReferenceException

***StaleElementReferenceException*** — исключение, которое вызывается, когда ссылка на элемент больше не действительна.

[selenium/docs/api : StaleElementReferenceException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/StaleElementReferenceException.html)

### Причины

То есть, если элемент доступен в **DOM** на момент поиска,
но спустя время, в момент его вызова, в **DOM** его больше нет.

### Решение

Исключение **StaleElementReferenceException** возникает в одном из следующих случаев, первый из которых наиболее распространенный:

* элемент был полностью удален со страницы

Наиболее частой причиной этого является то, что страница с искомым элементом, была обновлена,
или пользователь перешел на другую страницу. Реже, но все также достаточно распространен случай,
когда библиотека **JS** удалила элемент и заменила его элементом с таким же ID или атрибутами.
В этом случае, несмотря на то, что замененные элементы могут выглядеть похожими на оригиналы, они отличаются.

**Selenium Driver** не имеет возможности определить, что замененный элемент на самом деле тот же, что и ожидался.
Если есть уверенность, что элемент заменен идентичным и присутствует на странице,
то нужно выполнить поиск элемента снова и получить актуальную ссылку на него.

* элемент больше не подключен к **DOM** модели

Общей техникой, используемой для имитации вкладок интерфейса в веб-приложениях,
является подготовка нескольких элементов **div** для каждой вкладки,
но прикреплен к **DOM** в один момент времени только один из них, остальные же сохранены в переменные.
В этом случае вполне возможно, что ваш код может иметь ссылку на элемент,
который больше не прикреплен к **DOM** (то есть его предком является **.documentElement**).

**Selenium Driver** вызывает исключение **StaleElementReferenceException** в этом случае, несмотря на то,
что элемент существует, потому, что ссылка на элемент все равно потеряна.
Вам придется заменять ее, выполняя поиск элемента каждый раз, после того как он будет прикреплен к **DOM**.

* элемент меняет свой тип, но сохраняет тот же локатор поиска (JQuery и др.)

Это крайне редкий случай, происходит он когда, например,
поле **input** при нажатии или получении фокуса меняет значение type c **text** на **password**.

Решение:

поиск веб элемента перед выполнением с ним действия
применение динамического xpath запроса

*Пример*

```java
try {
    driver.findElement(By.xpath("//*[contains(@id, 'firstname')]")).sendKeys("Aaron");
} catch (StaleElementReferenceException e)
```

This exception says that a web element is no longer present in the web page.

This error is not the same as ElementNotVisibleException.

StaleElementReferenceException is thrown when an object for a particular web element was created in the program without any problem and however; 
this element is no longer present in the window. This can happen if there was a

Navigation to another page
DOM has refreshed
A frame or window switch

*Пример*

```java
WebElement firstName = driver.findElement(By.id("firstname"));
driver.switchTo().window(Child_Window);
element.sendKeys("Aaron");
```

In the code above, object firstName was created and then the window was switched. 
Then, WebDriver tries to type ‘Aaron’ in the form field. In this case StaleElementReferenceException is thrown.

Avoiding and Handling: Confirm that we are trying to do the action in the correct window. To avoid issues due to DOM refresh, we can use Dynamic Xpath

Let’s discuss another example.

Say ‘id’ of a username field is ‘username_1’ and the XPath will be //*[@id=’firstname_1?]. 
When you open the page again the ‘id’ might change say to ‘’firstname _11’. 
In this case, the test will fail because the WebDriver could not find the element.
In this case, StaleElementReferenceException will be thrown.

In this case, we can use a dynamic xpath like,

*Пример*

```java
try {
driver.findElement(By.xpath("//*[contains(@id,firstname’)]")).sendKeys("Aaron");
} catch (StaleElementReferenceException e)
```

In the example above dynamic XPATH is used and if the exception is still found, it is caught.

StaleElementReferenceException

The StaleElementReferenceException means that a reference to an element is now "stale", 
i.e. the element is no longer available on the web page DOM. 
In other words, the element was initially found on the DOM, but the DOM has changed since then. 
The common causes for this are:

The element was deleted from the DOM.
The element is no longer attached to the DOM.
One possible solution is to refresh the page and try to find the element again:

*Пример*

```java
driver.Navigate().Refresh();
driver.FindElement(By.Id("ElementId")).Click();
```

Or you can wait for the element to load before you manipulate it. Again, you can do this using explicit waits:

*Пример*

```java
WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
IWebElement elementToInteract = wait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.ElementToBeClickable(By.Id("elementId")));
```

StaleElementReferenceException:

A stale element means an old element or no longer available element. 
Suppose there is an element that is found on a webpage referenced as a WebElement in WebDriver. 
If the DOM changes then WebElement goes stale. 
If we try to interact with an element that is stale then the StaleElementReferenceException will occur.

For example:

*Пример*

```java
WebElement firstName = driver.findElement(By.id("first_name"));
driver.switchTo().window(Child_Window);
element.sendKeys("finch");
```

In the code above, when we create the object first_name then the window switches. 
Then, WebDriver tries to type ‘finch’ in the form field. 
In this case, we see StaleElementReferenceException.

[selenium/docs/api : StaleElementReferenceException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/StaleElementReferenceException.html)

## ElementClickInterceptedException

***ElementClickInterceptedException*** — исключение, которое вызывается, когда команда не может быть завершена,
поскольку элемент, получающий событие, скрывает целевой элемент.

[selenium/docs/api : ElementClickInterceptedException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/ElementClickInterceptedException.html)

### Причины

### Решение

ElementClickInterceptedException
This Selenium exception is usually thrown when the element was found on the page, 
but the click action would be performed on a different element that is overlapped our element. 
For example, if you go to the TestProject blog page and scroll down a bit, 
you will see a message prompting you to Sign Up for the TestProject test automation platform. 
You won’t be able to click any of the links on the page until you close it.

Selenium Exception ElementClickInterceptedException
So, if you have something like this in a Selenium test, 
and your test tries to click a blog title, you will get an ElementClickInterceptedException.

One solution to this exception is to use the Action class for performing the click:

*Пример*

```java
Actions _action = new Actions(driver);
_action.MoveToElement(elementToClick).Click();
```

Or if the element is simply out of view and scrolling will reveal it, 
you can use the JavaScript scroll executor as shown above for the NoSuchElementException.

## ElementNotInteractableException

***ElementNotInteractableException*** — исключение, которое вызывается, когда элемент присутствует в **DOM**,
но с таким элементом невозможно взаимодействовать (элемент не находится в области просмотра).

[selenium/docs/api : ElementNotInteractableException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/ElementNotInteractableException.html)

### Причины

### Решение

## ElementNotVisibleException

***ElementNotVisibleException*** — исключение, которое вызывается, когда элемент присутствует в **DOM**,
но он невидим и поэтому взаимодействовать с ним невозможно.

***ElementNotVisibleException*** - исключение, которое вызывается, если элемент был найдем в **DOM**, но он невидим на странице.

[selenium/docs/api : ElementNotVisibleException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/ElementNotVisibleException.html)

### Причины

### Решение

Решение: добавить ожидание видимости веб элемента на странице или сделать веб элемент видимым через выполнение JS скрипта.

*Пример*

```java
try {
    WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
    wait.Until(ExpectedConditions.visibilityOfElementLocated(By.id("submit"));
    try {
        driver.findElement(By.id("submit")).click();
    } catch (WebDriverException e) {
        System.out.println(e);
    }
} catch (TimeOutException e)
    System.out.println("Не найден веб элемент на странице");
}
```

ElementNotVisibleException

This one is a bit different than the NoSuchElementException, 
because it means that the element was found in the DOM, but it is not visible on the page. 
This also means that we cannot interact with the element, 
so we can’t click, send keys, or perform other actions on it. It can happen if:

The element is hidden.
The locator strategy you are using finds more elements with the same locator, and the first one is not visible.
To fix this, first make sure that you are using a unique locator, and that you are identifying the correct element on the page.

If your locator is good, then you can add a wait, that checks when the element is visible:

*Пример*

```java
WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
IWebElement LoginButton = wait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.ElementIsVisible(By.Id("login")));
```

ElementNotVisibleException:

This exception occurs when the locators(id/xpath/css selector) we have provided 
in the selenium program code are trying to find the web element which is hidden from displaying on the webpage.

For example:

In the code below, if the type of button with id ‘submit’ is ‘hidden’ in HTML then an ElementNotVisibleException will be thrown.

*Пример*

```java
driver.findElement(By.id("submit"));
```

Handling:

*Пример*

```java
try{
driver.findElement(By.id("submit"));
}catch(ElementNotVisibleException e){
System.out.println(e.getMessage());
}
```

In this case, the exception occurs even if the page has not loaded completely.

## InvalidElementStateException

***InvalidElementStateException*** — исключение, которое вызывается, когда

[selenium/docs/api : InvalidElementStateException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/InvalidElementStateException.html)

### Причины

### Решение

It occurs when command can’t be finished when the element is invalid.

***

# 5. Сложные действия с веб элементами

## InvalidCoordinatesException

***InvalidCoordinatesException*** — исключение, которое вызывается, когда
Indicates that the coordinates provided to an interactions operation are invalid. 
This, most likely, means that a move operation was provided with invalid coordinates or that an action that depends on mouse position (like click) was not preceded by a move operation.

[selenium/docs/api : InvalidCoordinatesException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/interactions/InvalidCoordinatesException.html)

### Причины

### Решение

## MoveTargetOutOfBoundsException

***MoveTargetOutOfBoundsException*** — исключение, которое вызывается, когда

[selenium/docs/api : MoveTargetOutOfBoundsException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/interactions/MoveTargetOutOfBoundsException.html)

### Причины

### Решение

It takes place if the target provided to the ActionChains move() methodology is not valid. For Example, out of the document.

## ElementNotSelectableException

***ElementNotSelectableException*** — исключение, которое вызывается, когда

[selenium/docs/api : ElementNotSelectableException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/ElementNotSelectableException.html)

### Причины

### Решение

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

***

# 6. Окна и вкладки

## NoSuchWindowException

***NoSuchWindowException*** — исключение, которое вызывается, когда

[selenium/docs/api : NoSuchWindowException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/NoSuchWindowException.html)

### Причины

### Решение

NoSuchWindowException comes under NotFoundException class. This is thrown when WebDriver tries to switch to an invalid window.

The below code can throw org.openqa.selenium.NoSuchWindowException if the window handle doesn’t exist or is not available to switch.

*Пример*

```java
driver.switchTo().window(handle_1);
```

Avoiding-And-Handling: We would use window handles to get the set of active windows and then perform actions on the same.

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

### Решение

When WebDriver is trying to switch to an invalid frame, NoSuchFrameException under NotFoundException class is thrown.

The below code can throw org.openqa.selenium.NoSuchFrameException if a frame "frame_11" doesn’t exist or is not available.

*Пример*

```java
driver.switchTo().frame("frame_11");
```

Exception Handling:

*Пример*

```java
try {
driver.switchTo().frame("frame_11");
} catch (NoSuchFrameException e)
```

In this case, the exception is thrown even if the frame is not loaded.

Avoiding-And-Handling: Try to give a wait command.

In the example below, WebDriver waits for 10 seconds for the frame to be available. If the frame is available and still there is an exception, then it is caught.

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

### Решение

NoAlertPresentException under NotFoundException is thrown when WebDriver tries to switch to an alert, which is not available.

org.openqa.selenium.NoAlertPresentException will be thrown If below automation code calls accept() operation on Alert() class when an alert is not yet on the screen.

*Пример*

```java
driver.switchTo().alert().accept();
```

Exception Handling:

*Пример*

```java
try {
driver.switchTo().alert().accept();
} catch (NoSuchAlertException e)
```

In this case, the exception is thrown even if the alert is not loaded completely.

Avoiding-And-Handling: Always use explicit or fluent wait for a particular time in all cases where an alert is expected. If the alert is available and still there is an exception, then it is caught.

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

The NoAlertPresentException is thrown when Selenium is trying to interact with an alert that is not loaded on the webpage. If the alert is indeed not loaded at all, then you may have found a bug in your AUT, or perhaps you are missing the steps that lead to the alert opening. Another reason can be that the alert is displayed slower than Selenium performs the actions. In this case, you can add an implicit wait to your code, so the action performed on the alert is delayed by a few seconds:

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

This exception is thrown when an alert is present on the page, preventing you from interacting with the elements. You can dismiss or accept the alert, as needed, and move on with the test steps:

*Пример*

```java
// Dismiss the alert
driver.SwitchTo().Alert().Dismiss();
// Accept the alert
driver.SwitchTo().Alert().Accept();
```

***

# 7. Ожидание

## TimeoutException

***TimeoutException*** — исключение, которое возникает, когда команда не завершается в достаточный промежуток времени.
***TimeoutException*** - исключение, которое вызывается, когда выполнение какой-либо
команды не завершилось в отведенный промежуток времени.

[selenium/docs/api : TimeoutException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/TimeoutException.html)

### Причины

### Решение

Решение: настроить время ожидания загрузки страницы или добавить явное ожидание через выполнение JS скрипта.

*Пример*

```java
WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(30));
wait.until(
    webDriver -> ((JavascriptExecutor)webDriver)
        .executeScript("return document.readyState")
        .equals("complete"));
driver.get("https://www.softwaretestinghelp.com");
```

TimeoutException
This exception will be thrown when the page or element was not loaded after the specified wait time. To overcome this, you can increase the wait time, if you are using an implicit wait, or better yet, replace the implicit wait with an explicit wait.

TimeoutException:
This exception occurs when there is not enough time for a command to be completed i.e. the element searched wasn’t found at the specific time.

For example:

*Пример*

```java
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.get("https://www.example.com");
```

In the above program, an implicit wait includes 10 seconds. 
If the page "www.example.com" doesn’t load in 10 seconds, then a TimeoutException will occur.

***

# 8. Разные

## JavascriptException

***JavascriptException*** — исключение, которое вызывается, когда

[selenium/docs/api : JavascriptException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/JavascriptException.html)

### Причины

This issue occurs while executing JavaScript given by the user.

### Решение



## ScreenshotException

***ScreenshotException*** — исключение, которое вызывается, когда

[selenium/docs/api : ScreenshotException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/remote/ScreenshotException.html)

### Причины

It is not possible to capture a screen.

### Решение

