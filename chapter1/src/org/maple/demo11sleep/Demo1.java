package org.maple.demo11sleep;

/**
 * @author Mapleins
 * @date 2019-09-10 10:45
 * @description sleep 在指定的毫秒数内让当前 正在执行的线程(this.currentThread) 休眠。暂停执行
 */
public class Demo1 {

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        System.out.println("begin :" + System.currentTimeMillis());
        thread1.start();
        System.out.println("end :" + System.currentTimeMillis());
    }
}

class Thread1 extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("run threadName = " + this.getName() + " begin");
            Thread.sleep(2000);
            System.out.println("run threadName = " + this.getName() + " end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}