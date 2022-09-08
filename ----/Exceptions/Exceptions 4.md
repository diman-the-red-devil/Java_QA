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

* Страница с искомым элементом, была обновлена

Веб элемент был полностью удален со страницы.

* Пользователь перешел на другую страницу

На данной странице уже нет найденного раннее веб элемента.

*Пример*

```java
WebElement firstName = driver.findElement(By.id("firstname"));
driver.switchTo().window(Child_Window);
element.sendKeys("Aaron");
```

* Библиотека **JS** удалила веб элемент и заменила его веб элементом с таким же ID или атрибутами
      
В этом случае, несмотря на то, что замененные веб элементы могут выглядеть похожими на оригиналы, они отличаются.
**Selenium Driver** не имеет возможности определить, что замененный элемент на самом деле тот же, что и ожидался.

* Веб элемент больше не подключен к **DOM** модели

Общей техникой, используемой для имитации вкладок интерфейса в веб-приложениях,
является подготовка нескольких элементов **div** для каждой вкладки,
но прикреплен к **DOM** в один момент времени только один из них, остальные же сохранены в переменные.
В этом случае вполне возможно, что ваш код может иметь ссылку на элемент,
который больше не прикреплен к **DOM** (то есть его предком является **.documentElement**).

* Веб элемент поменял свойства

Скажем, **id** поля имени пользователя — **firstname_1**, а **XPath** будет **//*[@id='firstname_1']**.
Когда вы снова откроете страницу, **id** может измениться, скажем, на **firstname _11**.
В этом случае тест завершится ошибкой, так как **WebDriver** не сможет найти элемент.
В этом случае будет выброшено исключение **StaleElementReferenceException**.

* Веб элемент меняет свой тип, но сохраняет тот же локатор поиска

Это крайне редкий случай, происходит он когда, например,
поле **input** при нажатии или получении фокуса меняет значение type c **text** на **password**.

### Решение

* Поиск веб элемента и получение актуальной ссылки на него перед выполнением действия
* Проверка выполнения действия на странице с нужным веб элементом
* Применение динамического **Xpath** запроса

*Пример*

```java
try {
    driver.findElement(By.xpath("//*[contains(@id, 'firstname')]")).sendKeys("Aaron");
} catch (StaleElementReferenceException e)
```

Обновление страницы и снова попытаться найти элемент

*Пример*

```java
driver.navigate().refersh();
driver.findElement(By.xpath("xpath here")).click();
```

Или вы можете дождаться загрузки элемента, прежде чем манипулировать им.
Опять же, вы можете сделать это, используя явное ожидание.

*Пример*

```java
wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table")));
wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf("table")));
```

*Пример*

```java
for(int i=0; i<=2;i++){
try{
driver.findElement(By.xpath("xpath here")).click();
break;
}
catch(Exception e){
Sysout(e.getMessage());
}
}
```

Ниже пример перехвата исключения.

*Пример*

```java
try {
    driver.findElement(By.id("submit")).click();
} catch (StaleElementReferenceException e) {
    System.out.println(e);
}
```

[selenium/docs/api : StaleElementReferenceException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/StaleElementReferenceException.html)

## ElementClickInterceptedException

***ElementClickInterceptedException*** — исключение, которое вызывается, когда команда не может быть завершена,
поскольку элемент, получающий событие, скрывает целевой элемент.

[selenium/docs/api : ElementClickInterceptedException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/ElementClickInterceptedException.html)

### Причины

* Веб элемент скрыт другим веб элементом
* Веб элемент 

### Решение

* Прокрутка
* Отображение веб элемента
* Доп действия

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
Actions _action = new Actions(driver);
_action.MoveToElement(elementToClick).Click();
```


## ElementNotInteractableException

***ElementNotInteractableException*** — исключение, которое вызывается, когда элемент присутствует в **DOM**,
но с таким элементом невозможно взаимодействовать (элемент не находится в области просмотра).

[selenium/docs/api : ElementNotInteractableException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/ElementNotInteractableException.html)

### Причины

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

## ElementNotVisibleException

***ElementNotVisibleException*** — исключение, которое вызывается, когда элемент присутствует в **DOM**,
но он невидим и поэтому взаимодействовать с ним невозможно (отправить ключи или выполнить другие действия над ним).
***ElementNotVisibleException*** - исключение, которое вызывается, если элемент был найдем в **DOM**, 
но он невидим на странице.

[selenium/docs/api : ElementNotVisibleException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/ElementNotVisibleException.html)

### Причины

* Веб элемент скрыт
* Веб элемент невидим

*Пример*

id «submit» «скрыт» в HTML, будет выброшено исключение org.openqa.selenium.ElementNotVisibleException.

```java
driver.findElement(By.id("submit")).click();
```


* Используемая вами стратегия локатора находит больше элементов с одним и тем же локатором, а первый не виден.

### Решение

* Добавить ожидание видимости веб элемента на странице 
* Сделать веб элемент видимым через выполнение JS скрипта 
* максимизация окна браузера
* прокрутка до элемента

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

Ниже пример перехвата исключения.

*Пример*

```java
try {
...
} catch (UnexpectedTagNameException e) {
    System.out.println(e);
}
```

## InvalidElementStateException

***InvalidElementStateException*** — исключение, которое вызывается, когда элемент не находится в интерактивном состоянии, 
необходимом WebDriver для выполнения операции.

Это исключение Selenium возникает, когда команда не может быть выполнена, поскольку элемент не находится в допустимом состоянии или элемент не может выполнять это действие. Это может быть вызвано попыткой выполнения такой операции, как очистка элемента, над веб-элементом, который нельзя редактировать или сбрасывать.

Чтобы обработать такое исключение в автоматизации тестирования Selenium, рекомендуется дождаться включения этого элемента, прежде чем с ним будет выполнено желаемое действие.

[selenium/docs/api : InvalidElementStateException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/InvalidElementStateException.html)

### Причины

Причина — в случае, если состояние элемента не соответствует желаемому действию.
Разрешение — убедитесь, что элемент доступен для выполнения требуемой операции, 
ожидая желаемого ExpectedCondition в явном ожидании.

*Пример*

пример с использованием пользовательской html-страницы с отключенным текстовым полем.

```java
@Test
public void googleTest3() throws MalformedURLException {

       webDriver.navigate().to(file);
    webDriver.findElement(By.cssSelector("input[value='hi'")).sendKeys("hi");
}
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
