package com.xpj.synchron;

public class Transfer {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Bank bank = new Bank();
        Thread thread1 = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                System.err.println("账户1的余额是:");
                bank.deposit(10);

            }

        });

        Thread thread2 = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                System.err.println("账户2的余额是:");
                bank.deposit(10);

            }

        });

        thread1.setName("一号");
        thread1.start();
        thread2.setName("二号");
        thread2.start();
    }

}
