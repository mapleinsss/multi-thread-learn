package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-12 14:17
 * @description 示例演示同步方法不能继承，如果子类也需要同步 需要也加上 synchronized 关键字
 */
public class Demo10 {
    public static void main(String[] args) {
        Son10 son10 = new Son10();
        T10A t10A = new T10A(son10);
        t10A.setName("A");
        t10A.start();
        T10B t10B = new T10B(son10);
        t10B.setName("B");
        t10B.start();
    }
}

class Father10 {
    synchronized public void serviceMethod(){
        try {
            System.out.println("int fater10 下一步 sleep begin threadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("int fater10 下一步 sleep end threadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Son10 extends Father10{
    @Override
    public void serviceMethod() {
        try {
            System.out.println("int Son10 下一步 sleep begin threadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("int Son10 下一步 sleep end threadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
            super.serviceMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class T10A extends Thread{
    private Son10 son10;

    public T10A(Son10 son10){
        this.son10 = son10;
    }

    @Override
    public void run() {
        son10.serviceMethod();
    }
}

class T10B extends Thread{
    private Son10 son10;

    public T10B (Son10 son10){
        this.son10 = son10;
    }

    @Override
    public void run() {
        son10.serviceMethod();
    }
}

