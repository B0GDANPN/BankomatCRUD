package org.example.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class SignupPanel extends JFrame {
    JLabel l1, l2, l3, l6, l7, l9, l10, l12;
    JTextField t1, t3, t4, t5, t6, t7;
    JRadioButton r1, r2;
    JButton b;


    Random ran = new Random();
    long tmp = (ran.nextLong() % 9000L) + 1000L;
    String formNumber = "" + Math.abs(tmp);
    long tmp1 = (ran.nextLong() % 90000000L) + 5040936000000000L;
    String cardNumber = "" + Math.abs(tmp1);

    private final SignupListener signupListener;
    public SignupPanel(SignupListener signupListener) {
        this.signupListener = signupListener;
    }

    public void runSignUp() {
        setTitle("NEW ACCOUNT APPLICATION FORM");
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/main/resources/logo.jpg"));
        } catch (Exception e) {
            System.out.println("Can`t open logo");
            System.exit(0);
        }
        ImageIcon i1 = new ImageIcon(image);
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(20, 0, 120, 100);
        add(l11);

        l1 = new JLabel("APPLICATION FORM NO. " + formNumber);
        l1.setFont(new Font("Raleway", Font.BOLD, 30));

        l2 = new JLabel("Page 1: Personal Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));

        l3 = new JLabel("Name:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));

        l6 = new JLabel("Gender:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));

        l7 = new JLabel("Email Address:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));

        l9 = new JLabel("Address:");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));

        l10 = new JLabel("City:");
        l10.setFont(new Font("Raleway", Font.BOLD, 20));

        l11 = new JLabel("Pin Code:");
        l11.setFont(new Font("Raleway", Font.BOLD, 20));

        l12 = new JLabel("State:");
        l12.setFont(new Font("Raleway", Font.BOLD, 20));
        l12.setBounds(100, 590, 200, 30);
        add(l12);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));


        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));

        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));

        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));

        t6 = new JTextField();
        t6.setFont(new Font("Raleway", Font.BOLD, 14));

        t7 = new JTextField();
        t7.setFont(new Font("Raleway", Font.BOLD, 14));


        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);


        setLayout(null);
        l1.setBounds(140, 20, 600, 40);
        add(l1);

        l2.setBounds(290, 80, 600, 30);
        add(l2);

        l3.setBounds(100, 140, 100, 30);
        add(l3);

        t1.setBounds(300, 140, 400, 30);
        add(t1);

        l6.setBounds(100, 290, 200, 30);
        add(l6);

        r1.setBounds(300, 290, 90, 30);
        add(r1);

        r2.setBounds(450, 290, 90, 30);
        add(r2);

        l7.setBounds(100, 340, 200, 30);
        add(l7);

        t3.setBounds(300, 340, 400, 30);
        add(t3);


        l9.setBounds(100, 440, 200, 30);
        add(l9);

        t4.setBounds(300, 440, 400, 30);
        add(t4);

        l10.setBounds(100, 490, 200, 30);
        add(l10);

        t5.setBounds(300, 490, 400, 30);
        add(t5);

        l11.setBounds(100, 540, 200, 30);
        add(l11);

        t6.setBounds(300, 540, 400, 30);
        add(t6);

        t7.setBounds(300, 590, 400, 30);
        add(t7);

        b.setBounds(620, 660, 80, 30);
        add(b);

        b.addActionListener(e -> signupListener.next(cardNumber,formNumber, t1.getText(), r1.isSelected() ? "Male" : "Female", t3.getText(), t4.getText(), t5.getText(), t6.getText(), t7.getText()));
        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(500, 120);
    }
}
