package com.xpj.play;

public class BinSearch {
    private static final Object Object = null;

    public static <T extends Comparable<T>> int search(T key, T[] array) {
        int low = 0;
        int mid = 0;
        int high = array.length;

        while (low <= high) {
            mid = (low + high) / 2;
            if (key.compareTo(array[mid]) > 0) {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//   Integer[] aIntegers=Object[];
        String aString = (String) Object;
    }

}
