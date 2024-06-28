package org.example.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class TransactionPanel extends JFrame {
    private final TransactionListener transactionsListener;

    public TransactionPanel(TransactionListener transactionsListener) {
        this.transactionsListener = transactionsListener;
    }

    public void runTransaction(String cardNumber) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/main/resources/atm.jpg"));
        } catch (Exception e) {
            System.out.println("Can`t open logo");
            System.exit(0);
        }
        ImageIcon i1 = new ImageIcon(image);
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);

        JLabel l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));


        JButton b1 = new JButton("CASH DEPOSIT");
        JButton b2 = new JButton("CASH WITHDRAWL");
        JButton b4 = new JButton("LOCAL HISTORY");
        JButton b5 = new JButton("PIN CHANGE");
        JButton b6 = new JButton("BALANCE ENQUIRY");
        JButton b7 = new JButton("EXIT");

        setLayout(null);

        l1.setBounds(235, 400, 700, 35);
        l2.add(l1);

        b1.setBounds(170, 499, 150, 35);
        l2.add(b1);

        b2.setBounds(390, 499, 150, 35);
        l2.add(b2);

        b4.setBounds(390, 543, 150, 35);
        l2.add(b4);

        b5.setBounds(170, 588, 150, 35);
        l2.add(b5);

        b6.setBounds(390, 588, 150, 35);
        l2.add(b6);

        b7.setBounds(390, 633, 150, 35);
        l2.add(b7);


        b1.addActionListener(e -> transactionsListener.cashDeposit(cardNumber));
        b2.addActionListener(e -> transactionsListener.cashWithdraw(cardNumber));
        b4.addActionListener(e -> transactionsListener.getHistory(cardNumber));
        b5.addActionListener(e -> transactionsListener.changePin(cardNumber));
        b6.addActionListener(e -> transactionsListener.getBalance(cardNumber));
        b7.addActionListener(e -> transactionsListener.exit());
        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);

    }
}
