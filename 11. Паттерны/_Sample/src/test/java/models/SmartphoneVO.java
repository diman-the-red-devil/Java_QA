package models;

import models.valueobjects.Product;
import models.valueobjects.Ram;

import java.io.Serializable;

// Класс "Смартфон"
public class SmartphoneVO implements Serializable {
    // Оперативная память
    private Ram ram;
    // Производитель
    private Product product;

    // Конструктор по умолчанию
    public SmartphoneVO() {

    }

    // Конструктор
    public SmartphoneVO(Ram ram, Product product) {
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
    // Производитель
    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return this.product;
    }
}
