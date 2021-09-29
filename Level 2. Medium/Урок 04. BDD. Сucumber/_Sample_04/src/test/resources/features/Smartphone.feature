# language: ru
# encoding: utf-8
Функция: Смартфоны

  Я как посетитель сайта ДНС хочу просматривать раздел со смартфонами.
  Это позволит мне выбрать понравившийся смартфон и просмотреть его характеристики.

  Сценарий: Просмотр страницы Смартфоны
    Дано Открыта Главная страница ДНС
    Когда Выполнен переход на страницу Смартфоны
    Тогда Проверить: В заголовке страницы отображается текст Смартфоны

  Сценарий: Фильтрация и сортировка смартфонов на странице Смартфоны
    Дано Открыта Главная страница ДНС
    Когда Выполнен переход на страницу Смартфоны
    И Установлена сортировка "Сначала дорогие"
    И В фильтре "Производитель" выбрано значение "Samsung"
    И В фильтре "Объем оперативной памяти" выбрано значение "8 Гб"
    И Применены выбранные фильтры
    И Выполнен переход на страницу первого товара из списка
    Тогда Проверить: В заголовке страницы отображается текст Samsung


