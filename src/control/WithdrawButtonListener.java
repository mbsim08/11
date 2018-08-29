package control;

import model.CoinTwo;
import view.MyWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawButtonListener implements ActionListener {

    private MyWindow win;
    private JTextArea display;
    private JRadioButton[] rbuttons;

    public WithdrawButtonListener(MyWindow win) {
        this.win = win;
        display = win.getDisplay();
        rbuttons = win.getRbuttons();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int valueTwo = 0;
        if (rbuttons[0].isSelected()) {
            valueTwo = 5;
        } else if (rbuttons[1].isSelected()) {
            valueTwo = 10;

        } else if (rbuttons[2].isSelected()){
            valueTwo = 25;
        }

        if (valueTwo ==0) {
            return;
        }

        Main.piggyBank.withdraw(new CoinTwo(valueTwo));

        String m = display.getText();
        String newMessage = String.format("%s\nCoin(%d) withdrawn, balance = %d coin count = %d",
                m, valueTwo, Main.piggyBank.getBalance(), Main.piggyBank.getCoinCount());
        display.setText(newMessage);
    }
}
