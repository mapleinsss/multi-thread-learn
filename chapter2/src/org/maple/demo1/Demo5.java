package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-11 11:48
 * @description 可以看出 如果一个方法加同步 另一个方法不加同步，那么两个线程调用两个方法，是异步的
 *                     如果两个方法都加同步，那么两个线程掉两个方法后进去的会排队，这充分说明了 synchronized 是对象同步锁
 */
public class Demo5 {
    public static void main(String[] args) {
        Obj5 obj5 = new Obj5();
        T5A t5A = new T5A(obj5);
        t5A.setName("a");
        T5B t5B = new T5B(obj5);
        t5B.setName("b");
        t5A.start();
        t5B.start();
    }
}

class Obj5 {
    synchronized public void methodA(){
        try {
            System.out.println("begin methodA threadName = " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end endTime = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void methodB(){
        try {
            System.out.println("begin methodB threadName = " + Thread.currentThread().getName() + " begin time = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class T5A extends Thread{
    private Obj5 obj5;

    public T5A(Obj5 obj5){
        this.obj5 = obj5;
    }

    @Override
    public void run() {
        obj5.methodA();
    }
}

class T5B extends Thread{
    private Obj5 obj5;

    public T5B(Obj5 obj5){
        this.obj5 = obj5;
    }

    @Override
    public void run() {
        obj5.methodB();
    }
}