package org.example.view;

@FunctionalInterface
public interface SignupListener {

    void next(String cardNumber, String formNumber, String name, String gender, String email, String address, String city, String pin, String state);
}
