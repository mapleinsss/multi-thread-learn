package org.maple.demo13stopInterrupt;

/**
 * @author Mapleins
 * @date 2019-09-10 15:06
 * @description 如果一个线程正在睡眠被打断，则会抛出异常 java.lang.InterruptedException: sleep interrupted
 *              并且清除停止的状态值 ( isInterrupted() )，变为 false
 */
public class Demo7 {

    public static void main(String[] args) throws InterruptedException {
        Thread7 t7 = new Thread7();
        t7.start();
        Thread.sleep(200);
        t7.interrupt();
        System.out.println("main end ~~~");
    }
}

class Thread7 extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("run begin");
            Thread.sleep(2000000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("我在沉睡中停止，进入 catch !" + this.isInterrupted());
            e.printStackTrace();
        }
    }
}