package org.maple.demo14resumeSuspend;

/**
 * @author Mapleins
 * @date 2019-09-10 16:14
 * @description 演示 suspend() 使用不当，方法被独占的问题
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedObject obj = new SynchronizedObject();
        Thread t1 = new Thread(obj::printString);
        t1.setName("a");
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread(() -> {
            System.out.println("t2 启动了");
            System.out.println("因为 printString() 方法被 a 线程锁定 并且永远 suspend() 了");
            obj.printString();
        });
        t2.start();
    }
}


class SynchronizedObject {
    synchronized public void printString(){
        System.out.println("begin");
        if("a".equals(Thread.currentThread().getName())){
            System.out.println("a 线程永远 suspend 了！");
            Thread.currentThread().suspend();
        }
    }
}