package com.xpj.controller;

import java.util.ArrayList;
import java.util.List;

public class HeapOomMock {

    public static void main(String[] args) {
        List<byte[]> bytes = new ArrayList<byte[]>();
        int i = 1;
        while (true) {
            try {
                i++;
                bytes.add(new byte[1024 * 1024]);
            } catch (Throwable e) {
                e.printStackTrace();
                System.err.println(i);
            }
        }
    }
}
