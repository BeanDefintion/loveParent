package com.xpj.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TestSort<T> implements Comparable<T>, Comparator<T> {

    @Override
    public int compareTo(T o) {//comparable String Integer内部已经实现
        // TODO Auto-generated method stub
        Collections.sort(null);
        int a[] = new int[11];
        Arrays.sort(a);
        return 0;
    }

    @Override
    public int compare(T o1, T o2) {
        // TODO Auto-generated method stub
        return 0;
    }

}
