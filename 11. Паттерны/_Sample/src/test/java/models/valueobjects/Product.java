package models.valueobjects;

import java.io.Serializable;

// Класс объект-значение Производитель
public class Product implements Serializable {
    // Производитель
    private String product;

    // Конструктор по умолчанию
    public Product() {

    }

    // Конструктор с проверкой
    public Product(String product) {
        if (!product.isBlank() || !product.isEmpty())
            this.product = product;
        else
            throw new IllegalArgumentException("Наименование производителя не может быть пустым!");
    }

    // Геттер
    public String getProduct() {
        return this.product;
    }

    // Переопределенный метод сравнения
    public boolean equals(Product otherProduct) {
        return this.product.equals(otherProduct.product);
    }
}
