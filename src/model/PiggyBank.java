package model;

import model.Coin;

public class PiggyBank {

    private int balance;
    private int coinCount;

    public PiggyBank(){
        balance = 0;
        coinCount = 0;
    }

    public void insert(Coin c1) {
        balance += c1.getValue();
        ++coinCount;
    }

    public int getBalance() {
        return balance;
    }

    public int getCoinCount() {
        return coinCount;
    }

    public void withdraw(CoinTwo c1) {
        balance -= c1.getValue();
        --coinCount;
    }
}
