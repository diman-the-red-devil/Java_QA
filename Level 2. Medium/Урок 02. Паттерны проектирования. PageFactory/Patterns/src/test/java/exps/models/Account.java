package exps.models;

import exps.models.valueobjects.FullName;
import exps.models.valueobjects.Login;
import exps.models.valueobjects.MobilePhone;
import exps.models.valueobjects.Password;

import java.io.Serializable;
import java.util.Date;

// Учетные данные
public class Account implements Serializable {
    // Поля
    private Login login;
    private Password password;
    private MobilePhone mobilePhone;
    private FullName fullName;
    private Date dateOfBirth;

    // Конструктор без параметров
    public Account() {

    }

    // Конструктор
    public Account(Login login, Password password) {
        this.login = login;
        this.password = password;
    }

    // Геттеры и сеттеры
    public void setLogin(Login login) {
        this.login = login;
    }

    public Login getLogin() {
        return this.login;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public Password getPassword() {
        return this.password;
    }

    public void setMobilePhone(MobilePhone mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public MobilePhone getMobilePhone() {
        return this.mobilePhone;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public FullName getFullName() {
        return this.fullName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
}
