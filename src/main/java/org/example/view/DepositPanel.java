package org.example.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class DepositPanel extends JFrame {
    JTextField t1;
    JButton b1;
    JButton b2;
    JLabel l1;
    DepositListener depositListener;

    public DepositPanel(DepositListener depositListener) {
        this.depositListener = depositListener;
    }

    public void runDeposit(String cardNumber) {
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

        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190,350,400,35);
        l3.add(l1);

        t1.setBounds(190,420,320,25);
        l3.add(t1);

        b1.setBounds(390,588,150,35);
        l3.add(b1);

        b2.setBounds(390,633,150,35);
        l3.add(b2);

        b1.addActionListener(e ->depositListener.deposit(cardNumber, t1.getText()));
        b2.addActionListener(e ->depositListener.backDeposit());

        setSize(960,1080);
        setUndecorated(true);
        setLocation(500,0);
    }
}
