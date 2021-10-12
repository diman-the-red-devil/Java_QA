# 0. Использованные технологии

1. Язык программирования - ***Java***
2. Инструмент сборки и запуска - ***Maven***
3. Фреймворк тестирования - ***JUnit5***
4. Фреймворк тестирования API - ***REST Assured***

# 1. REST-Assured

[Оф сайт REST Assured](https://rest-assured.io/)

## 1.1. Шаги по работе

1. Добавить зависимость 

```xml
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>${rest-assured}</version>
</dependency>
```

${rest-assured} - версия зависимости определенная в разделе properties.

2. Создать класс с тестами [RickAndMortyRestApiTest.java](/src/test/java/rickandmortyapi/RickAndMortyRestApiTest.java)

3. Создать метод с тестом **getCharacterByNameAndCheckName(String name, String expectedName)**

4. Добавить код с методами Rest Assured

## 1.2. Ссылки 

### REST Assured

[Гайд на Github](https://github.com/rest-assured/rest-assured/wiki/Usage)

[Гайд от Baeldung](https://www.baeldung.com/rest-assured-tutorial)

[Тестирование служб RESTful на Java: лучшие практики](https://qahacking.ru/perevody/testirovanie-sluzhb-restful-na-java-luchshie-praktiki)

[REST Assured: что мы узнали за пять лет использования инструмента](https://temofeev.ru/info/articles/rest-assured-chto-my-uznali-za-pyat-let-ispolzovaniya-instrumenta/)

### Ссылки на открытые API

https://fakerapi.it/en
https://www.last.fm/
http://numbersapi.com/#42
https://pokeapi.co/api/v2
https://anapioficeandfire.com/
https://www.superheroapi.com/api

***

# 2. Параметризованные тесты JUnit

## 2.1. Шаги по работе

1. Добавить зависимость

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>${junit-jupiter-params}</version>
    <scope>test</scope>
</dependency>
```

${junit-jupiter-params} - версия зависимости определенная в разделе properties.

2. Добавить аннотации тестам с параметрами

* *@ParameterizedTest* - параметризованный тест
* *@MethodSource("dataForGetCharacterByNameAndCheckName")* - генератор / поставщик тестовых данных для параметризованного теста

"dataForGetCharacterByNameAndCheckName" - имя метода 

3. Создать метод с именем указанным в аннотации **@MethodSource**

4. Добавить код возвращающий значения

## 2.2. Ссылки

### Параметризованные тесты JUnit

[Гайд от JUnit5](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests)

[Гайд от Baeldung](https://www.baeldung.com/parameterized-tests-junit-5)

***

# 3. Параллельный запуск тестов JUnit

## 3.1. Шаги по работе

1. Создать конфиг файл в [junit-platform.properties](src/main/resources/junit-platform.properties)

2. Задать конфиги для запуска в параллельном режиме

* *junit.jupiter.execution.parallel.enabled=true* - включение паралелльного режима запуска тестов
* *junit.jupiter.execution.parallel.mode.default=concurrent* - режим запуска по методам
    * **concurrent** - многопоточный
    * **same_thread** - однопоточный
* *junit.jupiter.execution.parallel.mode.classes.default=concurrent* - режим запуска по классам
    * **concurrent** - многопоточный
    * **same_thread** - однопоточный
* *junit.jupiter.execution.parallel.config.strategy=fixed* - стратегия параллельного режима запуска тестов
* *junit.jupiter.execution.parallel.config.fixed.parallelism=3* - количество параллельных потоков

3. Добавить аннотации 

* *@Execution(ExecutionMode.CONCURRENT)* до объявления класса - параллельно выполняемый тест

## 3.2. Запуск

1. **Запуск всех тестов в 1 поток**

```properties
junit.jupiter.execution.parallel.enabled=true
junit.jupiter.execution.parallel.config.strategy=fixed
junit.jupiter.execution.parallel.config.fixed.parallelism=1
```

2. **Запуск всех тестов в 2 потока**

```properties
junit.jupiter.execution.parallel.enabled=true
junit.jupiter.execution.parallel.config.strategy=fixed
junit.jupiter.execution.parallel.config.fixed.parallelism=2
```

3. **Запуск всех тестов в 4 потока**

```properties
junit.jupiter.execution.parallel.enabled=true
junit.jupiter.execution.parallel.config.strategy=fixed
junit.jupiter.execution.parallel.config.fixed.parallelism=4
```

4. **Запуск всех тестов в 8 потоков**


```properties
junit.jupiter.execution.parallel.enabled=true
junit.jupiter.execution.parallel.config.strategy=fixed
junit.jupiter.execution.parallel.config.fixed.parallelism=8
```

## 3.2. Ссылки

### Параметризованные тесты JUnit

[JUnit5. Docs: 2.19. Parallel Execution](https://junit.org/junit5/docs/snapshot/user-guide/#writing-tests-parallel-execution)
