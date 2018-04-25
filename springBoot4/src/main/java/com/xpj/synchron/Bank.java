package com.xpj.synchron;

public class Bank {

    private volatile int account = 100;

    public void deposit(int money) {
        account += money;
        System.err.println(account);
    }

    public int getAccount() {
        return account;
    }

}
