# language: ru
# encoding: utf-8
Функция: Смартфоны

  Я как посетитель сайта ДНС хочу просматривать раздел со смартфонами.
  Это позволит мне выбрать понравившийся смартфон и просмотреть его характеристики.

  Сценарий: Просмотр страницы Смартфоны
    Дано Открыта страница "Стартовая страница сайта DNS"
    Когда Выполнен переход на страницу "Смартфоны"
    И Открыта страница "Смартфоны"
    И Установлена сортировка "Сначала дорогие"
    И В фильтре "Производитель" выбрано значение "Samsung"
    И В фильтре "Объем оперативной памяти" выбрано значение "8 Гб"
    И Применены фильтры
    И Выполнен переход на страницу первого продукта в списке
    И Открыта страница "Продукт. Смартфон"
    Тогда Проверка: Заголовок страницы соответствует ожидаемому