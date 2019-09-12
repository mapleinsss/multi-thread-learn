package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-12 17:16
 * @description 演示死锁
 */
public class Demo21 {
    public static void main(String[] args) throws InterruptedException {
        DeadThread t1 = new DeadThread();
        t1.setFlag("a");
        new Thread(t1).start();
        Thread.sleep(100);
        t1.setFlag("b");
        new Thread(t1).start();
    }
}


class DeadThread implements Runnable{

    public String username;
    private Object lock1= new Object();
    private Object lock2= new Object();
    public void setFlag(String username){
        this.username = username;
    }

    @Override
    public void run() {
        if(username.equals("a")){
            synchronized (lock1) {
                try {
                    System.out.println("username = " + username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("lock1 进入了 lock2");
                }
            }
        }
        if(username.equals("b")) {
            synchronized (lock2) {
                try {
                    System.out.println("username = " + username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("lock2 进入了 lock1");
                }
            }
        }
    }
}