* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

# 6. Окна и вкладки

## NoSuchWindowException

***NoSuchWindowException*** — исключение, которое вызывается, когда WebDriver пытается переключиться на недопустимое окно.
Это происходит, когда вы пытаетесь переключиться на новое окно (или вкладку), которое не может быть найдено.
текущий список окон не обновляется. Предыдущее окно не существует, и вы не можете переключиться на него.
Это исключение выдается, когда целевое окно, к которому осуществляется переключение, не существует. 
Об этих сценариях можно позаботиться, используя window_handles, чтобы получить текущий набор активных окон. 
Ручки окон можно использовать для выполнения соответствующих действий над ними.

[selenium/docs/api : NoSuchWindowException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/NoSuchWindowException.html)

### Причины

* Возможной основной причиной может быть неверный адрес окна.
* Переключаемое окно не существует
Это исключение возникает, когда WebDriver пытается переключиться на недопустимое окно. 
Приведенный ниже код может вызвать исключение NoSuchWindowException, если дескриптор окна не существует или недоступен для переключения.
* Дескриптор окна не существует или недоступен для переключения
  в случае, если мы пытаемся переключиться на окно, но целевое окно отсутствует.
*Пример*

```java
driver.switchTo().window(handle_1);
```

### Решение

* Использовать дескрипторы окон, чтобы получить набор активных окон, а затем выполнять действия над ними.
  Вы можете решить эту проблему, получив все дескрипторы окон, а затем переключившись на правильный.
  Чтобы обработать это исключение, используйте методы веб-драйвера, называемые «driver.getWindowHandles()».
* получить список дескрипторов окна с помощью driver.getWindowHandles() и переключиться на один из дескрипторов, присутствующих в данный конкретный момент времени.
*Пример*

В приведенном ниже примере для каждого дескриптора окна выполняется переключение драйвера на. Поэтому шансы передать неверный параметр окна уменьшаются.

```java
for (String handle : driver.getWindowHandles()) {
try {
driver.switchTo().window(handle);
} catch (NoSuchWindowException e) {
System.out.println("An exceptional case");
}
}
```

Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (NoSuchWindowException e) {
    System.out.println(e);
}
```

## NoSuchFrameException

***NoSuchFrameException*** — исключение, которое вызывается, когда WebDriver пытается переключиться на недопустимый фрейм
кадр, на который нужно переключиться, не существует.

[selenium/docs/api : NoSuchFrameException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/NoSuchFrameException.html)

### Причины

Неверный адрес кадра
Переключаемая рамка не существует

Вы используете неверный идентификатор или имя фрейма. В этом случае убедитесь, что вы правильно определили кадр, на который хотите переключиться.
Рамка еще не загружена. Чтобы решить эту проблему, вы можете использовать решение выше и добавить неявное ожидание.
Фрейм вложен в другой фрейм. В этом случае вы должны сначала переключиться на родительский фрейм, а затем на фрейм, который вы хотите использовать.
Вложенные фреймы в HTML

если фрейм "frame_11" не существует или недоступен.
Приведенный ниже код может вызвать исключение org.openqa.selenium.NoSuchFrameException, если фрейм «frame_11» не существует или недоступен.

*Пример*

```java
driver.switchTo().frame("frame_11");
```

### Решение
проверку работоспособности относительно режима переключения на фрейм. 
Проверьте правильность используемого индекса кадра. 
Можно добавить дополнительное ожидание в несколько миллисекунд (мс), чтобы убедиться, что загрузка кадра завершена.
Попробуйте дать команду ожидания.

*Пример*

В приведенном ниже примере WebDriver ожидает 10 секунд, пока кадр станет доступным.
Если кадр доступен и все же есть исключение, то оно перехвачено.

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



*Пример*

В этом примере, чтобы взаимодействовать с элементами внутри «frame-left», вам сначала нужно переключиться на «frame-top»:

```java
driver.switchTo().frame("frame-top");
driver.switchTo().frame("frame-left");
```

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

## NoAlertPresentException

***NoAlertPresentException*** — исключение, которое вызывается, когда WebDriver пытается переключиться на оповещение, которое недоступно.

[selenium/docs/api : NoAlertPresentException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/NoAlertPresentException.html)

### Причины

Если оповещение действительно вообще не загружено, возможно, вы нашли ошибку в своей AUT или, 
возможно, вы пропустили шаги, ведущие к открытию оповещения.
Другая причина может заключаться в том, что оповещение отображается медленнее, чем Selenium выполняет действия. 

*Пример*

NoAlertPresentException будет выброшено, 
если приведенный ниже код автоматизации вызывает операцию accept() в классе Alert(), когда предупреждение еще не отображается на экране.

```java
driver.switchTo().alert().accept();
```

### Решение

В этом случае вы можете добавить неявное ожидание в свой код,
поэтому действие, выполняемое с предупреждением, задерживается на несколько секунд:
Всегда используйте явное или плавное ожидание 
в течение определенного времени во всех случаях, когда ожидается предупреждение. 
Если оповещение доступно и все еще есть исключение, то оно перехватывается.

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


Ниже пример перехвата исключения.

*Пример*

```java
try {
driver.switchTo().alert().accept();
} catch (NoSuchAlertException e)
```

## UnhandledAlertException

***UnhandledAlertException*** — исключение, которое вызывается, когда наличии неизвестного оповещения.

Это исключение возникает, когда на странице присутствует предупреждение, не позволяющее вам взаимодействовать с элементами. 
При необходимости вы можете отклонить или принять оповещение и перейти к этапам тестирования:

[selenium/docs/api : UnhandledAlertException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/UnhandledAlertException.html)

### Причины

на веб-странице появляется неожиданное предупреждение.

### Решение

отклонить предупреждение с помощью тестового примера, если ожидается появление предупреждения.

*Пример*

В приведенном выше примере Test case явно отклоняет предупреждение. Это гарантирует, что остальная часть тестового примера пройдет так, как ожидалось.

```java
@Test
public void testCase6(){
        webDriver.navigate().to(file);
        webDriver.switchTo().alert().dismiss();
        String val = webDriver.findElement(By.id("attr")).getAttribute("custom");
        }
```

Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (UnexpectedTagNameException e) {
    System.out.println(e);
}
```
