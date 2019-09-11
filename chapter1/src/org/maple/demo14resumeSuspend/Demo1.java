package org.maple.demo14resumeSuspend;

/**
 * @author Mapleins
 * @date 2019-09-10 15:54
 * @description suspend() 挂起 和 resume() 恢复 线程
 *              都是废弃方法
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        t1.start();
        Thread.sleep(5000);
        // A 段
        t1.suspend();
        System.out.println("A = " + System.currentTimeMillis() + " i = " + t1.getI());
        Thread.sleep(5000);
        System.out.println("A = " + System.currentTimeMillis() + " i = " + t1.getI());
        // B 段
        t1.resume();
        Thread.sleep(5000);
        // C 段
        t1.suspend();
        System.out.println("C = " + System.currentTimeMillis() + " i = " + t1.getI());
        Thread.sleep(5000);
        System.out.println("C = " + System.currentTimeMillis() + " i = " + t1.getI());
    }
}

class Thread1 extends Thread {
    private long i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }
}
