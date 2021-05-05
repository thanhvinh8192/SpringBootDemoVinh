package controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {
    private String phoneNumber;
    private String password;

    public LoginRequest(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
