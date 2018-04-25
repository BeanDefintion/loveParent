package com.xpj.controller;

public class ThreadTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                for (int i = 0; i < 99; i++) {
                    System.err.println("线程" + i + "  " + System.currentTimeMillis());
                }

            }
        }).start();

        System.err.println("主线程" + System.currentTimeMillis());

    }

}
