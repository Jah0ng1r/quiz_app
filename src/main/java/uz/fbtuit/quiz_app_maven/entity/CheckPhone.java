package uz.fbtuit.quiz_app_maven.entity;

import java.io.Serializable;

public class CheckPhone implements Serializable {
    Integer phoneNumber;

    public CheckPhone(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CheckPhone() {
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
