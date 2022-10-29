package models;

import java.io.Serializable;

// Класс "Смартфон"
public class SmartphoneJB implements Serializable {
    // Оперативная память
    private int ram;
    // Производитель
    private String product;

    // Конструктор по умолчанию
    public SmartphoneJB() {

    }

    // Конструктор
    public SmartphoneJB(int ram, String product) {
        this.ram = ram;
        this.product = product;
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
    public void setProduct(String product) {
        this.product = product;
    }

    public String getProduct() {
        return this.product;
    }
}
