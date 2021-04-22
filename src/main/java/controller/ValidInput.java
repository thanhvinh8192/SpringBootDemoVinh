package controller;

public interface ValidInput {
    boolean checkPhoneNumber(String phoneNumber);
    boolean checkPassword(String password);
    boolean checkEmail(String email);
}
