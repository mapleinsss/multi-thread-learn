package org.maple.demo2Thread;

/**
 * @author Mapleins
 * @date 2019-09-09 16:46
 * @description 使用继承 Thread
 *
 *              可以看到 Thread 类实现了 Runnable
 *              由于 Thread 实现的线程类是继承自 Thread ，Java 不支持多继承，所以如果该线程类需要多继承必须实现 Runnable 接口来开启线程
 *              这两种方式创建的线程工作时性质是一样的，没有本质区别
 */
public class Demo2 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        // myThread.start();  java.lang.IllegalThreadStateException
        System.out.println("主线程运行完毕");
    }
}

class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("MyThread running ~~~");
    }
}