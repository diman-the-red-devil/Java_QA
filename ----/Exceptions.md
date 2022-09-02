
### StaleElementReferenceException

***StaleElementReferenceException*** — исключение, которое возникает, когда ссылка на элемент больше не действительна.

То есть, если элемент доступен в **DOM** на момент поиска,
но спустя время, в момент его вызова, в **DOM** его больше нет.

[selenium/docs/api : StaleElementReferenceException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/StaleElementReferenceException.html)

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


[selenium/docs/api : StaleElementReferenceException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/StaleElementReferenceException.html)

### 3.2.2. ElementClickInterceptedException

***ElementClickInterceptedException*** - исключение, которое возникает, когда команда не может быть завершена,
поскольку элемент, получающий событие, скрывает целевой элемент.

[selenium/docs/api : ElementClickInterceptedException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/ElementClickInterceptedException.html)

### 3.2.3. ElementNotInteractableException

***ElementNotInteractableException*** - исключение, которое возникает, когда элемент присутствует в **DOM**,
но с таким элементом невозможно взаимодействовать (элемент не находится в области просмотра).

[selenium/docs/api : ElementNotInteractableException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/ElementNotInteractableException.html)

### 3.2.4. ElementNotVisibleException

***ElementNotVisibleException*** - исключение, которое возникает, когда элемент присутствует в **DOM**,
но он невидим и поэтому взаимодействовать с ним невозможно.

***ElementNotVisibleException*** - исключение, которое вызывается, если элемент был найдем в **DOM**, но он невидим на странице.

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

[selenium/docs/api : ElementNotVisibleException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/ElementNotVisibleException.html)

### 5.6.4. NoSuchElementException

***NoSuchElementException*** - исключение, которое вызывается, если элемент отсутствует в **DOM** на момент вызова.

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

### 3.2.5. TimeoutException

***TimeoutException*** — исключение, которое возникает, когда команда не завершается в достаточный промежуток времени.
***TimeoutException*** - исключение, которое вызывается, когда выполнение какой-либо
команды не завершилось в отведенный промежуток времени.

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

[selenium/docs/api : TimeoutException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/TimeoutException.html)