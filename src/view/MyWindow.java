package view;

import control.InsertButtonListener;
import control.WithdrawButtonListener;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {

    private JTextArea display = new JTextArea("Welcome to my PiggyBank!");
    private JRadioButton[] rbuttons = new JRadioButton[3];
    private JButton insertButton = new JButton("Select Your Coin ");
    private JButton withdrawButton = new JButton("Withdrawal ");


    public void init(){
        setSize(600, 400);
        setLocation (200,100);
        setTitle("PiggyBank simulator");

        Container cp = getContentPane();
        JScrollPane scrollPane = new JScrollPane(display,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        cp.add(BorderLayout.CENTER, display);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(3, 1));

        JPanel radioPanel = new JPanel();
        ButtonGroup radioGroup = new ButtonGroup();
        for (int i = 0; i < rbuttons.length; i++) {
            rbuttons[i] = new JRadioButton();
            radioPanel.add(rbuttons[i]);
            radioGroup.add(rbuttons[i]);
        }

        rbuttons[0].setText("5 cents");
        rbuttons[1].setText("10 cents");
        rbuttons[2].setText("25 cents");
        bottomPanel.add(radioPanel);
        bottomPanel.add(insertButton);
        bottomPanel.add(withdrawButton);

        cp.add(BorderLayout.SOUTH, bottomPanel);

        //event button
        insertButton.addActionListener(new InsertButtonListener(this));

        withdrawButton.addActionListener(new WithdrawButtonListener(this));
    }

    public JTextArea getDisplay(){
        return display;
    }

    public JRadioButton[] getRbuttons(){
        return rbuttons;
    }
}
