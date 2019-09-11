package org.maple.demo14resumeSuspend;

/**
 * @author Mapleins
 * @date 2019-09-11 9:03
 * @description 输出流同步锁 在使用 suspend() 会出现的问题
 */
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        Thread3 t3 = new Thread3();
        t3.start();
        Thread.sleep(1000);
        t3.suspend();
        System.out.println("main end");
    }
}

class Thread3 extends Thread {

    private long i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
            /**
             * while(true) 一直在运行，当 t3 调用 suspend() 后，下面的 println() 会一直占有锁
             * main 方法中的 println() 却因为拿不到锁，一直无法打印
             */
            System.out.println(i);
        }
    }
}