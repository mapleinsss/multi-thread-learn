package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-11 10:37
 * @description 使用了两个对象，虽然方法上有同步锁，但是两个线程调用的不是同一个对象，所以两个线程的运行结果是异步的
 */
public class Demo3 {
    public static void main(String[] args) {
        HasSelfPrivateNum2 num1 = new HasSelfPrivateNum2();
        HasSelfPrivateNum2 num2 = new HasSelfPrivateNum2();
        new ThreadE(num1).start();
        new ThreadF(num2).start();
    }
}

class HasSelfPrivateNum2 {
    private int num = 0;

    synchronized public void addI(String username) {
        try {
            if (username.equals("e")) {
                num = 100;
                System.out.println("e set over!");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("f set over!");
            }
            System.out.println(username + " " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadE extends Thread {
    private HasSelfPrivateNum2 num;

    public ThreadE(HasSelfPrivateNum2 num) {
        this.num = num;
    }

    @Override
    public void run() {
        num.addI("e");
    }
}

class ThreadF extends Thread {
    private HasSelfPrivateNum2 num;

    public ThreadF(HasSelfPrivateNum2 num) {
        this.num = num;
    }

    @Override
    public void run() {
        num.addI("f");
    }
}