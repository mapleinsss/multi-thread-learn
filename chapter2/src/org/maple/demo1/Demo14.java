package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-12 15:13
 * @description 展示一半同步，一半异步
 */
public class Demo14 {
    public static void main(String[] args) {
        Task14 task14 = new Task14();
        T14A ta = new T14A(task14);
        ta.start();
        T14B tb = new T14B(task14);
        tb.start();
    }
}

class Task14 {
    public void doLongTimeTask() {
        for (int i = 0; i < 100; i++) {
            System.out.println("nosynchronized threadName = " + Thread.currentThread().getName() + " i = " + i);
        }
        System.out.println();
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized threadName = " + Thread.currentThread().getName() + " i = " + i);
            }
        }
    }
}

class T14A extends Thread {
    private Task14 task14;

    public T14A(Task14 task14) {
        this.task14 = task14;
    }

    @Override
    public void run() {
        task14.doLongTimeTask();
    }
}

class T14B extends Thread {
    private Task14 task14;

    public T14B(Task14 task14) {
        this.task14 = task14;
    }

    @Override
    public void run() {
        task14.doLongTimeTask();
    }
}