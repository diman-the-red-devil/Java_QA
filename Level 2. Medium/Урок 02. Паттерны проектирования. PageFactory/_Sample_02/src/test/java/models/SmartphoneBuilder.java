package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;

// Класс строитель объекта "Смартфон"
public class SmartphoneBuilder {
    // Экземпляр класса "Смартфон"
    private Smartphone smartphone = new Smartphone();

    // Установка значения поля "Оперативная память"
    public SmartphoneBuilder setRam(int value) {
        Ram ram = new Ram(value);
        smartphone.setRam(ram);
        return this;
    }

    // Установка значения поля "Внутренняя память"
    public SmartphoneBuilder setRom(int value) {
        smartphone.setRom(value);
        return this;
    }

    // Установка значения поля "Компания"
    public SmartphoneBuilder setCompany(String value) {
        Company company = new Company(value);
        smartphone.setCompany(company);
        return this;
    }

    // Установка значения поля "Модель"
    public SmartphoneBuilder setModel(String value) {
        smartphone.setModel(value);
        return this;
    }

    // Создание объекта "Смартфон"
    public Smartphone build() {
        return smartphone;
    }
}
