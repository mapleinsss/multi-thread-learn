package org.maple.demo6shareVal;

/**
 * @author Mapleins
 * @date 2019-09-09 17:16
 * @description 展示非线程安全，synchronized 关键字
 *              非线程安全：多个线程对同一个对象中的同一个实例变量进行操作时会出现值被更改，值不同步的情况，进而影响程序的执行流程
 */
public class Demo6 {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        Thread a = new Thread(myThread3, "A");
        Thread b = new Thread(myThread3, "B");
        Thread c = new Thread(myThread3, "C");
        Thread d = new Thread(myThread3, "D");
        Thread e = new Thread(myThread3, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        System.out.println("main 线程执行完毕 ~~~");
    }
}

class MyThread3 implements Runnable {

    private int count = 5;

    /**
     * synchronized 可以在任意对象及方法上加锁，这段代码称为互斥区 或 临界区
     */
    @Override
    synchronized public void run() {
        /**
         * count -- 有三步操作：
         *          1. 取得 count 的值
         *          2. 计算 count - 1 的值
         *          3. 对 count 进行赋值
         *
         *          出现 2 个 count = 3 的情况，即：1 个线程执行了减一，但是还没有赋值，另一个线程从内存里 读的 count 是 3
         */
        count--;
        System.out.println("由" + Thread.currentThread().getName() + "计算，count = " + count);
    }
}
