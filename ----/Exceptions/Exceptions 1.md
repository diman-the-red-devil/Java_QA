* [Top 10 Selenium Exceptions And How To Handle These (Exact Code)](https://www.softwaretestinghelp.com/exception-handling-framework-selenium-tutorial-19/#8_orgopenqaseleniumTimeoutException)
* [10 Common Selenium Exceptions in C# and How to Fix Them](https://blog.testproject.io/2020/12/28/10-common-selenium-exceptions-in-c-and-how-to-fix-them/)
* [Exceptions & How to Handle Exceptions in Selenium WebDriver](https://blog.knoldus.com/exceptions-how-to-handle-exceptions-in-selenium-webdriver/#nosuchelementexception)
* [Exception Handling in Selenium Webdriver (Types)](https://www.guru99.com/exception-handling-selenium.html)
* [What are the Common Selenium Exceptions and How to Handle Them?](https://www.thepsi.com/what-are-the-common-selenium-exceptions-and-how-to-handle-them/)

***

# 1. Куки

[DONE:] 
[TODO: Add Examples]

## InvalidCookieDomainException

***InvalidCookieDomainException*** — исключение, которое вызывается, когда куки добавляется в другой домен вместо текущего URL адреса.

[selenium/docs/api : InvalidCookieDomainException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/InvalidCookieDomainException.html)

### Причины

* Добавление куки, когда страница с заданным URL еще не открыта
* Добавление куки по URL, в котором есть опечатка

### Решение

* Проверка корректности URL адреса

Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (InvalidCookieDomainException e) {
    System.out.println(e);
}
```

## NoSuchCookieException

***NoSuchCookieException*** — исключение, которое вызывается, когда не найдено ни одного куки.

[selenium/docs/api : NoSuchCookieException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/NoSuchCookieException.html)

### Причины

* Поиск куки по некорректному имени
* Поиск куки, которого не существует
* Поиск куки не в том домене

### Решение

* Проверка корректности имени куки

Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (NoSuchCookieException e) {
    System.out.println(e);
}
```

## UnableToSetCookieException

***UnableToSetCookieException*** — исключение, которое вызывается, когда **Selenium WebDriver** не может установить файл cookie.

[selenium/docs/api : UnableToSetCookieException](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/UnableToSetCookieException.html)

### Причины

* Создание куки до перехода на сайт

### Решение

* Проверка перехода на сайт до создания куки

Ниже пример перехвата исключения.

*Пример*

```java
try {
    ...
} catch (UnableToSetCookieException e) {
    System.out.println(e);
}
```