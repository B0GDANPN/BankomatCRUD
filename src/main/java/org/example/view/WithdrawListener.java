package org.example.view;
public interface WithdrawListener {
    void withdraw(String cardNumber, String amount);

    void backWithdraw();
}
