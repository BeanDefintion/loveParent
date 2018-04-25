package com.xpj.controller;

public class StackMockError {

    private static int index = 1;

    public void call() {
        index++;
        call();
    }

    public static void main(String[] args) {
        StackMockError mockError = new StackMockError();
        try {
            mockError.call();
        } catch (Throwable e) {
            e.printStackTrace();
            System.err.println(index);
        }

    }

}
