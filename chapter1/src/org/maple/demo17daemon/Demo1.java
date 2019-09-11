package org.maple.demo17daemon;

/**
 * @author Mapleins
 * @date 2019-09-11 10:19
 * @description 测试守护线程
 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.setDaemon(true);
        t1.start();
        Thread.sleep(5000);
        System.out.println("main 停止， t1 线程也停止了");
    }

}

class T1 extends Thread {
    private int i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}