package model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class User implements CheckRegister {
    private String phoneNumber;
    private String userName;
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
        if (password.length() >= 8) return true;
        else return false;
    }

    @Override
    public boolean checkEmail(String email) {
        if (!email.endsWith("@gmail.com")) return true;
        else return false;
    }
}
