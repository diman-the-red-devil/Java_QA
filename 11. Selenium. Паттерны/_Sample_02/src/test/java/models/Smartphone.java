package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;

import java.io.Serializable;

// Класс "Смартфон"
public class Smartphone implements Serializable {
    // Оперативная память
    private Ram ram;
    // Внутренняя память
    private int rom;
    // Производитель
    private Company company;
    // Модель
    private String model;

    // Конструктор по умолчанию
    public Smartphone() {

    }

    // Конструктор
    public Smartphone(Ram ram, Company company) {
        this.ram = ram;
        this.company = company;
    }

    // Сеттеры и геттеры
    // Оперативная память
    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Ram getRam() {
        return this.ram;
    }
    // Внутренняя память
    public void setRom(int rom) {
        this.rom = rom;
    }

    public int getRom() {
        return rom;
    }
    // Производитель
    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return this.company;
    }
    // Модель
    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }


}
