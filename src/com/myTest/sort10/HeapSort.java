package com.myTest.sort10;

/**
 * Created by winkey on 15-1-12.
 */
public class HeapSort {
    private static int array[] = new int[100000000];

    /**
     * @param args
     */
    public static void main(String[] args) {
        init();
        long t = System.currentTimeMillis();
        sort();
        System.out.println("cost time " + (System.currentTimeMillis() - t));
    }

    private static void init() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)Math.round(Math.random() * array.length);
        }
    }

    private static void adjust(int array[], int i, int length) {
        int child;
        int temp;
        for (temp = array[i]; 2 * i + 1 < length; i = child) {
            child = 2 * i + 1;
            if (child < length - 1 && array[child + 1] > array[child])
                ++child;
            if (temp < array[child]) {
                array[i] = array[child];
                array[child] = temp;
            } else
                break;
        }
    }

    private static void sort() {
        for (int i = array.length / 2; i >= 0; --i)
            adjust(array, i, array.length);
        int tmp;
        for (int i = array.length - 1; i >= array.length - 11; --i) {
            tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;
            adjust(array, 0, i);
        }
        for (int i = array.length - 11; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
