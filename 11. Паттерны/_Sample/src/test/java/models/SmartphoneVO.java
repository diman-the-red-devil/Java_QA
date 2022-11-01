package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;

import java.io.Serializable;

// Класс "Смартфон"
public class SmartphoneVO implements Serializable {
    // Оперативная память
    private Ram ram;
    // Производитель
    private Company company;

    // Конструктор по умолчанию
    public SmartphoneVO() {

    }

    // Конструктор
    public SmartphoneVO(Ram ram, Company company) {
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
    // Производитель
    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return this.company;
    }
}
