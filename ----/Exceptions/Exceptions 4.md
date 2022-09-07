* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

# 4. Простые действия с веб элементами

## NoSuchElementException

***NoSuchElementException*** — исключение, которое вызывается, когда **Selenium WebDriver** не может найти элементы.

[selenium/docs/api : NoSuchElementException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/NoSuchElementException.html)

### Причины

* Некорректный локатор веб элемента в методе **findElement**
* Веб страница полностью не загрузилась
* Веб элемент отсутствует в **DOM** на момент вызова
* Веб элемент невидим на странице

*Пример*

Веб элемент имеет **id = "submit"**, но тестировщик указал неправильный id в коде.

```java
driver.findElement(By.id("submt")).click();
```

### Решение

* Проверка корректности и уникальности локаторов веб элементов
* Добавление ожидания загрузки веб страницы
* Добавление ожидания появления веб элемента на странице
* Установка видимости веб элемента

*Пример*

```java
try {
    WebDriverWait wait = new WebDriverWait(driver, TimeSpan.fromSeconds(10));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
    try {
        driver.findElement(By.id("submit")).click();
    } catch (WebDriverException e) {
        System.out.println(e);
    }
} catch (TimeOutException e) {
    System.out.println("Не найден веб элемент на странице");
}
```

Ниже пример перехвата исключения.

*Пример*

```java
try {
    driver.findElement(By.id("submit")).click();
} catch (NoSuchElementException e) {
    System.out.println(e);
}
```

## StaleElementReferenceException

***StaleElementReferenceException*** — исключение, которое вызывается, когда ссылка на элемент больше не действительна.
То есть, если элемент доступен в **DOM** на момент поиска, но спустя время, в момент его вызова, в **DOM** его больше нет.

[selenium/docs/api : StaleElementReferenceException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/StaleElementReferenceException.html)

### Причины

* Веб элемент был полностью удален со страницы

Наиболее частой причиной этого является то, что страница с искомым элементом, была обновлена,
или пользователь перешел на другую страницу. Реже, но все также достаточно распространен случай,
когда библиотека **JS** удалила элемент и заменила его элементом с таким же ID или атрибутами.
В этом случае, несмотря на то, что замененные элементы могут выглядеть похожими на оригиналы, они отличаются.

**Selenium Driver** не имеет возможности определить, что замененный элемент на самом деле тот же, что и ожидался.
Если есть уверенность, что элемент заменен идентичным и присутствует на странице,
то нужно выполнить поиск элемента снова и получить актуальную ссылку на него.

* Веб элемент больше не подключен к **DOM** модели

Общей техникой, используемой для имитации вкладок интерфейса в веб-приложениях,
является подготовка нескольких элементов **div** для каждой вкладки,
но прикреплен к **DOM** в один момент времени только один из них, остальные же сохранены в переменные.
В этом случае вполне возможно, что ваш код может иметь ссылку на элемент,
который больше не прикреплен к **DOM** (то есть его предком является **.documentElement**).

**Selenium Driver** вызывает исключение **StaleElementReferenceException** в этом случае, несмотря на то,
что элемент существует, потому, что ссылка на элемент все равно потеряна.
Вам придется заменять ее, выполняя поиск элемента каждый раз, после того как он будет прикреплен к **DOM**.

* Веб элемент меняет свой тип, но сохраняет тот же локатор поиска (JQuery и др.)

Это крайне редкий случай, происходит он когда, например,
поле **input** при нажатии или получении фокуса меняет значение type c **text** на **password**.

### Решение

поиск веб элемента перед выполнением с ним действия
применение динамического xpath запроса

*Пример*

```java
try {
    driver.findElement(By.xpath("//*[contains(@id, 'firstname')]")).sendKeys("Aaron");
} catch (StaleElementReferenceException e)
```
Ниже пример перехвата исключения.
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

Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (UnexpectedTagNameException e) {
    System.out.println(e);
}
```

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
Ниже пример перехвата исключения.

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

Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (UnexpectedTagNameException e) {
    System.out.println(e);
}
```

## ElementNotVisibleException

***ElementNotVisibleException*** — исключение, которое вызывается, когда элемент присутствует в **DOM**,
но он невидим и поэтому взаимодействовать с ним невозможно.

***ElementNotVisibleException*** - исключение, которое вызывается, если элемент был найдем в **DOM**, но он невидим на странице.

[selenium/docs/api : ElementNotVisibleException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/ElementNotVisibleException.html)

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

Решение: добавить ожидание видимости веб элемента на странице или сделать веб элемент видимым через выполнение JS скрипта.
Ниже пример перехвата исключения.

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

Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (UnexpectedTagNameException e) {
    System.out.println(e);
}
```
