* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

# 1. Куки

[DONE:]

## InvalidCookieDomainException

***InvalidCookieDomainException*** — исключение, которое вызывается, когда куки добавляется в другой домен вместо текущего URL адреса.

[selenium/docs/api : InvalidCookieDomainException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/InvalidCookieDomainException.html)

### Причины

* Добавление куки, когда страница с заданным URL еще не открыта

*Пример*

В примере ниже куки **Cookie 1** добавляется до открытия страницы **https://www.dns-shop.ru/**

```java
@Test
public void test() {
    driver.manage().addCookie(new Cookie("Cookie 1", "This Is Cookie 1"));
    driver.get("https://www.dns-shop.ru/");
    Cookie cookie1  = driver.manage().getCookieNamed("Cookie 1");
    logger.info(String.format("Domain: %s", cookie1.getDomain()));
    logger.info(String.format("Expiry: %s",cookie1.getExpiry()));
    logger.info(String.format("Name: %s",cookie1.getName()));
    logger.info(String.format("Path: %s",cookie1.getPath()));
    logger.info(String.format("Value: %s",cookie1.getValue()));
}
```

В результате вызывается исключение **InvalidCookieDomainException**

```text
org.openqa.selenium.InvalidCookieDomainException: invalid cookie domain
```

* Добавление куки в другой домен

*Пример*

В примере ниже куки **Cookie 1** добавляется:
* на странице **https://www.dns-shop.ru/** 
* в домен **https://www.yandex.ru/**

```java
@Test
public void test() {
    driver.get("https://www.dns-shop.ru/");
    driver.manage().addCookie(
        new Cookie.Builder("Cookie 1", "This Is Cookie 1")
            .domain( "https://www.yandex.ru/")
            .build());
    Cookie cookie1  = driver.manage().getCookieNamed("Cookie 1");
    logger.info(String.format("Domain: %s", cookie1.getDomain()));
    logger.info(String.format("Expiry: %s",cookie1.getExpiry()));
    logger.info(String.format("Name: %s",cookie1.getName()));
    logger.info(String.format("Path: %s",cookie1.getPath()));
    logger.info(String.format("Value: %s",cookie1.getValue()));
}
```

В результате вызывается исключение **InvalidCookieDomainException**

```text
org.openqa.selenium.InvalidCookieDomainException: invalid cookie domain: Cookie 'domain' mismatch
```

* Добавление куки в домен, в котором есть опечатка

*Пример*

В примере ниже куки **Cookie 1** добавляется:
* на странице **https://www.dns-shop.ru/**
* в домен **https://www.dnsshop.ru/**

```java
@Test
public void test() {
    driver.get("https://www.dns-shop.ru/");
    driver.manage().addCookie(
        new Cookie.Builder("Cookie 1", "This Is Cookie 1")
            .domain( "https://www.dnsshop.ru/")
            .build());
    Cookie cookie1  = driver.manage().getCookieNamed("Cookie 1");
    logger.info(String.format("Domain: %s", cookie1.getDomain()));
    logger.info(String.format("Expiry: %s",cookie1.getExpiry()));
    logger.info(String.format("Name: %s",cookie1.getName()));
    logger.info(String.format("Path: %s",cookie1.getPath()));
    logger.info(String.format("Value: %s",cookie1.getValue()));
}
```

В результате вызывается исключение **InvalidCookieDomainException**

```text
org.openqa.selenium.InvalidCookieDomainException: invalid cookie domain: Cookie 'domain' mismatch
```

### Решение

* Проверка открытия нужной страницы перед добавлением куки

*Пример*

```java
@Test
public void test() {
    driver.get("https://www.dns-shop.ru/");
    driver.manage().addCookie(new Cookie("Cookie 1", "This Is Cookie 1"));
    Cookie cookie1  = driver.manage().getCookieNamed("Cookie 1");
    logger.info(String.format("Domain: %s", cookie1.getDomain()));
    logger.info(String.format("Expiry: %s",cookie1.getExpiry()));
    logger.info(String.format("Name: %s",cookie1.getName()));
    logger.info(String.format("Path: %s",cookie1.getPath()));
    logger.info(String.format("Value: %s",cookie1.getValue()));
}
```

* Проверка корректности домена, в который добавляется куки

*Пример*

```java
@Test
public void test() {
    driver.get("https://www.dns-shop.ru/");
    driver.manage().addCookie(
        new Cookie.Builder("Cookie 1", "This Is Cookie 1")
            .domain( "https://www.dns-shop.ru/")
            .build());
    Cookie cookie1  = driver.manage().getCookieNamed("Cookie 1");
    logger.info(String.format("Domain: %s", cookie1.getDomain()));
    logger.info(String.format("Expiry: %s",cookie1.getExpiry()));
    logger.info(String.format("Name: %s",cookie1.getName()));
    logger.info(String.format("Path: %s",cookie1.getPath()));
    logger.info(String.format("Value: %s",cookie1.getValue()));
}
```

Ниже пример перехвата исключения.

*Пример*

```java
@Test
public void test() {
    try {
        driver.get("https://www.dns-shop.ru/");
        driver.manage().addCookie(
            new Cookie.Builder("Cookie 1", "This Is Cookie 1")
                .domain( "https://www.dnsshop.ru/")
                .build());
        Cookie cookie1  = driver.manage().getCookieNamed("Cookie 1");
        logger.info(String.format("Domain: %s", cookie1.getDomain()));
        logger.info(String.format("Expiry: %s",cookie1.getExpiry()));
        logger.info(String.format("Name: %s",cookie1.getName()));
        logger.info(String.format("Path: %s",cookie1.getPath()));
        logger.info(String.format("Value: %s",cookie1.getValue()));
    } catch (InvalidCookieDomainException e) {
        logger.info("InvalidCookieDomainException: " + e.getRawMessage());
    }
}
```

## UnableToSetCookieException

***UnableToSetCookieException*** — исключение, которое вызывается, когда **Selenium WebDriver** не может установить файл cookie.

[selenium/docs/api : UnableToSetCookieException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/UnableToSetCookieException.html)

### Причины

* Установка некорректного пути до директории на сервере, для которой будут доступны куки

*Пример*

В примере ниже при создании куки **Cookie 1** указывается некорректный путь до директории на сервере, для которой будут доступны куки.

```java
@Test
public void test() {
    driver.get("https://www.dns-shop.ru/");
    driver.manage().addCookie(
        new Cookie.Builder("Cookie 1", "This Is Cookie 1")
            .path(".//")
            .build());
    Cookie cookie1  = driver.manage().getCookieNamed("Cookie 1");
    logger.info(String.format("Domain: %s", cookie1.getDomain()));
    logger.info(String.format("Expiry: %s",cookie1.getExpiry()));
    logger.info(String.format("Name: %s",cookie1.getName()));
    logger.info(String.format("Path: %s",cookie1.getPath()));
    logger.info(String.format("Value: %s",cookie1.getValue()));
}
```

В результате вызывается исключение **UnableToSetCookieException**

```text
org.openqa.selenium.UnableToSetCookieException: unable to set cookie
```

### Решение

* Проверка кода создания куки

*Пример*

```java
@Test
public void test() {
    driver.get("https://www.dns-shop.ru/");
    driver.manage().addCookie(
        new Cookie.Builder("Cookie 1", "This Is Cookie 1")
            .path("/")
            .build());
    Cookie cookie1  = driver.manage().getCookieNamed("Cookie 1");
    logger.info(String.format("Domain: %s", cookie1.getDomain()));
    logger.info(String.format("Expiry: %s",cookie1.getExpiry()));
    logger.info(String.format("Name: %s",cookie1.getName()));
    logger.info(String.format("Path: %s",cookie1.getPath()));
    logger.info(String.format("Value: %s",cookie1.getValue()));
}
```

Ниже пример перехвата исключения.

*Пример*

```java
@Test
public void test() {
    try {
        driver.get("https://www.dns-shop.ru/");
        driver.manage().addCookie(
            new Cookie.Builder("Cookie 1", "This Is Cookie 1")
                .path(".//")
                .build());
        Cookie cookie1 = driver.manage().getCookieNamed("Cookie 1");
        logger.info(String.format("Domain: %s", cookie1.getDomain()));
        logger.info(String.format("Expiry: %s", cookie1.getExpiry()));
        logger.info(String.format("Name: %s", cookie1.getName()));
        logger.info(String.format("Path: %s", cookie1.getPath()));
        logger.info(String.format("Value: %s", cookie1.getValue()));
    } catch (UnableToSetCookieException e) {
        logger.info("UnableToSetCookieException: " + e.getRawMessage());
    }
}
```