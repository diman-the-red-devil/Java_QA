Java_QA / Level 1. Easy - Основы / 1.1. Selenium WebDriver

# ДЗ 04. Применение паттернов

## Цель

Написание автотестов с использованием паттернов проектирования.

## Шаги

| №   | Описание                                                     | Примечание                                       |
|-----|--------------------------------------------------------------|--------------------------------------------------|
|  1. | Создать новый проект **Maven**                               |                                                  | 
|     | Проект должен содержать:                                     |                                                  |
|     | - Паттерн **WebDriverFactory**                               | *Google Chrome*                                  |
|     |                                                              | *Mozilla Firefox*                                |
|     | - Параметризованный запуск тестов                            | *-Dbrowser=Имя_Браузера*                         |
|     |                                                              | *-Doption=Имя_Опции*                             |
|     | - Общие настройки                                            | *таймаут загрузки страницы*                      |
|     | - Специфичные настройки                                      | *стратегия загрузки страницы*                    |
|     |                                                              | *режим инкогнито*                                |
|     |                                                              | *полноэкранный режим*                            |
|  2. | Написать тест:                                               |                                                  |
|     | - Открыть страницу *DNS*                                     | [DNS](https://www.dns-shop.ru/)                  |
|     | - Нажать ссылку *ТВ и мультимедиа*/*Телевизоры*              |                                                  |
|     | -- Сделать *скриншот страницы*                               |                                                  |
|     | -- Установить фильтр *Производитель*                         | *Samsung*                                        |
|     | -- Установить фильтр *Диагональ экрана (дюйм)*               | От *60* до *80*                                  |
|     | -- Установить фильтр *Частота обновления экрана (Гц)*        | *120 Гц*                                         |
|     | -- Установить фильтр *Тип подсветки*                         | *Direct LED*                                     |
|     | -- Нажать кнопку *Применить*                                 |                                                  |
|     | -- Применить сортировку                                      | *Сначала дорогие*                                |
|     | -- Сделать *скриншот страницы*                               |                                                  |
|     | - Выбрать и перейти на страницу первого продукта в списке    |                                                  |
|     | -- Сделать *скриншот страницы*                               |                                                  |
|     | -- Проверить заголовок страницы                              | Заголовок страницы соответствует ожидаемому      |
|     | - Нажать на ссылку *Характеристики*                          |                                                  |
|     | -- Сделать *скриншот страницы*                               |                                                  |
|     | -- Проверить значение *Производитель*                        | Значение равно*Samsung*                          |
|     | -- Проверить значение *Диагональ экрана (дюйм)*              | Значение равно От *60* до *80*                   |
|     | -- Проверить значение *Частота обновления экрана (Гц)*       | Значение равно *120 Гц*                          |
|     | -- Проверить значение *Тип подсветки*                        | Значение равно *Direct LED*                      |
|  3. | Залить изменения в ветку **hw04**                            |                                                  |
|  4. | Слить ветку **hw04** в основную ветку (main или master)      |                                                  |
|  5. | Прислать ссылку на репозиторий с ДЗ на проверку              | В личку в **Telegram**                           |

## Требования

| №   | Описание                                                          | Оценка  |
|-----|-------------------------------------------------------------------|---------|
|  1. | В репозитории нет лишних файлов (.iml, .idea и т д)               | 1       |
|  2. | Проект компилируется и собирается                                 | 1       |
|  3. | Не нужно скачивать и устанавливать файл драйвера                  | 1       |
|  4. | Логи пишутся в консоль и файл                                     | 1       |
|  5. | Реализован паттерн *WebDriverFactory*                             | 1       |
|  6. | Добавлен параметризованный запуск тестов                          | 1       |
|  7. | Добавлены общие настройки                                         | 1       |
|  8. | Добавлены специфичные настройки                                   | 1       |
|  9. | Все шаги теста выполняются                                        | 19      |
| 10. | Тест написан с применением:                                       |         |
|     | - Явных ожиданий *WebDriverWait* или *FluentWait*                 | 5       |
|     | - Команд *Action* (**для выполнения нестандартных действий**      | 5       |
|     | - Выполнения *JS* скриптов (**когда нужно**)                      | 5       |
|     | - Библиотеки скриншотов *AShot*                                   | 5       |
| 11. | В тесте применены следующие паттерны:                             |         |
|     | - *PageObject* для описания каждой страницы                       | 5       |
|     | - *PageElements* для обертки *WebElement*                         | 5       |
|     | - *Arrange Act Assert* для структуры тестовых кейсов              | 5       |
|     | - *Assert Objects* для проверок тестовых кейсов                   | 5       |
|     | - *Facade* для шагов тестовых кейсов                              | 5       |
|     | - *JavaBean* для тестовых данных                                  | 5       |
|     | - *ValueObject* для полей тестовых данных                         | 5       |
|     | - *Builder* для построения тестовых данных                        | 5       |
| 12. | Классы и интерфейсы написаны в соответствии с соглашениями        | 5       |
| 13. | Перечень локаторов вынесен в начало каждого *PageObject* класса   | 5       |
| 14. | Штрафные баллы                                                    |         |
|     | - За каждый плохой локатор (индексы, много прыжков)               | -3      |
|     | - За каждый *Thread.sleep*                                        | -3      |
|     | - За каждую проверку без методов *JUnit*, *AssertJ*, *Hamcrest*   | -3      |
|     | - За каждый класс названный с маленькой буквы                     | -3      |
|     | - За каждый метод названный с заглавной буквы                     | -3      |
|     | - За каждый веб элемент названный как попало                      | -3      |
|     | - За уменьшение масштаба страницы                                 | -10     |
| 15. | Ветка **hw03** не удалена в репозитории *Github*                  | 3       |