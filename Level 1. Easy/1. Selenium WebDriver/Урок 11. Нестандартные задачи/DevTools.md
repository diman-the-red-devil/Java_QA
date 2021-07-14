# DevTools

## Класс DevTools

***DevTools*** -

Методы класса *DevTools*:

| Тип         | Метод                                            | Описание                      | 
|-------------|--------------------------------------------------|-------------------------------|
| <X> void    | addListener(Event<X> event, Consumer<X> handler) |       |
| void        | clearListeners()                                 |       |
| void        | close()                                          |       |
| void        | createSession()                                  |       |
| void        |	createSessionIfThereIsNotOne()                   |       |
| SessionID   | getCdpSession()                                  | получение геолокации |
| Domains     | getDomains()                                     | установка геолокации |
| <X> X       | send(Command<X> command)                         | установка геолокации |

[selenium/docs/api : DevTools](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/devtools/DevTools.html)

*Пример*

```java
ChromeDriver driver = new ChromeDriver();
DevTools devTools = driver.getDevTools();
devTools.createSession();
devTools.send(Performance.enable(Optional.empty()));
List<Metric> metricList = devTools.send(Performance.getMetrics());

driver.get("https://google.com");
driver.quit();

for(Metric m : metricList) {
    System.out.println(m.getName() + " = " + m.getValue());
}
```

### Simulating Device Mode

Most of the applications we build today are responsive to cater to the needs of the end
users coming from a variety of platforms, devices like phones, tablets, wearable devices, desktops  and orientations.

As testers, we might want to place our application in various dimensions to trigger the responsiveness of the application.

How can we use Selenium’s new CDP functionality to accomplish this?

The CDP command to modify the device’s metrics is Emulation.setDeviceMetricsOverride,
and this command requires input of width, height, mobile, and deviceScaleFactor.
These four keys are mandatory for this scenario, but there are several optional ones as well.

In our Selenium tests, we could use the DevTools::send() method using the built-in setDeviceMetricsOverride() command,
however, this Selenium API accepts 12 arguments – the 4 that are required as well as 8 optional ones.
For any of the 8 optional arguments that we don’t need to send, we can pass Optional.empty().

However, to streamline this a bit by only passing the required parameters,
I’m going to use the raw executeCdpCommand() instead as shown in the code below.

*Пример*

```java
ChromeDriver driver;
driver = new ChromeDriver();

DevTools devTools = driver.getDevTools();
devTools.createSession();
Map deviceMetrics = new HashMap()
{{
    put("width", 600);
    put("height", 1000);
    put("mobile", true);
    put("deviceScaleFactor", 50);
}};
driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
driver.get("https://www.google.com");
```

### Simulate Network Speed

Many users access web applications via handheld devices which are connected to wifi or cellular networks.
It’s not uncommon to reach a weak network signal, and therefore a slower internet connection.

It may be important to test how your application behaves under such conditions
where the internet connection is slow (2G) or goes offline intermittently.

The CDP command to fake a network connection is Network.emulateNetworkConditions.
Information on the required and optional parameters for this command can be found in the documentation.

With access to Chrome DevTools, it becomes possible to simulate these scenarios. Lets see how.

*Пример*

```java
ChromeDriver driver;
driver = new ChromeDriver();

DevTools devTools = driver.getDevTools();
devTools.createSession();
devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
devTools.send(Network.emulateNetworkConditions(
    false,
    20,
    20,
    50,
    Optional.of(ConnectionType.CELLULAR2G)
));
driver.get("https://www.google.com");
```

### Mocking Geolocation

Testing the location-based functionality of applications such as different offers, currencies, taxation rules,
freight charges and date/time format for various geolocations is difficult  because setting up the infrastructure
for all of these physical geolocations is not a feasible solution.

With mocking the geolocation, we could cover all the aforementioned scenarios and more.

The CDP command to fake a geolocation is Emulation.setGeolocationOverride.
Information on the required and optional parameters for this command can be found in the documentation.

How can we achieve this with Selenium? Let’s walk through the sample code.

*Пример*

```java
ChromeDriver driver = new ChromeDriver();

DevTools devTools = driver.getDevTools();
devTools.createSession();
devTools.send(Emulation.setGeolocationOverride(
    Optional.of(35.8235),
    Optional.of(-78.8256),
    Optional.of(100)));
driver.get("https://mycurrentlocation.net/");
```

### Capture HTTP Requests

With DevTools we can capture the HTTP requests the application is invoking and access the method, data, headers and lot more.

Lets see how to capture the HTTP requests, the URI and the request method with the sample code.

*Пример*

```java
driver = new ChromeDriver();
chromeDevTools = driver.getDevTools();
chromeDevTools.createSession();

chromeDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
chromeDevTools.addListener(Network.requestWillBeSent(),
entry -> {
System.out.println("Request URI : " + entry.getRequest().getUrl()+"\n"
+ " With method : "+entry.getRequest().getMethod() + "\n");
entry.getRequest().getMethod();
});
driver.get("https://www.google.com");
chromeDevTools.send(Network.disable());
```

### Access Console logs

We all rely on logs for debugging and analysing the failures.
While testing and working on an application with specific data or specific conditions,
logs help us in debugging and capturing the error messages,
giving more insights that are published in the Console tab of the Chrome DevTools.

We can capture the console logs through our Selenium scripts by calling the CDP Log commands as demonstrated below.

*Пример*

```java
driver = new ChromeDriver();
chromeDevTools = driver.getDevTools();
chromeDevTools.createSession();

chromeDevTools.send(Log.enable());
chromeDevTools.addListener(Log.entryAdded(),
logEntry -> {
System.out.println("log: "+logEntry.getText());
System.out.println("level: "+logEntry.getLevel());
});
driver.get("https://testersplayground.herokuapp.com/console-5d63b2b2-3822-4a01-8197-acd8aa7e1343.php");

```

### Capturing Performance Metrics

In today’s fast world while we are iteratively building software at such a fast pace,
we should aim to detect performance bottlenecks iteratively too.
Poor performing websites and slower loading pages make unhappy customers.

Can we validate these metrics along with our functional regression on every build? Yes, we can!

The CDP command to capture performance metrics is Performance.enable.
Information for this command can be found in the documentation.

Lets see how it’s done with Selenium 4 and Chrome DevTools APIs.

*Пример*

```java
ChromeDriver driver = new ChromeDriver();
DevTools devTools = driver.getDevTools();
devTools.createSession();
devTools.send(Performance.enable());

driver.get("https://www.google.org");

List<Metric> metrics = devTools.send(Performance.getMetrics());
List<String> metricNames = metrics.stream()
.map(o -> o.getName())
.collect(Collectors.toList());

devTools.send(Performance.disable());

List<String> metricsToCheck = Arrays.asList(
"Timestamp", "Documents", "Frames", "JSEventListeners",
"LayoutObjects", "MediaKeySessions", "Nodes",
"Resources", "DomContentLoaded", "NavigationStart");

metricsToCheck.forEach( metric -> System.out.println(metric +
" is : " + metrics.get(metricNames.indexOf(metric)).getValue()));

```

### Basic Authentication

Interacting with browser popups is not supported in Selenium, as it is only able to engage with DOM elements.
This poses a challenge for pop-ups such as authentication dialogs.

We can bypass this by using the CDP APIs to handle the authentication directly with DevTools.
The CDP command to set additional headers for the requests is Network.setExtraHTTPHeaders.

Here’s how to invoke this command in Selenium 4.

*Пример*

```java
ChromeDriver driver = new ChromeDriver();

//Create DevTools session and enable Network
DevTools chromeDevTools = driver.getDevTools();
chromeDevTools.createSession();
chromeDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

//Open website
driver.get("https://jigsaw.w3.org/HTTP/");

//Send authorization header
Map<String, Object> headers = new HashMap<>();
String basicAuth ="Basic " + new String(new Base64().encode(String.format("%s:%s", USERNAME, PASSWORD).getBytes()));
headers.put("Authorization", basicAuth);
chromeDevTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

//Click authentication test - this normally invokes a browser popup if unauthenticated
driver.findElement(By.linkText("Basic Authentication test")).click();

String loginSuccessMsg = driver.findElement(By.tagName("html")).getText();
if(loginSuccessMsg.contains("Your browser made it!")){
System.out.println("Login successful");
}else{
System.out.println("Login failed");
}

driver.quit();
```

### URL Filtering

*Пример*

```java
//enable Network
chromeDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

//set blocked URL patterns
chromeDevTools.send(Network.setBlockedURLs(ImmutableList.of("*.css", "*.png")));

//add event listener to verify that css and png are blocked
chromeDevTools.addListener(Network.loadingFailed(), loadingFailed -> {

    if (loadingFailed.getResourceType().equals(ResourceType.Stylesheet)) {
        Assert.assertEquals(loadingFailed.getBlockedReason(), BlockedReason.inspector);
    }

    else if (loadingFailed.getResourceType().equals(ResourceType.Image)) {
        Assert.assertEquals(loadingFailed.getBlockedReason(), BlockedReason.inspector);
    }

});

chromeDriver.get("https://apache.org");
```

### Adding Custom Headers

*Пример*

```java
//enable Network
chromeDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

//set custom header
chromeDevTools.send(Network.setExtraHTTPHeaders(ImmutableMap.of("customHeaderName", "customHeaderValue")));

//add event listener to verify that requests are sending with the custom header
chromeDevTools.addListener(Network.requestWillBeSent(), requestWillBeSent -> Assert
.assertEquals(requestWillBeSent.getRequest().getHeaders().get("customHeaderName"),
"customHeaderValue"));

chromeDriver.get("https://apache.org");
```

### Intercepting requests

*Пример*

```java
//enable Network
chromeDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

//add listener to intercept request and continue
chromeDevTools.addListener(Network.requestIntercepted(),
requestIntercepted -> chromeDevTools.send(
Network.continueInterceptedRequest(requestIntercepted.getInterceptionId(),
Optional.empty(),
Optional.empty(),
Optional.empty(), Optional.empty(),
Optional.empty(),
Optional.empty(), Optional.empty())));

//set request interception only for css requests
RequestPattern requestPattern = new RequestPattern("*.css", ResourceType.Stylesheet, InterceptionStage.HeadersReceived);
chromeDevTools.send(Network.setRequestInterception(ImmutableList.of(requestPattern)));

chromeDriver.get("https://apache.org");
```

### Listen To Console Logs

*Пример*

```java
String consoleMessage = "Hello Selenium 4";

//enable Console
chromeDevTools.send(Console.enable());

//add listener to verify the console message
chromeDevTools.addListener(Console.messageAdded(), consoleMessageFromDevTools ->
Assert.assertEquals(true, consoleMessageFromDevTools.getText().equals(consoleMessage)));

chromeDriver.get("https://apache.org");

//execute JS - write console message
chromeDriver.executeScript("console.log('" + consoleMessage + "');");
```

### IgnoreCertificateErrors

*Пример*

```java
//enable Security
chromeDevTools.send(Security.enable());

//set ignore certificate errors
chromeDevTools.send(Security.setIgnoreCertificateErrors(true));

//load insecure website
chromeDriver.get("https://expired.badssl.com/");

//verify that the page was loaded
Assert.assertEquals(true, chromeDriver.getPageSource().contains("expired"));
```

### Command

*Пример*

```java
chromeDevTools.send(new Command<>("Browser.crash", ImmutableMap.of()));
```

### Переопределение UserAgent

До Selenium 4 UserAgent устанавливался только через capabilities, до создания объекта драйвера.
Network.setUserAgentOverride задает новое значение UserAgent на лету.

*Пример*

```java
devTools.send(Network.setUserAgentOverride("aqa-agent", Optional.empty(), Optional.empty(), Optional.empty()));
```

### Предоставление прав

Для некоторых операций, браузер запрашивает разрешение пользователя, например, для доступа к буферу обмена или микрофону. Предоставить права можно при помощи Browser.grantPermissions передавая перечень необходимых PermissionType.

Для примера разрешим браузеру захват звука.

*Пример*

```java
driver.executeCdpCommand("Browser.grantPermissions", Map.of("permissions", asList("audioCapture")));
```

### Добавление заголовков в запросы

Network.setExtraHTTPHeaders позволяет добавить кастомные заголовки к запросам.

*Пример*

```java
devTools.send(Network.enable(empty(),empty(),empty()));
devTools.send(Network.setExtraHTTPHeaders(new Headers(Map.of("aqa-header", "John Wick"))));
```

### Перехват и модификация запросов

Fetch.enable включает перехват, каждый запрос будет остановлен пока клиент не вызовет failRequest, fulfillRequest или continueRequest.
Перехватывать можно все запросы и модифицировать по условию, либо работать только с целевыми, указав для этого RequestPattern, ниже приведены оба варианта.

Модифицируем URL, например перенаправим запросы /v1/users на новую версию бэкенда /v2/users.

*Пример*

```java
devTools.send(Fetch.enable(empty(), empty()));
devTools.addListener(Fetch.requestPaused(), request -> {

String url = request.getRequest().getUrl().contains("/v1/users")
? request.getRequest().getUrl().replace("/v1/users", "/v2/users")
: request.getRequest().getUrl();

devTools.send(Fetch.continueRequest(
request.getRequestId(),
Optional.of(url),
Optional.of(request.getRequest().getMethod()),
request.getRequest().getPostData(),
request.getResponseHeaders()));
});
```

Аналогичным способом эмулируется неудачный запрос. Например для тестирования работы приложения с отвалившейся интеграцией.

*Пример*

```java
Optional<List<RequestPattern>> patterns = Optional.of(asList(new RequestPattern(of("*.dropbox.*"), empty(), empty())));
devTools.send(Fetch.enable(patterns, empty()));
devTools.addListener(Fetch.requestPaused(), r -> devTools.send(Fetch.failRequest(r.getRequestId(), FAILED)));
```

### Эмуляция интернет соединения

Network.emulateNetworkConditions позволяет задавать параметры соединения, например для тестирования поведения при слабом 3G или отсутствии сети.

*Пример*

```java
devTools.send(Network.enable(empty(), empty(), empty()));
devTools.send(Network.emulateNetworkConditions(false, 100, 1000, 1000, of(ConnectionType.CELLULAR3G)));
```

### Очистка кэша
Network.clearBrowserCache очистит кэш браузера.

*Пример*

```java
devTools.send(Network.clearBrowserCache());
```

### Блокировка загрузки ресурсов

Через Network.setBlockedURLs можно ограничишь загрузку ресурсов по паттерну. Например, заблокируем скачивание .svg

*Пример*

```java
devTools.send(Network.enable(empty(), empty(), empty()));
devTools.send(Network.setBlockedURLs(List.of("*.svg")));
Установка TimeZone и Geolocation Position
Emulation.setTimezoneOverride переопределяет TimeZone браузера, а Emulation.setGeolocationOverride геопозицию.

devTools.send(Emulation.setTimezoneOverride("America/New_York"));
devTools.send(Emulation.setGeolocationOverride(Optional.of(40.730610), Optional.of(-73.935242), Optional.of(1)));
```

### Обход ограничений безопасности

Security.setIgnoreCertificateErrors позволит обойти проблемы с SSL сертификатом. Отмечу, что не призываю к таким действиям, а показываю наличие возможности.

*Пример*

```java
devTools.send(Security.enable());
devTools.send(Security.setIgnoreCertificateErrors(true));
```

###  Метрики

Performance.enable включает сбор метрик (Resources, Documents, JSHeapUsedSize etc.), а Performance.getMetrics возвращает текущие значения.

*Пример*

```java
devTools.send(Performance.enable(empty()));
List<Metric> send = devTools.send(Performance.getMetrics());
```

https://applitools.com/blog/selenium-4-chrome-devtools/
https://medium.com/@ohanaadi/chrome-devtools-and-selenium-4-eadab5d755b7
https://dou.ua/forums/topic/33094/
https://chromedevtools.github.io/devtools-protocol/
https://itnext.io/devtools-protocol-in-selenium-4-6acf89ecb84d


# 6.

## 5.1. Интерфейс Rotatable

***Rotatable*** - интерфейс

Represents rotation of the browser view for orientation-sensitive devices.
When using this with a real device, the device should not be moved so that the built-in sensors do not interfere.

Методы интерфейса **Rotatable**:

| Тип               | Метод        | Описание                      | 
|-------------------|--------------|-------------------------------|
| ScreenOrientation	| getOrientation() | | 
| void	            | rotate(DeviceRotation rotation) | Changes the rotation of the browser window.| 
| void	            | rotate(ScreenOrientation orientation) | Changes the orientation of the browser window.| 
| DeviceRotation    | rotation() | | 

[selenium/docs/api : Pdf](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/Rotatable.html)

*Пример*

```java

```

## 5.2. Перечисление ScreenOrientation

***ScreenOrientation*** - перечисление

Константы перечисления *ScreenOrientation*

| Тип           | Описание         | 
|---------------|------------------|
| LANDSCAPE     |               |
| PORTRAIT      |               |

Методы перечисления *PrintOptions.Orientation*:

| Тип                        | Метод                | Описание                      | 
|----------------------------|----------------------|-------------------------------|
| String                     | value()              | | 
| static ScreenOrientation	 | valueOf(String name) | Returns the enum constant of this type with the specified name.  | 
| static ScreenOrientation[] | values()             | Returns an array containing the constants of this enum type, in the order they are declared. | 

[selenium/docs/api : ScreenOrientation](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/DeviceRotation.html)

## 5.3. Класс DeviceRotation

***DeviceRotation*** - класс

Методы класса *DeviceRotation*:

| Тип                  | Метод            | Описание                      | 
|----------------------|------------------|-------------------------------|
| boolean              | equals(Object o) | | 
| int                  | getX()	          | | 
| int                  | getY()	          | | 
| int                  | getZ()	          | | 
| int                  | hashCode()	      | | 
| Map<String, Integer> | parameters()     | | 

[selenium/docs/api : DeviceRotation](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/DeviceRotation.html)

***

***

Select select = new Select(<WebElement object>);
selectByVisibleText()
selectByIndex()
selectByValue()

deselectByVisibleText()
deselectByIndex()
deselectByValue()
deselectAll()

getOptions()
getAllSelectedOptions()
getFirstSelectedOption()

***