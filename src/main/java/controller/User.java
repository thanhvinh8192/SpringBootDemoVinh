package controller;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class User implements ValidInput {
    private String phoneNumber;
    private String password;
    private String email;

    @Override
    public String toString() {
        return "Register{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean checkPhoneNumber(String phoneNumber) {
        if(phoneNumber.length()!=10){
            return true;
        } else
        return false;
    }

    @Override
    public boolean checkPassword(String password) {
        return password.length() >= 8;
    }

    @Override
    public boolean checkEmail(String email) {
        return email.endsWith("@gmail.com");
    }
}
