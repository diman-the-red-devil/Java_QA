package exps.models.valueobjects;

public class MobilePhone {
    private String mobilePhone;

    public MobilePhone(String mobilePhone) {
        if (!mobilePhone.isBlank() && !mobilePhone.isEmpty())
            this.mobilePhone = mobilePhone;
        else
            throw new IllegalArgumentException("Номер мобильного не можеь быть пустым");
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }
}
