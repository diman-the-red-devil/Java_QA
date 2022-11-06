package models;

import java.io.Serializable;

// Класс "Смартфон"
public class SmartphoneJB implements Serializable {
    // Оперативная память
    private int ram;
    // Производитель
    private String company;

    // Конструктор по умолчанию
    public SmartphoneJB() {

    }

    // Конструктор
    public SmartphoneJB(int ram, String company) {
        this.ram = ram;
        this.company = company;
    }

    // Сеттеры и геттеры

    // Оперативная память
    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRam() {
        return this.ram;
    }

    // Производитель
    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return this.company;
    }
}
