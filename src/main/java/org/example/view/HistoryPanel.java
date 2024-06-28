package org.example.view;

import org.example.model.Conn;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class HistoryPanel extends JFrame {
    private final HistoryListener historyListener;

    public HistoryPanel(HistoryListener historyListener) {
        super("History");
        this.historyListener = historyListener;
    }

    public void runHistory(String cardNumber) {
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);

        JLabel l1 = new JLabel();
        l1.setBounds(20, 60, 300, 300);
        add(l1);

        JLabel l2 = new JLabel("CRUD Bank");
        l2.setBounds(150, 20, 100, 20);
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);
        String q = "select * from signup where cardNumber = '" + cardNumber + "'";
        try (var conn = new Conn();
             ResultSet rs = conn.getStatement().executeQuery(q)) {
            while (rs.next()) {
                l3.setText("Card Number:    " + rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println("run History error: " + e);
        }
        String q2 = "select * from bank where cardNumber = '" + cardNumber + "'";
        try (var conn = new Conn(); ResultSet rs = conn.getStatement().executeQuery(q2)) {
            int balance = 0;
            while (rs.next()) {
                l1.setText(l1.getText() + rs.getString("type") + " " + rs.getString("amount"));
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is RUB " + balance);
        } catch (Exception e) {
            System.out.println("run History error: " + e);
        }

        setLayout(null);
        JButton b1 = new JButton("Exit");
        add(b1);

        b1.addActionListener(e -> historyListener.exitHistory());

        b1.setBounds(20, 500, 100, 25);
    }
}
