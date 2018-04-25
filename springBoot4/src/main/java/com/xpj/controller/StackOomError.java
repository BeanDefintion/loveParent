package com.xpj.controller;

public class StackOomError implements Runnable {

    public void stackLeakByThread() {
        while (true) {
            new Thread(() -> {
                donotstop();
            }).start();
        }
    }

    private void donotstop() {
        // TODO Auto-generated method stub
        while (true) {

        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        StackOomError stackOomError = new StackOomError();
        stackOomError.stackLeakByThread();
    }
}
