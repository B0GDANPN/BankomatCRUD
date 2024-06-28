package org.example.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class WithdrawPanel extends JFrame {
    JTextField t1;
    JButton b1;
    JButton b2;
    JLabel l2;
    WithdrawListener withdrawListener;

    public WithdrawPanel(WithdrawListener withdrawListener) {
        this.withdrawListener = withdrawListener;
    }

    public void runWithdraw(String cardNumber) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/main/resources/atm.jpg"));
        } catch (Exception e) {
            System.out.println("Can`t open atm.jpg");
            System.exit(0);
        }
        ImageIcon i1 = new ImageIcon(image);
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);


        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));

        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");

        setLayout(null);

        l2.setBounds(190, 400, 400, 20);
        l3.add(l2);

        t1.setBounds(190, 450, 330, 30);
        l3.add(t1);

        b1.setBounds(390, 588, 150, 35);
        l3.add(b1);

        b2.setBounds(390, 633, 150, 35);
        l3.add(b2);
        b1.addActionListener(e -> withdrawListener.withdraw(cardNumber, t1.getText()));
        b2.addActionListener(e -> withdrawListener.backWithdraw());

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
    }
}
