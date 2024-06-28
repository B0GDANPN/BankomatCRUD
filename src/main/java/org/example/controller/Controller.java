package org.example.controller;

import org.example.model.Conn;
import org.example.view.*;

import javax.swing.*;
import java.sql.ResultSet;

public class Controller implements LoginListener, SignupListener, TransactionListener, DepositListener, WithdrawListener, HistoryListener, BalanceListener, PinListener {
    private final View view;

    public Controller() {
        view = new View(this, this, this, this, this, this, this, this);
    }

    public void run() {
        view.runLogin();
    }

    //////////// signin in login
    @Override
    public void signIn(String cardNumber, String pin) {
        if (cardNumber.isEmpty() || pin.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill all the required fields");
        } else {
            String q = "select * from signup where cardNumber = '" + cardNumber + "' and pin = '" + pin + "'";
            try (var conn = new Conn();
                 ResultSet rs = conn.getStatement().executeQuery(q)) {
                if (rs.next()) {
                    view.hideLoginPanel();
                    view.runTransactionPanel(cardNumber);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
            }
        }
    }

    //////////// signup in login
    @Override
    public void signUp() {
        //view.hideLoginPanel();
        view.runSignup();
        view.showSignupPanel();
    }

    //////////// clear in login
    @Override
    public void clear() {
        view.clearLoginPanel();
    }

    //////////// next in signup in login
    @Override
    public void next(String cardNumber, String formNumber, String name, String gender, String email, String address, String city, String pin, String state) {
        if (name.isEmpty() || gender.isEmpty() || email.isEmpty() || address.isEmpty() || city.isEmpty() || pin.isEmpty() || state.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill all the required fields");
        } else {
            String q = "insert into signup values('" + cardNumber + "','" + formNumber + "','" + name + "','" + gender + "','" + email + "','" + address + "','" + city + "','" + pin + "','" + state + "')";
            try (var conn = new Conn()) {
                conn.getStatement().executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Account Created. cardNumber: " + cardNumber + " Pin: " + pin);
                view.hideSignupPanel();


            } catch (Exception e) {
                System.out.println("next error: " + e);
            }
        }
    }


    //////////// exit
    @Override
    public void exit() {
        System.exit(0);
    }

    ////////////// withdraw
    @Override
    public void cashWithdraw(String cardNumber) {
        view.hideTransactionPanel();
        view.runCashWithdraw(cardNumber);
    }

    @Override
    public void withdraw(String cardNumber, String amount) {
        if (amount.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
        } else {
            String q = "select * from bank where cardNumber = '" + cardNumber + "'";
            try (var conn = new Conn();
                 ResultSet rs = conn.getStatement().executeQuery(q)) {
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }
                String q2 = "insert into bank values('" + cardNumber + "', 'Withdraw', '" + amount + "')";
                conn.getStatement().executeUpdate(q2);
            } catch (Exception e) {
                System.out.println("withdraw error: " + e);
            }
            JOptionPane.showMessageDialog(null, "RUB. " + amount + " Withdrawn Successfully");
            backWithdraw();
        }
    }

    @Override
    public void backWithdraw() {
        view.hideWithdrawPanel();
        view.showTransactionPanel();
    }

    //////////// deposit
    @Override
    public void cashDeposit(String cardNumber) {
        view.hideTransactionPanel();
        view.runCashDeposit(cardNumber);
    }

    //////////// deposit in cash deposit
    @Override
    public void deposit(String cardNumber, String amount) {
        if (amount.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
        } else {
            String q = "insert into bank values('" + cardNumber + "', 'Deposit', '" + amount + "')";
            try (var conn = new Conn()) {
                conn.getStatement().executeUpdate(q);

            } catch (Exception e) {
                System.out.println("deposit error: " + e);
            }
            JOptionPane.showMessageDialog(null, "RUB. " + amount + " Deposited Successfully");
            view.hideDepositPanel();
            view.showTransactionPanel();
        }
    }

    @Override
    public void backDeposit() {
        view.hideDepositPanel();
        view.showTransactionPanel();
    }

    //////////// balance
    @Override
    public void getBalance(String cardNumber) {
        view.hideTransactionPanel();
        view.runBalance(cardNumber);
    }


    @Override
    public void backBalance() {
        view.hideBalancePanel();
        view.showTransactionPanel();
    }

    //////////// change pin
    @Override
    public void changePin(String cardNumber) {
        view.hideTransactionPanel();
        view.runChangePin(cardNumber);
    }

    @Override
    public void updatePin(String cardNumber, String newPin) {
        if (newPin.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the newPin");
        } else {
            String updateQuery = "UPDATE signup SET pin = '" + newPin + "' WHERE cardNumber = '" + cardNumber + "'";
            try (var conn = new Conn()) {
                conn.getStatement().executeUpdate(updateQuery);

            } catch (Exception e) {
                System.out.println("updatePin error: " + e);
            }
            JOptionPane.showMessageDialog(null, "Pin updated");
            view.hidePinPanel();
            view.showTransactionPanel();
        }
    }

    @Override
    public void backPin() {
        view.hidePinPanel();
        view.showTransactionPanel();
    }

    //////////// history
    @Override
    public void getHistory(String cardNumber) {
        view.hideTransactionPanel();
        view.runHistory(cardNumber);
    }

    @Override
    public void exitHistory() {
        view.hideHistoryPanel();
        view.showTransactionPanel();
    }
}