
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
```


### Установка TimeZone и Geolocation Position

Emulation.setTimezoneOverride переопределяет TimeZone браузера, а Emulation.setGeolocationOverride геопозицию.

```java
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