package models;

import models.valueobjects.Product;
import models.valueobjects.Ram;

import java.io.Serializable;

// Класс "Смартфон"
public class SmartphoneBL implements Serializable {
    // Оперативная память
    private Ram ram;
    // Внутренняя память
    private int rom;
    // Производитель
    private Product product;
    // Модель
    private String model;

    // Конструктор по умолчанию
    public SmartphoneBL() {

    }

    // Конструктор
    public SmartphoneBL(Ram ram, Product product) {
        this.ram = ram;
        this.product = product;
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
        return this.rom;
    }

    // Производитель
    public void setProduct(Product product) {
        this.product = product;
    }
    public Product getProduct() {
        return this.product;
    }

    // Модель
    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() {
        return this.model;
    }
}
