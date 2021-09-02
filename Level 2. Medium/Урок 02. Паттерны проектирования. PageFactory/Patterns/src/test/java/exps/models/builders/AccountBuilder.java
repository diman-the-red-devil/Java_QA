package exps.models.builders;

import exps.models.*;
import exps.models.valueobjects.FullName;
import exps.models.valueobjects.Login;
import exps.models.valueobjects.MobilePhone;
import exps.models.valueobjects.Password;

import java.util.Date;

public class AccountBuilder {
    private Login login;
    private Password password;
    private MobilePhone mobilePhone;
    private FullName fullName;
    private Date dateOfBirth;

    public AccountBuilder(Login login, Password password) {
        this.login = login;
        this.password = password;
    }

    public AccountBuilder setMobilePhone(MobilePhone mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public AccountBuilder setFullName(FullName fullName) {
        this.fullName = fullName;
        return this;
    }

    public AccountBuilder setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Account build() {
        Account account = new Account(this.login, this.password);
        account.setMobilePhone(this.mobilePhone);
        account.setFullName(this.fullName);
        account.setDateOfBirth(this.dateOfBirth);
        return account;
    }
}
