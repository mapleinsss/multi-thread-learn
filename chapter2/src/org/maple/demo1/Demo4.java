package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-11 11:32
 * @description 实验 synchronized 排队效果
 */
public class Demo4 {
    public static void main(String[] args) {
        Obj1 obj1 = new Obj1();
        T4A t4A = new T4A(obj1);
        t4A.setName("A");
        T4B t4B = new T4B(obj1);
        t4B.setName("B");
        t4A.start();
        t4B.start();
    }
}

class Obj1 {
    /**
     * 实验结论：调用 synchronized 声明的方法一定是排队运行的，如果没有共享资源的访问，那么根本没有同步的必要
     */
    synchronized public void methodA() {
        try {
            System.out.println("begin methodA threadName = " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class T4A extends Thread {

    private Obj1 obj1;

    public T4A(Obj1 obj1){
        this.obj1 = obj1;
    }

    @Override
    public void run() {
        obj1.methodA();
    }
}

class T4B extends Thread {

    private Obj1 obj1;

    public T4B(Obj1 obj1){
        this.obj1 = obj1;
    }

    @Override
    public void run() {
        obj1.methodA();
    }
}