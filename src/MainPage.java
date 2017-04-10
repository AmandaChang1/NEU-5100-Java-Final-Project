package com.neu.jan17.UI;

import sun.applet.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainPage extends JFrame implements ActionListener{
    private JTextField vehicleManagementTextField;
    private JButton customerButton;
    private JButton dealerButton;
    private JPanel MainPage = new JPanel();
    SecondPage se = new SecondPage();

    public MainPage(){
        se.setVisible(false);
        setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("/Users/xiaoshiyao/IdeaProjects/FinalProject/src/com/neu/jan17/UI/background.jpg"));
        add(background);
        background.setLayout(new FlowLayout());
        customerButton = new JButton("Customer");
        dealerButton = new JButton("Dealer");
        //vehicleManagementTextField = new JTextField("Management");
        //vehicleManagementTextField.setText("System");
        //background.add(vehicleManagementTextField);
        background.add(customerButton);
        background.add(dealerButton);
        setTitle("Vehicle Management");
        setSize(1000,500);
        customerButton.addActionListener(this);
        dealerButton.addActionListener(this);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        String label = button.getText();
        if(label.equals("Customer")){
            // redirect to Dealers Information
            MainPage.setVisible(false);
            dispose();
            se.setVisible(true);
        }
        else if(label.equals("Dealer")){
            // redirect to Dealers Management Page
        }
    }

    public static void main(String args[]){
        MainPage main = new MainPage();
    }
}
