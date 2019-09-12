package org.maple.demo1;

import java.lang.ref.SoftReference;

/**
 * @author Mapleins
 * @date 2019-09-12 16:32
 * @description 注意 synchronized 加锁在 普通方法 和 静态方法上，静态方法锁的是 class 对象，普通方法锁的是实例对象
 *              synchronized(类.class)  =  synchronized static
 */
public class Demo19 {
    public static void main(String[] args) {
        Service19 service = new Service19();
        T19A ta = new T19A(service);
        T19B tb = new T19B(service);
        T19C tc = new T19C(service);
        ta.setName("a");
        tb.setName("b");
        tc.setName("c");
        ta.start();
        tb.start();
        tc.start();
    }
}

class Service19{
    synchronized public static void printA() {
        System.out.println(Thread.currentThread().getName()+" get in A ,now : " +System.currentTimeMillis() );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" leave A ,now : " +System.currentTimeMillis() );
    }

    synchronized public void printB() {
        System.out.println(Thread.currentThread().getName()+" get in B ,now : " +System.currentTimeMillis() );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" leave B ,now : " +System.currentTimeMillis() );
    }

    public void printC(){
        synchronized (Service19.class){
            System.out.println(Thread.currentThread().getName()+" get in C ,now : " +System.currentTimeMillis() );
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" leave C ,now : " +System.currentTimeMillis() );
        }
    }
}

class T19A extends Thread{
    private Service19 service19;
    public T19A(Service19 service19){
        this.service19 = service19;
    }

    @Override
    public void run() {
        service19.printA();
    }
}

class T19B extends Thread{
    private Service19 service19;
    public T19B(Service19 service19){
        this.service19 = service19;
    }

    @Override
    public void run() {
        service19.printB();
    }
}

class T19C extends Thread{
    private Service19 service19;
    public T19C(Service19 service19){
        this.service19 = service19;
    }

    @Override
    public void run() {
        service19.printC();
    }
}