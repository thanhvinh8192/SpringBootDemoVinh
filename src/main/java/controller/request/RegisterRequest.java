package controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegisterRequest implements CheckRegister {
    private String phoneNumber;
    private String userName;
    private String password;
    private String email;

    public RegisterRequest(String phoneNumber, String userName, String password, String email) {
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", userName='" + userName + '\'' +
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
