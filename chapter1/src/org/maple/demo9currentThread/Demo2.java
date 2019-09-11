package org.maple.demo9currentThread;

/**
 * @author Mapleins
 * @date 2019-09-10 9:19
 * @description TODO
 */
public class Demo2 {

    public static void main(String[] args) {
        CountOperate countOperate = new CountOperate();
        Thread thread = new Thread(countOperate);
        thread.setName("A");
        thread.start();
    }
}

class CountOperate extends Thread {

    public CountOperate() {
        System.out.println("CountOperate---begin");
        // main
        System.out.println("Thread.currentThread().getName() : " + Thread.currentThread().getName());
        // Thread-0
        System.out.println("this.getName() : " + this.getName());
        System.out.println("CountOperate---end");
    }

    @Override
    public void run() {
        System.out.println("run---begin");
        // A
        System.out.println("Thread.currentThread().getName() : " + Thread.currentThread().getName());
        // Thread-0
        System.out.println("this.getName() : " + this.getName());
        System.out.println("run---end");
    }
}