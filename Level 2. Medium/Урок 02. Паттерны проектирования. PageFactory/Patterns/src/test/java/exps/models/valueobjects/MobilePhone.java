package exps.models.valueobjects;

import java.io.Serializable;

// Номер мобильного телефона
public class MobilePhone implements Serializable {
    // Поле
    private String mobilePhone;

    // Конструктор
    public MobilePhone(String mobilePhone) {
        if (!mobilePhone.isBlank() && !mobilePhone.isEmpty())
            this.mobilePhone = mobilePhone;
        else
            throw new IllegalArgumentException("Номер мобильного не можеь быть пустым");
    }

    // Геттер
    public String getMobilePhone() {
        return this.mobilePhone;
    }
}
