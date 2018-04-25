package com.xpj.play;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TestList {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        System.setErr(new PrintStream(new File("C:\\Users\\15293\\Desktop\\1.txt")));
        List<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lista.add(i);
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            System.err.print(lista.get(i));
        }
        long b = System.currentTimeMillis();

        System.out.println("_______________" + (b - a));

        for (Integer integer : lista) {
            System.err.print(integer);
        }
        long c = System.currentTimeMillis();

        System.out.println("_______________" + (c - b));

        lista.stream().forEach(i -> System.err.println(i));
        long d = System.currentTimeMillis();

        System.out.println("_______________" + (d - c));
    }

}
