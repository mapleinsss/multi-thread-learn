package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-11 10:26
 * @description 方法中的变量不存在非线程安全问题，永远都是线程安全的。
 *              这是方法内部的变量是私有的特性造成的。
 */
public class Demo1 {
    public static void main(String[] args) {
        HasSelfPrivateNum num = new HasSelfPrivateNum();
        new ThreadA(num).start();
        new ThreadB(num).start();
    }
}

class HasSelfPrivateNum {
    public void addI(String username) {
        try {
            int num = 0;
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + " " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread {
    private HasSelfPrivateNum num;

    public ThreadA(HasSelfPrivateNum num) {
        this.num = num;
    }

    @Override
    public void run() {
        num.addI("a");
    }
}

class ThreadB extends Thread {
    private HasSelfPrivateNum num;

    public ThreadB(HasSelfPrivateNum num) {
        this.num = num;
    }

    @Override
    public void run() {
        num.addI("b");
    }
}