package com.myTest.sort10;

/**
 * 从一批数据中查找前10个最大值。正常的想法是构建一个10个数的数组，轮询查找的数据并与10个数中最小的比较，然后替换。
 *  另一种思路采用大顶堆的方式。但是只用构建10次大顶堆即可。
 * 多次运行程序后的结论：
 * 100000000个数中普通查找速度大概是18秒，而堆方式查找只有13秒，随着数据量的增大，差距会更加明显。
 *
 * Created by winkey on 15-1-12.
 * 普通排序：
 */
public class NormalSort {
    private static int  array[] = new int[100000000];
    private static int  base[] = new int[10];

    public static void main(String[] args) {
        init();
        long t = System.currentTimeMillis();
        sort();
        sysout(t);
    }

    private static void sysout(long t) {
        for(int i =0; i < base.length; i ++){
            System.out.println(base[i]);
        }
        System.out.println("cost time =" + (System.currentTimeMillis()-t));
    }

    private static void init() {
        for(int i =0; i < array.length; i++){
            array[i] = (int)Math.round(Math.random() * array.length);
        }
        for(int i =0; i< base.length;i++){
            base[i] = array[i];
        }
    }

    private static void sort() {
        for(int i =base.length - 1; i < array.length; i++){
            long min = base[0];
            int index = 0;
            for(int j=0; j< base.length; j++){
                if(base[j] < min){
                    index = j;
                    min = base[j];
                }
            }
            if(array[i] > min){
                int tmp = array[i];
                array[i] = base[index];
                base[index] = tmp;
            }
        }
    }
}
