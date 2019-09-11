package org.maple.demo13stopInterrupt;

/**
 * @author Mapleins
 * @date 2019-09-10 14:58
 * @description 通过异常来退出 ，通过抛出异常后，不对异常做处理，来结束线程
 *              会改变 interrupted 的值为 false
 */
public class Demo6 {
    public static void main(String[] args) throws InterruptedException {
        Thread6 t6 = new Thread6();
        t6.start();
        Thread.sleep(100);
        t6.interrupt();
        System.out.println("main end ~~~");
    }
}

class Thread6 extends Thread {

    @Override
    public void run() {

        try {
            for (int i = 0; i < 50000; i++) {
                if (Thread.interrupted()) {
                    System.out.println("已经是停止状态了，我要退出了");
                    throw new InterruptedException();
                }
                System.out.println("i = " + i);
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread5  依然在运行");
            }
        } catch (InterruptedException e) {
            System.out.println("通过异常退出， 此处可以不做异常处理，直接退出就完事了  isInterrupted:" + this.isInterrupted());
        }
    }
}