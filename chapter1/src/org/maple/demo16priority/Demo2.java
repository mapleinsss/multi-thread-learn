package org.maple.demo16priority;

/**
 * @author Mapleins
 * @date 2019-09-11 9:29
 * @description 线程优先级的继承性，A线程启动B线程，则B线程和A线程的优先级是一样的
 */
public class Demo2 {
    public static void main(String[] args) {
        System.out.println("main thread begin priority = " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("main thread end priority = " + Thread.currentThread().getPriority());
        new Thread1().start();

    }
}

class Thread1 extends Thread{
    @Override
    public void run() {
        System.out.println("Thread1 run priority = " + this.getPriority());
        Thread2 t2 = new Thread2();
        t2.start();
    }
}

class Thread2 extends Thread{
    @Override
    public void run() {
        System.out.println("Thread2 run priority = " + this.getPriority());
    }
}