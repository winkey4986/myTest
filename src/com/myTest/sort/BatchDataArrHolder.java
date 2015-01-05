package com.myTest.sort;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 保存每次主线程读上来的字符串数组
 * @author winkey
 *
 */
public class BatchDataArrHolder {

	private static final int QUEUE_SIZE = 1000000;

    private static Queue<String[]> DATA_QUEUE = new ArrayBlockingQueue<String[]>(QUEUE_SIZE);

    public static void push(String[] data) {
    	DATA_QUEUE.add(data);
    }

    public static String[] take(){
        try {
            return ((ArrayBlockingQueue<String[]>)DATA_QUEUE).take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean isEmpty(){
    	return DATA_QUEUE.isEmpty();
    }
}
