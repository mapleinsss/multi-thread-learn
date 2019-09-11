package org.maple.demo13stopInterrupt;

/**
 * @author Mapleins
 * @date 2019-09-10 11:24
 * @description interrupt 并未停止线程
 */
public class Demo1 {
    public static void main(String[] args) {
        try{
            Thread1 thread1 = new Thread1();
            thread1.start();
            Thread.sleep(2000);
            thread1.interrupt();
        } catch (InterruptedException e){
            e.printStackTrace();

        }
    }
}

class Thread1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("i : " + i);
        }
    }
}
