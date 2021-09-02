package exps.models.valueobjects;

import java.io.Serializable;

// ФИО
public class FullName implements Serializable {
    // Поля
    private String fullName;
    private String firstName;
    private String secondName;
    private String lastName;

    // Конструктор
    public FullName(String fullName) {
        if (!fullName.isBlank() && !fullName.isEmpty()) {
            this.fullName = fullName;
            String[] names = fullName.split(" ");
            if (names.length == 3) {
                firstName = names[0];
                secondName = names[1];
                lastName = names[2];
            } else
                throw new IllegalArgumentException("ФИО задано некорректно!");
        }
        else
            throw new IllegalArgumentException("ФИО не можеь быть пустым!");
    }

    // Геттеры
    public String getFullName() {
        return this.fullName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
