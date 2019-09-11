package org.maple.demo14resumeSuspend;

/**
 * @author Mapleins
 * @date 2019-09-10 16:14
 * @description TODO
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedObject obj = new SynchronizedObject();
        Thread t1 = new Thread(obj::printString);
        t1.setName("a");
        t1.start();
        Thread.sleep(1000);
        
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