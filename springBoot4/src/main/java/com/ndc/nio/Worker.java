package com.ndc.nio;

public class Worker implements Runnable {

    @Override
    public void run() {
//		for (int i = 0; i < 5; i++) {
//			System.err.println("第" + i + "次更新");
//		}

        while (true) {
            try {
                Thread.sleep(100000);
//				Thread.currentThread().stop();
                System.err.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

}
