package org.maple.demo16priority;

import java.util.Random;

/**
 * @author Mapleins
 * @date 2019-09-11 9:40
 * @description 线程优先级与代码的顺序无关，设置大的一般会先执行完，但是不是一定全部先执行完
 */
public class Demo3 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread3 t3 = new Thread3();
            t3.setPriority(10);
            t3.start();
            Thread4 t4 = new Thread4();
            t4.setPriority(1);
            t4.start();
        }
    }
}

class Thread3 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 50000; j++) {
                int random = new Random().nextInt();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(" thread3 use time = " + (endTime - beginTime));
    }
}

class Thread4 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 50000; j++) {
                int random = new Random().nextInt();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(" thread4 use time = " + (endTime - beginTime));
    }
}