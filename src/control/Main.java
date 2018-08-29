package control;

import model.Coin;
import model.PiggyBank;
import view.MyWindow;

import javax.swing.*;
import java.util.Random;

public class Main {

    static PiggyBank piggyBank;

    public static void main(String[] args) {

        testCode();

        MyWindow win = new MyWindow(); //CREATED object win
        win.init();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //the window will close

        win.setVisible(true);

        piggyBank = new PiggyBank();
    }

    static void testCode() {

        //TDD: test driven development ==> JUNIT

        PiggyBank p1 = new PiggyBank();
        Coin c1 = new Coin(5); //value of the coin
        p1.insert(c1);
        p1.insert(new Coin(10));

        int balance = p1.getBalance();

        assert(balance == 15) : "balance is wrong";

        p1.insert(new Coin(25));
        assert(p1.getBalance() == 40) : "balance is wrong2";

        assert(p1.getCoinCount() == 3) : "coin count incorrect";

        final int COUNT = 5000;
        PiggyBank p2 = new PiggyBank();
        assert(p2.getBalance() == 0);
        assert(p2.getCoinCount() == 0);

        Random random = new Random();

        int sum = 0;
        for (int i = 1; i <= COUNT; i++) {
            int n = random.nextInt( 100);
            sum += n;
            Coin c = new Coin(n);
            p2.insert(c);

        }
        assert(p2.getCoinCount() == COUNT);
        assert(p2.getBalance() == sum);

       System.out.println("program successfully finished");

    }
}
