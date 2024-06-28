package org.example.view;
public interface DepositListener {
    void deposit(String cardNumber, String amount);

    void backDeposit();
}
