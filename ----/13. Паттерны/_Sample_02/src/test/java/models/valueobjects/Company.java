package models.valueobjects;

import java.io.Serializable;

// Класс объект-значение Производитель
public class Company implements Serializable {
    // Производитель
    private String company;

    // Конструктор по умолчанию
    public Company() {

    }

    // Конструктор с проверкой
    public Company(String company) {
        if (!company.isBlank() || !company.isEmpty())
            this.company = company;
        else
            throw new IllegalArgumentException("Наименование производителя не может быть пустым!");
    }

    // Геттер
    public String getCompany() {
        return this.company;
    }

    // Переопределенный метод сравнения
    public boolean equals(Company otherCompany) {
        return this.company.equals(otherCompany.company);
    }
}
