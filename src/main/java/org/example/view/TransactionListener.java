package org.example.view;
public interface TransactionListener {
    void exit();
    void cashWithdraw(String cardNumber);

    void cashDeposit(String cardNumber);

    void getBalance(String cardNumber);

    void changePin(String cardNumber);

    void getHistory(String cardNumber);
}
