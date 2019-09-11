package org.maple.demo13stopInterrupt;

/**
 * @author Mapleins
 * @date 2019-09-10 11:51
 * @description isInterrupted 调用的线程类 是否停止，调用不会清空状态，需要注意!
 */
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Thread4 t4 = new Thread4();
        t4.start();
        t4.interrupt();
        // true
        System.out.println("是否停止了1？ = " + t4.isInterrupted());
        // true
        System.out.println("是否停止了2？ = " + t4.isInterrupted());
        System.out.println("end ~~~");
    }
}

class Thread4 extends Thread{

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            System.out.println("i : " + i);
        }
    }
}
