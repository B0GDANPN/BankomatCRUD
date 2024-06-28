package org.example.view;

import org.example.model.Conn;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;

public class BalancePanel extends JFrame {
    JButton b1;
    JLabel l1;
    BalanceListener balanceListener;

    public BalancePanel(BalanceListener balanceListener) {
        this.balanceListener = balanceListener;
    }

    public void runBalance(String cardNumber) {
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

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190, 350, 400, 35);
        l3.add(l1);

        b1.setBounds(390, 633, 150, 35);
        l3.add(b1);
        int balance = 0;
        String q="select * from bank where cardNumber = '" + cardNumber + "'";
        try (Conn conn = new Conn();
             ResultSet rs = conn.getStatement().executeQuery(q)){
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println("runBalance error: " + e);
        }

        l1.setText("Your Current Account Balance is RUB " + balance);

        b1.addActionListener(e -> balanceListener.backBalance());

        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
    }
}
