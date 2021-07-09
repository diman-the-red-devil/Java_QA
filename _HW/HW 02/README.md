Java_QA / Level 1. Easy - Основы / 1.1. Selenium WebDriver

# ДЗ 02. Конфигурация драйвера

## Цель

Реализация паттерна **WebDriverFactory** для запуска разных браузеров.
Конфигурирование драйвера при старте.


## Шаги

| №   | Описание                                                | Примечание                             |
|-----|---------------------------------------------------------|----------------------------------------|
|  1. | Открыть проект **Maven** созданный в **ДЗ01**           |                                        |                                          
|  2. | Реализовать паттерн **WebDriverFactory** для браузеров: |                                        |
|     | *Google Chrome*                                         |                                        |
|     | *Mozilla Firefox*                                       |                                        |
|  3. | Добавить параметризованный запуск тестов                |                                        |
|     | параметр *-Dbrowser=Имя_Браузера*                       |                                        |
|  4. | Добавить общие настройки                                |                                        |
ожидание загрузки страницы в 60 секунд
|     | параметр *-Dbrowser=Имя_Браузера*                       |                                        |
|  5. | Добавить специфичные настройки                          |                                        |
options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
|     | параметр *-Dbrowser=Имя_Браузера*                       |                                        |
|  8. | Написать тест:                                          |                                        |
|     | Открыть страницу В DNS                                  | [DNS](https://www.dns-shop.ru/)        |
|     | вывод заголовка страницы                                  | [DNS](https://www.dns-shop.ru/)        |
|     | вывод текущего URL                                  | [DNS](https://www.dns-shop.ru/)        |
|     | Открыть страницу В DNS                                  | [DNS](https://www.dns-shop.ru/)        |
|     | Открыть страницу В DNS                                  | [DNS](https://www.dns-shop.ru/)        |
|     | Открыть страницу В DNS                                  | [DNS](https://www.dns-shop.ru/)        |
|     | Открыть страницу В DNS                                  | [DNS](https://www.dns-shop.ru/)        |
поиск набора элементов

|  9. | Залить изменения в ветку **hw01**                       |                                        |
| 10. | Слить ветку **hw01** в основную ветку (main или master) |                                        |
| 11. | Прислать ссылку на репозиторий с ДЗ на проверку         | В личку в **Telegram**                 |  

## Требования

| №  | Описание                                                          | Оценка  |
|----|-------------------------------------------------------------------|---------|
| 1. | Проект компилируется и собирается                                 | 1       |
| 2. | Не нужно скачивать и устанавливать файл драйвера                  | 1       | 
| 3. | В репозитории нет лишних файлов (.iml, .idea и т д)               | 1       |
| 4. | Логи пишутся в консоль и файл                                     | 1       |
| 5. | Тест выполняется                                                  | 1       |
|    | Открывается страница [DNS](https://www.dns-shop.ru/)              |         |

Google Chrome

mvn clean test -Dbrowser='cHrOmE'
mvn clean test -Dbrowser=cHrOmE
mvn clean test -Dbrowser='chrome'
mvn clean test -Dbrowser=chrome
Mozilla Firefox

mvn clean test -Dbrowser='FiReFoX'
mvn clean test -Dbrowser=FiReFoX
mvn clean test -Dbrowser='firefox'
mvn clean test -Dbrowser=firefox