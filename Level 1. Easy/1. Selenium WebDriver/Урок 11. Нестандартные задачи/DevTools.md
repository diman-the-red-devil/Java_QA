### Command

*Пример*

```java
chromeDevTools.send(new Command<>("Browser.crash", ImmutableMap.of()));
```

## Network

### Эмуляция интернет соединения

Network.emulateNetworkConditions позволяет задавать параметры соединения, например для тестирования поведения при слабом 3G или отсутствии сети.

*Пример*

```java
devTools.send(Network.enable(empty(), empty(), empty()));
devTools.send(Network.emulateNetworkConditions(false, 100, 1000, 1000, of(ConnectionType.CELLULAR3G)));
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

### Переопределение UserAgent

До Selenium 4 UserAgent устанавливался только через capabilities, до создания объекта драйвера.
Network.setUserAgentOverride задает новое значение UserAgent на лету.

*Пример*

```java
devTools.send(Network.setUserAgentOverride("aqa-agent", Optional.empty(), Optional.empty(), Optional.empty()));
```

### Добавление заголовков в запросы

Network.setExtraHTTPHeaders позволяет добавить кастомные заголовки к запросам.

*Пример*

```java
devTools.send(Network.enable(empty(),empty(),empty()));
devTools.send(Network.setExtraHTTPHeaders(new Headers(Map.of("aqa-header", "John Wick"))));
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





## Security

### Обход ограничений безопасности

Security.setIgnoreCertificateErrors позволит обойти проблемы с SSL сертификатом. Отмечу, что не призываю к таким действиям, а показываю наличие возможности.

*Пример*

```java
devTools.send(Security.enable());
devTools.send(Security.setIgnoreCertificateErrors(true));
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


