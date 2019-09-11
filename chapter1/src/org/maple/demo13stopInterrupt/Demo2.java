package org.maple.demo13stopInterrupt;

/**
 * @author Mapleins
 * @date 2019-09-10 11:28
 * @description
 *                  this.interrupted : 当前线程是否终止 ( 该代码在哪个方法里，调用该方法的线程就是当前线程）
 *                  this.isInterrupted : 线程是否终止
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread2 thread2 = new Thread2();
        thread2.start();
        Thread.sleep(1000);
        thread2.interrupt();
        /**
         * interrupted 是当前线程，main 线程没停止，所有都返回 false
         */
        // false
        System.out.println("是否停止了1？ = " +thread2.interrupted());
        // false
        System.out.println("是否停止了2？ = " +thread2.interrupted());
        // false
        System.out.println("是否停止了3？ = " +Thread.interrupted());
    }
}


class Thread2 extends Thread{

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("i : " + i);
        }
    }
}