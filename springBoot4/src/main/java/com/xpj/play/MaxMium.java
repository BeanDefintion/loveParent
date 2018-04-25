package com.xpj.play;

public class MaxMium<T extends Comparable<T>> implements max<T> {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    @Override
    public T getmax(T[] array) {
        // TODO Auto-generated method stub
        if (array == null || array.length == 0) {
            return null;
        }
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }

}
