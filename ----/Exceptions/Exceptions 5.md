* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

# 5. Сложные действия с веб элементами

## InvalidCoordinatesException

***InvalidCoordinatesException*** — исключение, которое вызывается, 
когда неверные координаты предлагаются операции взаимодействия.

Это исключение возникает, когда вы пишете команду для выполнения действия, 
указав координаты, а WebDriver не может действовать в соответствии с заданными координатами.

Это также означает, что действию, которое зависит от положения мыши (например, щелчку), 
не предшествовала операция перемещения или операция перемещения была предоставлена с недопустимыми координатами.

Указывает, что координаты, предоставленные операции взаимодействия, недействительны.
Скорее всего, это означает, что операции перемещения были предоставлены недопустимые координаты или что действию, 
которое зависит от положения мыши (например, клику), не предшествовала операция перемещения.

[selenium/docs/api : InvalidCoordinatesException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/interactions/InvalidCoordinatesException.html)

### Причины

*
*

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
Это исключение Selenium возникает, если цель, предоставляемая методу перемещения ActionChains(), 
выходит за границы, то есть недействительна или находится за пределами документа/веб-страницы.

Прежде чем вызывать метод перемещения класса ActionChains(), вы всегда должны проверять местоположение, 
которое мы пытаемся переместить, и выполнять то же самое, только если местоположение присутствует на экране.

Это исключение возникает, когда определенная цель не существует в заданном размере.

[selenium/docs/api : MoveTargetOutOfBoundsException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/interactions/MoveTargetOutOfBoundsException.html)

### Причины

*
*

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

## ElementNotSelectableException

***ElementNotSelectableException*** — исключение, которое вызывается, когда

Это исключение относится к классу InvalidElementStateException. ElementNotSelectableException указывает, что веб-элемент присутствует на веб-странице, но не может быть выбран.
В этом случае выдается исключение, даже если элемент становится активным через некоторое время.

Это исключение Selenium возникает, когда целевой элемент присутствует в DOM, но с ним нельзя взаимодействовать,
поскольку этот элемент нельзя выбрать. Например, это исключение будет выброшено при взаимодействии с элементом скрипта.

[selenium/docs/api : ElementNotSelectableException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/ElementNotSelectableException.html)

### Причины
Атрибут веб-элемента отключен
Например, приведенный ниже код может вызвать исключение ElementNotSelectableException, если идентификатор «swift» отключен.

*Пример*

```java
Select dropdown = new Select(driver.findElement(By.id("swift")));
```

### Решение
необходимо использовать команду ожидания.
мы можем добавить команду ожидания, чтобы дождаться, пока элемент станет доступным для клика. 
Если все еще есть исключение, оно перехватывается.

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

Ниже пример перехвата исключения.

*Пример*

```java
try {
Select dropdown = new Select(driver.findElement(By.id("swift")));
} catch (ElementNotSelectableException e)
```