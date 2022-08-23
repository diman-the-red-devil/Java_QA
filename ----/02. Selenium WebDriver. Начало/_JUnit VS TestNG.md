Java_QA / 02. Selenium WebDriver. Начало

[![Лекция](https://img.shields.io/badge/-Лекция-ee99ff)](1.%20Лекция.md)

***

# Содержание

* [1. Настройка тестов](#1-настройка-тестов)
* [2. Игнорирование тестов](#2-игнорирование-тестов)
* [3. Группировка тестов](#3-группировка-тестов)
* [4. Исключения в тестах](#4-исключения-в-тестах)
* [5. Таймауты в тестах](#5-таймауты-в-тестах)
* [6. Параметры в тестах](#6-параметры-в-тестах)
* [7. Порядок выполнения тестов](#7-порядок-выполнения-тестов)
* [8. Методы assert* в JUnit и TestNG](#8-методы-assert-в-junit-и-testng)

***

# 1. Настройка тестов

[![Содержание](https://img.shields.io/badge/-Содержание-66eeff)](#содержание)

**JUnit 5** предлагает инициализацию и очистку на двух уровнях:

* до каждого метода *@BeforeEach*
* после каждого метода *@AfterEach*
* до каждого класса *@BeforeAll*
* после каждого класса *@AfterAll*

```java
public class Test {

    private static List<Integer> numbers;

    @BeforeAll
    public static void initialize() {
        numbers = new ArrayList<>();
    }

    @AfterAll
    public static void tearDown() {
        numbers = null;
    }

    @BeforeEach
    public void runBeforeEachTest() {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @AfterEach
    public void runAfterEachTest() {
        numbers.clear();
    }

    @Test
    public void givenNumbers_sumEquals_thenCorrect() {
        int sum = numbers.stream().reduce(0, Integer::sum);
        assertEquals(6, sum);
    }
}
```

**TestNG** предлагает инициализацию и очистку на двух уровнях:
                           
* до каждого метода *@BeforeMethod*
* после каждого метода *@AfterMethod*
* до каждого класса *@BeforeClass*
* после каждого класса *@AfterClass*

```java
public class Test {

    private static List<Integer> numbers;

    @BeforeClass
    public void initialize() {
        numbers = new ArrayList<>();
    }
    
    @AfterClass
    public void tearDown() {
        numbers = null;
    }
    
    @BeforeMethod
    public void runBeforeEachTest() {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    @AfterMethod
    public void runAfterEachTest() {
        numbers.clear();
    }

    @Test
    public void givenNumbers_sumEquals_thenCorrect() {
        int sum = numbers.stream().reduce(0, Integer::sum);
        assertEquals(6, sum);
    }
}
```

**TestNG** дополнительно предлагает аннотации для конфигураций на уровне комплектов и групп:

* до каждого комплекта *@BeforeSuite*
* после каждого комплекта *@AfterSuite*
* до каждой группы *@BeforeGroup*
* после каждой группы *@AfterGroup*

```java
public class Test {
    @BeforeGroups("positive__tests")
    public void runBeforeEachGroup() {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    @AfterGroups("negative__tests")
    public void runAfterEachGroup() {
        numbers.clear();
    }
}
```

***

# 2. Игнорирование тестов

[![Содержание](https://img.shields.io/badge/-Содержание-66eeff)](#содержание)

**JUnit 5** использует для игнорирования тестов *@Disabled("message")* 

```java
public class Test {
    @Disabled("Disabled until bug #99 has been fixed")
    @Test
    public void givenNumbers__sumEquals__thenCorrect() {
        int sum = numbers.stream().reduce(0, Integer::sum);
        Assert.assertEquals(6, sum);
    }
}
```

**TestNG** использует для игнорирования тестов *@Test(enabled = value)*

```java
public class Test {
    @Test(enabled = false)
    public void givenNumbers__sumEquals__thenCorrect() {
        int sum = numbers.stream.reduce(0, Integer::sum);
        Assert.assertEquals(6, sum);
    }
}
```

***

# 3. Группировка тестов

[![Содержание](https://img.shields.io/badge/-Содержание-66eeff)](#содержание)

**JUnit 5** использует для группировки тестов *@RunWith* вместе *@SelectPackages* и *@SelectClasses*.

Если нужно сгруппировать тесты разных пакетов совместно *@SelectPackages({packageName1, packageName2, ...})*

```java
@RunWith(JUnitPlatform.class)
@SelectPackages({ "org.baeldung.java.suite.childpackage1", "org.baeldung.java.suite.childpackage2" })
public class SelectPackagesSuiteUnitTest {

}
```

Если нужно сгруппировать определенные классы *@SelectClasses({Class1.class, Class2.class, ...})*

```java
@RunWith(JUnitPlatform.class)
@SelectClasses({Class1UnitTest.class, Class2UnitTest.class})
public class SelectClassesSuiteUnitTest {

}
```

**TestNG** использует для группировки тестов файл XML

```xml
<suite name="suite">
    <test name="test suite">
        <classes>
            <class name="com.baeldung.RegistrationTest"/>
            <class name="com.baeldung.SignInTest"/>
        </classes>
    </test>
</suite>
```

**TestNG** использует для группировки методов *@Test(groups = ”groupName”)*

```java
public class Test {
    @Test(groups = "regression")
    public void givenNegativeNumber__sumLessthanZero__thenCorrect() {
        int sum = numbers.stream().reduce(0, Integer::sum);
        Assert.assertTrue(sum < 0);
    }
}
```
    
```xml
<test name="test groups">
    <groups>
        <run>
            <include name="regression"/>
        </run>
    </groups>
    <classes>
        <class name="com.baeldung.SummationServiceTest"/>
    </classes>
</test>
```

***

# 4. Исключения в тестах

[![Содержание](https://img.shields.io/badge/-Содержание-66eeff)](#содержание)

**JUnit 5** использует для проверки исключений *assertThrows*

```java
public class Test {
    @Test
    public void whenDividerIsZero__thenDivideByZeroExceptionIsThrown() {
        Calculator calculator = new Calculator();
        assertThrows(DivideByZeroException.class, () -> calculator.divide(10, 0));
    }
}
```

**TestNG** использует для проверки исключений *@Test(expectedExceptions = ExceptionName.class)* 

```java
public class Test {
    @Test(expectedExceptions = ArithmeticException.class)
    public void givenNumber__whenThrowsException__thenCorrect() {
        int i = 1/0;
    }
}
```

***

# 5. Таймауты в тестах

[![Содержание](https://img.shields.io/badge/-Содержание-66eeff)](#содержание)

**JUnit 5** использует для проверки с таймаутами *assertTimeout*

```java
public class Test {
    @Test
    public void givenExecution_takeMoreTime_thenFail() throws InterruptedException {
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(10000));
    }
}
```

**TestNG** использует для проверки с таймаутами *@Test(timeout = value)*

```java
public class Test {
    @Test(timeOut = 1000)
    public void givenExecution_takeMoreTime_thenFail() {
        while (true);
    }
}
```

***

# 6. Параметры в тестах

[![Содержание](https://img.shields.io/badge/-Содержание-66eeff)](#содержание)

**JUnit 5** использует для параметризации тестов *@ParameterizedTest* и аргументы данных непосредственно из сконфигурированного источника

*@ValueSource(type = {value1, value2, ...})* - массив значений типов Short, Byte, Int, Long, Float, Double, Char, и String в качестве источника для параметров

```java
public class Test {
    @ParameterizedTest
    @ValueSource(strings = { "Hello", "World" })
    void givenString__TestNullOrNot(String word) {
        assertNotNull(word);
    }
}
```

*@EnumSource(value = Enum.class, names = {"const1", "const2", ...})* - константы из enum как параметры теста в качестве источника для параметров

```java
public class Test {
    @ParameterizedTest
    @EnumSource(value = PizzaDeliveryStrategy.class, names = {"EXPRESS", "NORMAL"})
    void givenEnum__TestContainsOrNot(PizzaDeliveryStrategy timeUnit) {
        assertTrue(EnumSet.of(PizzaDeliveryStrategy.EXPRESS, PizzaDeliveryStrategy.NORMAL).contains(timeUnit));
    }
}
```

*@MethodSource("methodName")* - внешние методы, генерирующие потоки в качестве источника для параметров

```java
public class Provider {
    static Stream<String> wordDataProvider() {
        return Stream.of("foo", "bar");
    }
}

public class Test {
    @ParameterizedTest
    @MethodSource("wordDataProvider")
    void givenMethodSource__TestInputStream(String argument) {
        assertNotNull(argument);
    }
}
```

*@CsvSource({"values1", "values2", ...})* – значения CSV в качестве источника для параметров

```java
public class Test {
    @ParameterizedTest
    @CsvSource({ "1, Car", "2, House", "3, Train" })
    void givenCSVSource__TestContent(int id, String word) {
        assertNotNull(id);
        assertNotNull(word);
    }
}
```

Также есть другие источники, такие как  

* *@CsvFileSource* - CSV-файл из classpath 
* *@ArgumentSource* - пользовательский, многократно используемый ArgumentsProvider

**TestNG** для параметризации тестов использует *@Parameters({"paramName1", "paramName2", ...})* и данные из файла XML 

```java
public class Test {
    @Test
    @Parameters({"value", "isEven"})
    public void
      givenNumberFromXML__ifEvenCheckOK__thenCorrect(int value, boolean isEven) {
        Assert.assertEquals(isEven, value % 2 == 0);
    }
}
```

```xml
<suite name="My test suite">
    <test name="numbersXML">
        <parameter name="value" value="1"/>
        <parameter name="isEven" value="false"/>
        <classes>
            <class name="baeldung.com.ParametrizedTests"/>
        </classes>
    </test>
</suite>
```

**TestNG** для отображения сложных типов параметров использует *@DataProvider(name = "dataProviderName")*.

*@DataProvider(name = "dataProviderName")* для примитивных типов данных

```java
public class Provider {
    @DataProvider(name = "numbers")
    public static Object[][]evenNumbers() {
        return new Object[][]{
            {1, false}, 
            {2, true}, 
            {4, true}
        };
    }

    @Test(dataProvider = "numbers")
    public void givenNumberFromDataProvider__ifEvenCheckOK__thenCorrect
      (Integer number, boolean expected) {
        Assert.assertEquals(expected, number % 2 == 0);
    }
}
```

*@DataProvider(name = "dataProviderName")* для объектов

```java
public class Test {
    @DataProvider(name = "numbersObject")
    public Object[][] parameterProvider() {
        return new Object[][]{
            {new EvenNumber(1, false)},
            {new EvenNumber(2, true)}, 
            {new EvenNumber(4, true)}
        };
    }

    @Test(dataProvider = "numbersObject")
    public void givenNumberObjectFromDataProvider__ifEvenCheckOK__thenCorrect
      (EvenNumber number) {
        Assert.assertEquals(number.isEven(), number.getValue() % 2 == 0);
    }
}
```

Таким же образом любые конкретные объекты, которые должны быть проверены, могут быть созданы и возвращены с использованием поставщика данных. 

***

# 7. Порядок выполнения тестов

[![Содержание](https://img.shields.io/badge/-Содержание-66eeff)](#содержание)

**JUnit 5** для установки порядка выполнения тестов использует *@TestMethodOrder(MethodOrderer."Orderer.class")*. 

Начиная с JUnit 5.4 есть три встроенных класса *MethodOrderer*: *OrderAnnotation.class*, *Alphanumeric.class* и *Random.class*.

*MethodOrderer.OrderAnnotation.class* использует порядок по тегу *@Order*

```java
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestExecutionOrderWithOrderAnnotation {
    @Order(1)
    @Test
    void aTest() {}
 
    @Order(2)
    @Test
    void bTest() {}
 
    @Order(3)
    @Test
    void cTest() {}
}
```

*MethodOrderer.Alphanumeric.class* использует буквенно-цифровой порядок

```java
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class AlphanumericTestExecutionOrder {
    @Test
    void aTest() {}
 
    @Test
    void bTest() {}
 
    @Test
    void cTest() {}
}
```

*MethodOrderer.Random.class* использует случайный порядок

```java
@TestMethodOrder(MethodOrderer.Random.class)
class AlphanumericTestExecutionOrder {
    @Test
    void aTest() {}
 
    @Test
    void bTest() {}
 
    @Test
    void cTest() {}
}
```

**TestNG** для установки порядка выполнения тестов использует параметр  *@Test(priority = value)*

```java
@Test(priority = 1)
public void givenString__whenChangedToInt__thenCorrect() {
    Assert.assertTrue(
      Integer.valueOf("10") instanceof Integer);
}

@Test(priority = 2)
public void givenInt__whenChangedToString__thenCorrect() {
    Assert.assertTrue(
      String.valueOf(23) instanceof String);
}
```

***

# 8. Методы assert* в JUnit и TestNG

[![Содержание](https://img.shields.io/badge/-Содержание-66eeff)](#содержание)

![Сравнение assert методов JUnit и TestNG](./_Files/7.%20JUnit5/_18.jpg "Сравнение assert методов JUnit и TestNG")