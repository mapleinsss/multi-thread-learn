package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-11 17:27
 * @description synchronized 支持子父继承，子类完全可以通过可重入锁调用父类的同步方法
 */
public class Demo8 {
    public static void main(String[] args) {
        T8 t8 = new T8();
        t8.start();
    }
}

class Father {

    public int i = 10;

    synchronized public void fatherMethod() {
        try {
            i--;
            System.out.println("father print i = " + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Son extends Father {

    synchronized public void sonMethod() {
        try {
            while (i > 0) {
                i--;
                System.out.println("son print i = " + i);
                Thread.sleep(100);
                fatherMethod();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class T8 extends Thread{
    @Override
    public void run() {
        Son son = new Son();
        son.sonMethod();
    }
}