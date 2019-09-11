package org.maple.demo4runnable;

/**
 * @author Mapleins
 * @date 2019-09-09 17:03
 * @description 实现 Runnable
 *              一共有 8 个构造函数
 *              public Thread(Runnable target)
 *              public Thread(Runnable target, String name)
 */
public class Demo4 {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable,"myRunnable");
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
