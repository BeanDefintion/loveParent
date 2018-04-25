package com.ndc.nio;

public class Timer implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        long time = System.currentTimeMillis();
        long proccessTime = 0;
        while (true) {
            if (System.currentTimeMillis() - time > proccessTime) {
                proccessTime = System.currentTimeMillis() - time;
                System.err.println(proccessTime);
            }
        }
    }

}
