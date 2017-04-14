package com.neu.jan17.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Index extends JFrame implements ActionListener {
    private JTextField vehicleManagementTextField;
    private JButton customerButton;
    private JButton dealerButton;
    private JPanel index = new JPanel();
    DealerInfoTable se = new DealerInfoTable();

    public Index() {
        se.setVisible(false);
        setLayout(new BorderLayout());
        URL imgPathUrl = getClass().getResource("background.jpg");
        JLabel background = new JLabel(new ImageIcon(imgPathUrl.getPath()));
        add(background);
        background.setLayout(new FlowLayout());
        customerButton = new JButton("Customer");
        dealerButton = new JButton("Dealer");
        background.add(customerButton);
        background.add(dealerButton);
        setTitle("Vehicle Management");
        setSize(1000, 500);
        customerButton.addActionListener(this);
        dealerButton.addActionListener(this);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String label = button.getText();
        if (label.equals("Customer")) {
            // redirect to Dealers Information
            index.setVisible(false);
            dispose();
            se.setVisible(true);
        } else if (label.equals("Dealer")) {
            // redirect to Dealers Management Page
        }
    }

    public static void main(String args[]) {
        Index main = new Index();
    }
}
