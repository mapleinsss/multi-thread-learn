package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-12 15:31
 * @description 验证 synchronized(this) 代码块是锁定当前对象的
 */
public class Demo16 {
    public static void main(String[] args) throws InterruptedException {
        Task16 t = new Task16();
        T16A ta = new T16A(t);
        ta.start();
        Thread.sleep(100);
        T16B tb = new T16B(t);
        tb.start();
    }
}

class Task16 {

    synchronized public void otherMethod() {
        System.out.println("-------------- run -- otherMethod");
    }

    public void doLongTimeTask() {
        synchronized (this) {
            for (int i = 0; i < 10000; i++) {
                System.out.println("synchronized threadName = " + Thread.currentThread().getName() + " i = " + i);
            }
        }
    }
}

class T16A extends Thread{
    private Task16 task16;
    public T16A(Task16 task16){
        this.task16 =task16;
    }
    @Override
    public void run() {
        task16.doLongTimeTask();
    }
}

class T16B extends Thread{
    private Task16 task16;
    public T16B(Task16 task16){
        this.task16 = task16;
    }
    @Override
    public void run() {
        task16.otherMethod();
    }
}