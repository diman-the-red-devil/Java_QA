package models.valueobjects;

import java.io.Serializable;

// Класс объект-значение ОП
public class Ram implements Serializable {
    // ОП
    private int ram;

    // Конструктор по умолчанию
    public Ram() {

    }

    // Конструктор с проверкой
    public Ram(int ram) {
        // Если задано значение меньше 0, то выбросить исключение
        if (ram > 0)
            this.ram = ram;
        else
            throw new IllegalArgumentException("ОП не может быть меньше 0!");
    }

    // Геттер
    public int getRam() {
        return this.ram;
    }

    // Переопределенный метод сравнения
    public boolean equals(Ram otherRam) {
        return this.ram == otherRam.ram;
    }
}
