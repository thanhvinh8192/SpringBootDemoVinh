package model;

public interface CheckRegister {
    boolean checkPhoneNumber(String phoneNumber);
    boolean checkPassword(String password);
    boolean checkEmail(String email);
}
