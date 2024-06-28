package org.example.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PinPanel extends JFrame {
    private final PinListener pinListener;
    public PinPanel(PinListener pinListener) {
        this.pinListener = pinListener;
    }

    public void runChangePin(String cardNumber) {
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
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 960, 1080);
        add(l4);

        JLabel l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);

        JLabel l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);

        JPasswordField t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));

        JButton b1 = new JButton("CHANGE");
        JButton b2 = new JButton("BACK");

        b1.addActionListener(e->pinListener.updatePin(cardNumber,t1.getText()));
        b2.addActionListener(e -> pinListener.backPin());

        setLayout(null);

        l1.setBounds(280,330,800,35);
        l4.add(l1);

        l2.setBounds(180,390,150,35);
        l4.add(l2);
        t1.setBounds(350,390,180,25);
        l4.add(t1);

        b1.setBounds(390,588,150,35);
        l4.add(b1);

        b2.setBounds(390,633,150,35);
        l4.add(b2);

        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
    }
}
