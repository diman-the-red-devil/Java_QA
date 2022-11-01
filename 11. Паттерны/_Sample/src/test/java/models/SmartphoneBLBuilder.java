package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;

// Класс строитель объекта "Смартфон"
public class SmartphoneBLBuilder {
    // Оперативная память
    private Ram ram;
    // Внутренняя память
    private int rom = 256; // значение заданное по умолчанию - 256
    // Производитель
    private Company сompany;
    // Модель
    private String model = "Galaxy S20"; // значение заданное по умолчанию - Galaxy S20

    // Конструктор
    public SmartphoneBLBuilder(Ram ram, Company сompany) {
        this.ram = ram;
        this.сompany = сompany;
    }

    // Установка значения поля "Внутренняя память"
    public SmartphoneBLBuilder setRom(int rom) {
        this.rom = rom;
        return this;
    }

    // Установка значения поля "Модель"
    public SmartphoneBLBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    // Создание объекта "Смартфон"
    public SmartphoneBL build() {
        SmartphoneBL smartphone = new SmartphoneBL();
        smartphone.setRam(this.ram);
        smartphone.setRom(this.rom);
        smartphone.setCompany(this.сompany);
        smartphone.setModel(this.model);
        return smartphone;
    }
}
