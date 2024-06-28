package org.example.view;
public interface LoginListener
{
    void signIn(String cardNumber, String pin);
    void signUp();
    void clear();
}