package org.example.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class LoginPanel extends JFrame {
    private JTextField cardNumberField;
    private JPasswordField passwordField;
    private final LoginListener loginListener;

    public LoginPanel(LoginListener loginListener) {
        this.loginListener = loginListener;
    }
    public void clear(){
        cardNumberField.setText("");
        passwordField.setText("");
    }
    public void runLogin() {
        setTitle("BANKOMAT");
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/main/resources/logo.jpg"));
        }catch (Exception e){
            System.out.println("Can`t open logo");
            System.exit(0);
        }
        ImageIcon i1 = new ImageIcon(image);
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(70, 10, 100, 100);
        add(l11);

        JLabel l1 = new JLabel("WELCOME TO CRUD BANK");
        l1.setFont(new Font("Osward", Font.BOLD, 34));
        l1.setBounds(200, 40, 500, 40);
        add(l1);

        JLabel l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125, 150, 375, 30);
        add(l2);

        cardNumberField = new JTextField(15);
        cardNumberField.setBounds(300, 150, 230, 30);
        cardNumberField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardNumberField);

        JLabel l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125, 220, 375, 30);
        add(l3);

        passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Arial", Font.BOLD, 14));
        passwordField.setBounds(300, 220, 230, 30);
        add(passwordField);

        JButton buttonSignIn = new JButton("SIGN IN");
        buttonSignIn.setBackground(Color.BLACK);
        buttonSignIn.setForeground(Color.WHITE);

        JButton buttonClear = new JButton("CLEAR");
        buttonClear.setBackground(Color.BLACK);
        buttonClear.setForeground(Color.WHITE);

        JButton buttonSignUp = new JButton("SIGN UP");
        buttonSignUp.setBackground(Color.BLACK);
        buttonSignUp.setForeground(Color.WHITE);

        setLayout(null);

        buttonSignIn.setFont(new Font("Arial", Font.BOLD, 14));
        buttonSignIn.setBounds(300, 300, 100, 30);
        add(buttonSignIn);

        buttonClear.setFont(new Font("Arial", Font.BOLD, 14));
        buttonClear.setBounds(430, 300, 100, 30);
        add(buttonClear);

        buttonSignUp.setFont(new Font("Arial", Font.BOLD, 14));
        buttonSignUp.setBounds(300, 350, 230, 30);
        add(buttonSignUp);
        buttonSignIn.addActionListener(e -> loginListener.signIn(cardNumberField.getText(),new String(passwordField.getPassword()) ));
        buttonClear.addActionListener(e -> loginListener.clear());
        buttonSignUp.addActionListener(e -> loginListener.signUp());

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setLocation(550, 200);
    }

}
