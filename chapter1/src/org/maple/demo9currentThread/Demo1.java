package org.maple.demo9currentThread;

/**
 * @author Mapleins
 * @date 2019-09-10 9:16
 * @description 创建和调用处于哪个线程
 */
public class Demo1 {

    public static void main(String[] args) {
        // main
        MyThread myThread = new MyThread();
        // Thread-0
        myThread.start();
        // main
        myThread.run();
    }

}

class MyThread extends Thread{

    public MyThread(){
        System.out.println("构造方法：" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run 方法：" + Thread.currentThread().getName());
    }
}
