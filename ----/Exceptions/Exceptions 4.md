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

*Пример*

В примере ниже в **Xpath** выражении ошибка.

Должно быть:

```xpath
(//*[@class="ui-link menu-desktop__root-title"])[5]
```

А записано:

```xpath
(//*[@class="ui-link menu-desktop__root"])
```

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    String xpath = "(//*[@class=\"ui-link menu-desktop__root\"])";
    WebElement element = driver.findElement(By.xpath(xpath));
    element.click();
}
```

В результате вызывается исключение **NoSuchElementException**

```text
org.openqa.selenium.NoSuchElementException: no such element: 
Unable to locate element: {"method":"xpath","selector":"(//*[@class="ui-link menu-desktop__root"])"}
```

* Веб страница полностью не загрузилась

*Пример*

В примере ниже установлен таймаут загрузки страницы в 8 секунд.
За это время веб элемент не успевает отобразиться на странице.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
    driver.get("https://www.dns-shop.ru/");
    String xpath = "(//*[@class=\"ui-link menu-desktop__root-title\"])[5]";
    WebElement element = driver.findElement(By.xpath(xpath));
    element.click();
}
```

В результате вызывается исключение **NoSuchElementException**

```text
org.openqa.selenium.NoSuchElementException: no such element: 
Unable to locate element: {"method":"xpath","selector":"(//*[@class="ui-link menu-desktop__root-title"])[5]"}
```

* Веб элемент не видим на странице

*Пример*

В примере ниже выполняется попытка перейти по ссылке "Смартфоны".
Но ссылка находится в блоке, который отображается только при наведении курсора мыши на ссылку "Смартфоны и гаджеты".

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    driver.findElement(By.xpath("//span[text()=\"Всё верно\"]/parent::button")).click();
    Actions actions = new Actions(driver);
    actions.moveToElement(
        driver.findElement(
            By.xpath("(//a[contains(text(), \"Смартфоны и гаджеты\")])[1]")))
        .perform();
    driver.findElement(By.xpath("//a[text()=\"Смартфоны\"]")).click();
}
```

В результате вызывается исключение **NoSuchElementException**

```text
org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//a[text()="Смартфоны"]"}
```

* Веб элемент отсутствует в **DOM** на момент вызова

### Решение

* Проверка корректности и уникальности локаторов веб элементов

*Пример*

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    String xpath = "(//*[@class=\"ui-link menu-desktop__root-title\"])[5]";
    WebElement element = driver.findElement(By.xpath(xpath));
    element.click();
}
```

* Добавление ожидания загрузки веб страницы

*Пример*

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    driver.get("https://www.dns-shop.ru/");
    String xpath = "(//*[@class=\"ui-link menu-desktop__root-title\"])[5]";
    WebElement element = driver.findElement(By.xpath(xpath));
    element.click();
}
```

* Добавление явных ожиданий при работе с веб элементами

*Пример*

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    String xpath1 = "//span[text()=\"Всё верно\"]/parent::button";
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
    driver.findElement(By.xpath(xpath1)).click();

    String xpath2 = "(//a[contains(text(), \"Смартфоны и гаджеты\")])[1]";
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath2)));
    Actions actions = new Actions(driver);
    actions.moveToElement(driver.findElement(By.xpath(xpath2))).perform();

    String xpath3 = "//a[text()=\"Смартфоны\"]";
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath3)));
    driver.findElement(By.xpath(xpath3)).click();
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
        String xpath = "(//*[@class=\"ui-link menu-desktop__root\"])";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    } catch (NoSuchElementException e) {
        logger.info("NoSuchElementException: " + e.getRawMessage());
    }
}
```

## StaleElementReferenceException

***StaleElementReferenceException*** — исключение, которое вызывается, когда ссылка на элемент больше не действительна.
То есть, если элемент доступен в **DOM** на момент поиска, но спустя время, в момент его вызова, в **DOM** его больше нет.

[selenium/docs/api : StaleElementReferenceException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/StaleElementReferenceException.html)

### Причины

* Страница с искомым веб элементом, была обновлена

*Пример*

В примере ниже сначала веб элемент был найден на странице. 
Затем веб страница была обновлена.
Найденный веб элемент был полностью удален со страницы.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    String xpath = "//a[text()=\"Офис и сеть\"]";
    WebElement element = driver.findElement(By.xpath(xpath));
    driver.navigate().refresh();
    element.click();
}
```

В результате вызывается исключение **StaleElementReferenceException**

```text
org.openqa.selenium.StaleElementReferenceException: stale element reference: 
element is not attached to the page document
```

* Переход на другую страницу / вкладку / окно

*Пример*

В примере ниже сначала веб элемент был найден на странице.
Далее был выполнен переход на новую вкладку и открыта та же страница.
На данной странице уже нет найденного раннее веб элемента.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    String xpath = "//a[text()=\"Офис и сеть\"]";
    WebElement element = driver.findElement(By.xpath(xpath));
    driver.switchTo().newWindow(WindowType.TAB);
    driver.get("https://www.dns-shop.ru/");
    element.click();
}
```

В результате вызывается исключение **StaleElementReferenceException**

```text
org.openqa.selenium.StaleElementReferenceException: stale element reference: 
element is not attached to the page document
```

* Библиотека **JS** удалила веб элемент и заменила его веб элементом с таким же ID или атрибутами
      
Несмотря на то, что замененные веб элементы могут выглядеть похожими на оригиналы, они отличаются.
**Selenium Driver** не может определить, что замененный веб элемент на самом деле тот же, что и ожидался.

В результате вызывается исключение **StaleElementReferenceException**.

* Веб элемент больше не подключен к **DOM** модели

Общей техникой, используемой для имитации вкладок интерфейса в веб-приложениях,
является подготовка нескольких элементов **div** для каждой вкладки,
но прикреплен к **DOM** в один момент времени только один из них, остальные же сохранены в переменные.
Код может иметь ссылку на веб элемент, который больше не прикреплен к **DOM** 
(то есть его предком является **.documentElement**).

В результате вызывается исключение **StaleElementReferenceException**.

### Решение

* Поиск веб элемента и получение актуальной ссылки на него перед выполнением действия

*Пример*

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    String xpath = "//a[text()=\"Офис и сеть\"]";
    WebElement element;
    element = driver.findElement(By.xpath(xpath));
    driver.navigate().refresh();
    element = driver.findElement(By.xpath(xpath));
    element.click();
}
```

* Проверка открытия актуальной страницы / вкладки / окна с искомым веб элементом
* Проверка корректности локатора

Ниже пример перехвата исключения.

*Пример*

```java
    @Test
public void test() {
    try {
        driver.manage().window().maximize();
        driver.get("https://www.dns-shop.ru/");
        String xpath = "//a[text()=\"Офис и сеть\"]";
        WebElement element = driver.findElement(By.xpath(xpath));
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.dns-shop.ru/");
        element.click();
    } catch (StaleElementReferenceException e) {
        logger.info("StaleElementReferenceException: " + e.getRawMessage());
    }
}
```

[selenium/docs/api : StaleElementReferenceException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/StaleElementReferenceException.html)

## ElementClickInterceptedException

***ElementClickInterceptedException*** — исключение, которое вызывается, когда команда не может быть завершена,
поскольку веб элемент, получающий событие, скрывает целевой элемент.

[selenium/docs/api : ElementClickInterceptedException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/ElementClickInterceptedException.html)

### Причины

* Веб элемент скрыт другим веб элементом

*Пример*

В примере ниже найденный веб элемент скрывается за другим веб элементом.
В результате клик получает тот веб элемент, который скрывает искомый.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    String xpath = "//a[text()=\"Бытовая техника\"]";
    WebElement element = driver.findElement(By.xpath(xpath));
    element.click();
}
```

В результате вызывается исключение **ElementClickInterceptedException**

```text
org.openqa.selenium.ElementClickInterceptedException: 
element click intercepted: Element 
<a class="ui-link menu-desktop__root-title" href="/catalog/17a8e9b716404e77/bytovaya-texnika/">...</a> 
is not clickable at point (490, 142). 
Other element would receive the click: 
<button data-v-2858c94f="" class="base-ui-button-v2 base-ui-button-v2_medium base-ui-button-v2_grey 
```

* Другой веб элемент получил клик во время прокрутки / обновления страницы

*Пример*

В примере ниже найден веб элемент, далее выполнена прокрутка страницы до другого веб элемента.
После прокрутки выполнена попытка нажатия на первый веб элемент.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.findElement(By.xpath("//a[text()=\"Смартфоны и гаджеты\"]")).click();
    driver.findElement(By.xpath("//span[text()=\"Смартфоны и гаджеты\"]/ancestor::a")).click();
    driver.findElement(By.xpath("//span[text()=\"Смартфоны\"]/ancestor::a")).click();
    WebElement element = driver.findElement(By.xpath("//a[text()=\"На Android\"]"));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,1000);");
    wait.until(
        ExpectedConditions.presenceOfElementLocated(
            By.xpath("//span[text()=\"Объем встроенной памяти (ГБ)\"]")));
    element.click();
}
```

В результате вызывается исключение **ElementClickInterceptedException**

```text
org.openqa.selenium.ElementClickInterceptedException: 
element click intercepted: Element 
<a class="receipts__item ui-link" href="/catalog/recipe/3adda287f4d807eb/na-android/" data-receipt="3adda287f4d807eb">...</a> 
is not clickable at point (725, 16). 
Other element would receive the click: 
<input class="ui-input-search__input ui-input-search__input_presearch" name="q" value="" type="search" placeholder="Поиск по сайту" autocomplete="off">
```

### Решение

* Скрытие перекрывающего веб элемента

*Пример*

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    driver.findElement(By.xpath("//span[text()=\"Всё верно\"]")).click();
    driver.findElement(By.xpath("//a[text()=\"Бытовая техника\"]")).click();
}
```

* Ожидание завершения прокрутки / обновления страницы

*Пример*

```java
    @Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.findElement(By.xpath("//a[text()=\"Смартфоны и гаджеты\"]")).click();
    driver.findElement(By.xpath("//span[text()=\"Смартфоны и гаджеты\"]/ancestor::a")).click();
    driver.findElement(By.xpath("//span[text()=\"Смартфоны\"]/ancestor::a")).click();
    WebElement element = driver.findElement(By.xpath("//a[text()=\"На Android\"]"));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,1000);");
    wait.until(ExpectedConditions.presenceOfElementLocated(
    By.xpath("//span[text()=\"Объем встроенной памяти (ГБ)\"]")));
    js.executeScript("window.scrollBy(0,-1000);");
    wait.until(ExpectedConditions.presenceOfElementLocated(
    By.xpath("//a[text()=\"На Android\"]")));
    element.click();
}
```

* Изменение размера окна

Ниже пример перехвата исключения.

*Пример*

```java
@Test
public void test() {
    try {
        driver.manage().window().maximize();
        driver.get("https://www.dns-shop.ru/");
        String xpath = "//a[text()=\"Бытовая техника\"]";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    } catch (ElementClickInterceptedException e) {
        logger.info("ElementClickInterceptedException: " + e.getRawMessage());
    }
}
```

## ElementNotInteractableException

***ElementNotInteractableException*** — исключение, которое вызывается, когда веб элемент присутствует в **DOM**,
но с таким веб элементом невозможно взаимодействовать.

[selenium/docs/api : ElementNotInteractableException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/ElementNotInteractableException.html)

### Причины

* Веб элемент не виден

*Пример*

В примере ниже был найден веб элемент. 
Далее была нажата гармошка, которая скрыла этот веб элемент.
После была выполнена попытка нажатия на этот веб элемент.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.findElement(By.xpath("//a[text()=\"Смартфоны и гаджеты\"]")).click();
    driver.findElement(By.xpath("//span[text()=\"Смартфоны и гаджеты\"]/ancestor::a")).click();
    driver.findElement(By.xpath("//span[text()=\"Смартфоны\"]/ancestor::a")).click();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,1000);");
    wait.until(
        ExpectedConditions.presenceOfElementLocated(
            By.xpath("//span[text()=\"Объем встроенной памяти (ГБ)\"]")));
    driver.findElement(By.xpath("//span[text()=\"Объем встроенной памяти (ГБ)\"]")).click();
    WebElement element = driver.findElement(
        By.xpath("//span[text()=\"Объем встроенной памяти (ГБ)\"]/parent::a/following-sibling::div//span[text()=\"8 ГБ  \"]"));
    driver.findElement(By.xpath("//span[text()=\"Объем встроенной памяти (ГБ)\"]")).click();
    element.click();
}
```

В результате вызывается исключение **ElementNotInteractableException**

```text
org.openqa.selenium.ElementNotInteractableException: element not interactable
```

* Поиск веб элементов по локатору выдал больше одного веб элемента

*Пример*

В примере ниже было найдено множество веб элемент по заданному локатору.
Далее была попытка клика на веб элемент.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    driver.findElement(By.xpath("//a")).click();
}
```

В результате вызывается исключение **ElementNotInteractableException**

```text
org.openqa.selenium.ElementNotInteractableException: element not interactable
```

* У веб элемента установлено свойство **disabled = true**

*Пример*

В примере ниже у строки поиска установлено свойство **disabled = true**.
Далее была попытка с ней взаимодействовать.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.getElementsByName(\"q\")[1].disabled = true;");
    driver.findElement(By.xpath("(//input[@name=\"q\"])[2]")).sendKeys("Samsung");
}
```

В результате вызывается исключение **ElementNotInteractableException**

```text
org.openqa.selenium.ElementNotInteractableException: element not interactable
```

* У веб элемента установлено свойство **style.visibility = "hidden"**

*Пример*

В примере ниже у строки поиска установлено свойство **style.visibility = "hidden"**.
Далее была попытка с ней взаимодействовать.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByName(\"q\")[1].style.visibility = \"hidden\";");
    driver.findElement(By.xpath("(//input[@name=\"q\"])[2]")).sendKeys("Samsung");
}
```

В результате вызывается исключение **ElementNotInteractableException**

```text
org.openqa.selenium.ElementNotInteractableException: element not interactable
```

* У веб элемента установлено свойство **style.display = "none"**

*Пример*

В примере ниже у строки поиска установлено свойство **style.display = "none"**.
Далее была попытка с ней взаимодействовать.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByName(\"q\")[1].style.display = \"none\";");
    driver.findElement(By.xpath("(//input[@name=\"q\"])[2]")).sendKeys("Samsung");
}
```

В результате вызывается исключение **ElementNotInteractableException**

```text
org.openqa.selenium.ElementNotInteractableException: element not interactable
```

### Решение

* Отображение веб элемента

*Пример*

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.findElement(By.xpath("//a[text()=\"Смартфоны и гаджеты\"]")).click();
    driver.findElement(By.xpath("//span[text()=\"Смартфоны и гаджеты\"]/ancestor::a")).click();
    driver.findElement(By.xpath("//span[text()=\"Смартфоны\"]/ancestor::a")).click();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,1000);");
    wait.until(
        ExpectedConditions.presenceOfElementLocated(
            By.xpath("//span[text()=\"Объем встроенной памяти (ГБ)\"]")));
    driver.findElement(By.xpath("//span[text()=\"Объем встроенной памяти (ГБ)\"]")).click();
    WebElement element = driver.findElement(
        By.xpath("//span[text()=\"Объем встроенной памяти (ГБ)\"]/parent::a/following-sibling::div//span[text()=\"8 ГБ  \"]"));
    element.click();
}
```

* Установка свойства веб элемента **disabled = false**

*Пример*

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.getElementsByName(\"q\")[1].disabled = false;");
    driver.findElement(By.xpath("(//input[@name=\"q\"])[2]")).sendKeys("Samsung");
}
```

* Установка свойства веб элемента **style.visibility = "visible"**

*Пример*

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByName(\"q\")[1].style.visibility = \"visible\";");
    driver.findElement(By.xpath("(//input[@name=\"q\"])[2]")).sendKeys("Samsung");
}
```

* Установка свойства веб элемента **style.display = ""**

*Пример*

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByName(\"q\")[1].style.display = \"\";");
    driver.findElement(By.xpath("(//input[@name=\"q\"])[2]")).sendKeys("Samsung");
}
```

Ниже пример перехвата исключения.

*Пример*

```java
@Test
public void ttest() {
    try {
        driver.manage().window().maximize();
        driver.get("https://www.dns-shop.ru/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[text()=\"Смартфоны и гаджеты\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"Смартфоны и гаджеты\"]/ancestor::a")).click();
        driver.findElement(By.xpath("//span[text()=\"Смартфоны\"]/ancestor::a")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000);");
        wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[text()=\"Объем встроенной памяти (ГБ)\"]")));
        driver.findElement(By.xpath("//span[text()=\"Объем встроенной памяти (ГБ)\"]")).click();
        WebElement element = driver.findElement(
            By.xpath("//span[text()=\"Объем встроенной памяти (ГБ)\"]/parent::a/following-sibling::div//span[text()=\"8 ГБ  \"]"));
        driver.findElement(By.xpath("//span[text()=\"Объем встроенной памяти (ГБ)\"]")).click();
        element.click();
    } catch (ElementNotInteractableException e) {
        logger.info("ElementNotInteractableException: " + e.getRawMessage());
    }
}
```

## InvalidElementStateException

***InvalidElementStateException*** — исключение, которое вызывается, когда веб элемент не находится в состоянии, 
необходимом **Selenium WebDriver** для выполнения операции.

[selenium/docs/api : InvalidElementStateException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/InvalidElementStateException.html)

### Причины

* Выполнение операции, над веб элементом, к которому ее нельзя применить.

*Пример*

В примере ниже выполняется попытка применить к ссылке операцию очистки поля.
Однако состояние веб элемента не соответствует желаемому действию.

```java
@Test
public void test() {
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    driver.findElement(By.xpath("//a[text()=\"Смартфоны и гаджеты\"]")).clear();
}
```

В результате вызывается исключение **InvalidElementStateException**

```text
org.openqa.selenium.InvalidElementStateException: invalid element state
```
### Решение

* Проверка допустимости выполнения требуемой операции над веб элементом
* Ожидание желаемого состояния веб элемента посредством явного ожидания

Ниже пример перехвата исключения.

*Пример*

```java
    @Test
public void ttest() {
    try {
        driver.manage().window().maximize();
        driver.get("https://www.dns-shop.ru/");
        driver.findElement(By.xpath("//a[text()=\"Смартфоны и гаджеты\"]")).clear();
    } catch (InvalidElementStateException e) {
        logger.info("InvalidElementStateException: " + e.getRawMessage());
    }
}
```