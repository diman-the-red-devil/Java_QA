### Command

*Пример*

```java
chromeDevTools.send(new Command<>("Browser.crash", ImmutableMap.of()));
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


