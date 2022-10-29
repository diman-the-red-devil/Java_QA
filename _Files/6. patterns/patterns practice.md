
# 1. Фабрика страниц (PageFactory)

## 1.1. Перечисление PageName

***PageName*** - перечисление для хранения имен страниц (пейдж обджектов).

Шаги:

1. Создать файл **PageName.java** в **./src/test/java/pages**.

При создании класса выбрать **Enum** (Перечисление).

![New Maven Project - PageName.java](./_Files/2.%20New%20Project/31.jpg "New Project - PageName.java")

3. Добавить в файл **PageName.java** код.

* константы, определяющие названия страниц (пейдж обджектов)

```java
// Имена страниц (пейдж обджектов)
START_PAGE("Стартовая страница"),
SMARTPHONES_PAGE("Страница \"Смартфоны\""),
SMARTPHONE_PRODUCT_PAGE("Страница \"Продукт. Смартфон\"");
```

* переменная для хранения строкового значения константы

```java
private String pageName; // Имя страницы (пейдж обджекта)
```

* приватный конструктор

```java
// Приватный конструктор
private PageName(String pageName) {
    this.pageName = pageName;
}
```

* переопределенный метод **toString**

```java
// Переопределенный метод toString()
@Override
public String toString() {
    return String.valueOf(this.pageName);
}
```

* метод **fromString** - возврат константы по строковому значению константы

```java
// Возврат значения константы по строковому значению константы
public static PageName fromString(String pageName) {
    if (pageName != null) {
        for(PageName p : PageName.values()) {
            if (pageName.equalsIgnoreCase(p.pageName)) {
                 return p;
            }
        }
    }
    return null;
}
```

* метод **getPageName** - получение имени страницы (пейдж обджекта)

```java
// Получение имени страницы (пейдж обджекта)
public String getPageName() {
    return this.pageName;
}
```

## 1.2. Полный код PageName.java

[PageName.java](_Sample/src/test/java/pages/PageName.java)

## 1.3. Класс PageFactory

***PageFactory*** - класс реализующий паттерн фабрика, фабрика по созданию экземпляров страниц (пейдж обджектов).

Шаги:

1. Создать файл **PageFactory.java** в **./src/test/java/pages**.

![New Maven Project - PageFactory.java](./_Files/2.%20New%20Project/32.jpg "New Project - PageFactory.java")

2. Добавить в файл **PageFactory.java** код.

* объявление логгера

```java
// Логгер
private static Logger logger = LogManager.getLogger(PageFactory.class);
```

* метод **getPage** - получение экземпляра страницы (пейдж обджекта)

```java
// Получение экземпляра страницы (пейдж обджекта)
public static BasePage getPage(WebDriver driver, PageName name) {
    switch (name) {
        // Стартовая страница
        case START_PAGE:
            logger.info("Стартовая страница");
            StartPageWithElements startPageWithElements =
            new StartPageWithElements(driver);
            // Инициализация некоторых элементов страницы
            return startPageWithElements;
        // Страница "Смартфоны"
        case SMARTPHONES_PAGE:
            logger.info("Страница \"Смартфоны\"");
            SmartphonesPageWithElements smartphonesPageWithElements =
            new SmartphonesPageWithElements(driver);
            // Инициализация некоторых элементов страницы
            return smartphonesPageWithElements;
        // Страница "Продукт. Смартфон"
        case SMARTPHONE_PRODUCT_PAGE:
            logger.info("Страница \"Продукт. Смартфон\"");
            SmartphoneProductPage smartphoneProductPage =
            new SmartphoneProductPage(driver);
            // Инициализация некоторых элементов страницы
            return smartphoneProductPage;
        // По умолчанию
        default:
            throw new RuntimeException("Некорректное наименование страницы (пейдж обджекта)");
    }
}
```

## 1.4. Полный код PageFactory.java

[PageFactory.java](_Sample/src/test/java/pages/PageFactory.java)

## 1.5. Что изменилось и какая польза?

В класс фабрику **PageFactory** была вынесена логика по инициализации пейдж обджектов.
На первый взгляд ни какого профита нет, но вместо комментария *Инициализация некоторых элементов страницы* можно
добавить некоторый код по созданию веб элементов страницы - так сказать ленивую инициализацию.
В библиотеке **Selenium WebDriver** есть стандартный класс **PageFactory** в котором данный паттерн реализован
покрасивее и универсальнее через рефлексию и аннотации **@FindBy**.

Однако есть ряд минусов:

1. Через аннотацию **@FindBy** нельзя задать динамический локатор.
   То есть когда часть локатора может быть изменена.
   Из за этого придется создавать кучу объектов **WebElement** или
   в код самих тестов вставлять локаторы и логику по поиску элементов.

2. Проблема с динамическими веб элементами.
   Опять же проблема из за статичных локаторов. Если использовать **PageFactory** из коробки, то придется завязываться
   на какой нибудь верхнеуровневый элемент и далее внутри него уже проводить перебор.

Вывод: использовать **PageFactory** из библиотеки **Selenium WebDriver** или
использовать паттерн **PageFactory** вообще - это дело вкуса.
В Интернете можно найти два противоположных мнения на счет этого.