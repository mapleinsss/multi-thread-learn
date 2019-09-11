package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-11 10:32
 * @description 两个线程访问同一个实例变量 会出现线程安全问题
 *              方法加 synchronized 编程同步方法
 *              synchronized 获取的都是对象锁，而不是把一段代码或方法当做锁，是该方法所属对象的锁 Lock
 */
public class Demo2 {
    public static void main(String[] args) {
        HasSelfPrivateNum1 num1 = new HasSelfPrivateNum1();
        new ThreadC(num1).start();
        new ThreadD(num1).start();
    }
}

class HasSelfPrivateNum1 {
    int num = 0;

    synchronized public void addI(String username) {
        try {
            if (username.equals("c")) {
                num = 100;
                System.out.println("c set over!");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("d set over!");
            }
            System.out.println(username + " " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadC extends Thread {
    private HasSelfPrivateNum1 num;

    public ThreadC(HasSelfPrivateNum1 num) {
        this.num = num;
    }

    @Override
    public void run() {
        num.addI("c");
    }
}

class ThreadD extends Thread {
    private HasSelfPrivateNum1 num;

    public ThreadD(HasSelfPrivateNum1 num) {
        this.num = num;
    }

    @Override
    public void run() {
        num.addI("d");
    }
}