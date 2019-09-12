package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-12 15:21
 * @description 演示 一个线程拿到锁，另一线程调用另一个当前对象的加锁方法时，依然要排队
 */
public class Demo15 {
    public static void main(String[] args) {
        Service15 service15 = new Service15();
        T15a ta = new T15a(service15);
        ta.setName("a");
        ta.start();
        T15b tb = new T15b(service15);
        tb.setName("b");
        tb.start();
    }
}

class Service15 {
    public void serviceMethodA() {
        try {
            synchronized (this) {
                System.out.println("A begin time = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end time = " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodB(){
        synchronized (this){
            System.out.println("B begin time = " + System.currentTimeMillis());
            System.out.println("B end time = " + System.currentTimeMillis());
        }
    }
}

class T15a extends Thread{
    private Service15 service15;
    public T15a(Service15 service15){
        this.service15 = service15;
    }

    @Override
    public void run() {
        service15.serviceMethodA();
    }
}

class T15b extends Thread{
    private Service15 service15;
    public T15b(Service15 service15){
        this.service15 = service15;
    }

    @Override
    public void run() {
        service15.serviceMethodB();
    }
}