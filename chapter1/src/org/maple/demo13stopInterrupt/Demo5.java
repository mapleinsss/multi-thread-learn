package org.maple.demo13stopInterrupt;

/**
 * @author Mapleins
 * @date 2019-09-10 14:21
 * @description 通过 interrupt() 打断线程，通过 interrupted() 判断 ,来停止循环
 *              但是 interrupt 并不能停止线程，通过 break 跳出后，依然会执行后面的 for 循环
 */
public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        Thread5 t5 = new Thread5();
        t5.start();
        Thread.sleep(100);
        t5.interrupt();
        System.out.println("main end ~~~");
    }
}

class Thread5 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            if(Thread.interrupted()){
                System.out.println("已经是停止状态了，我要退出了");
                break;
            }
            System.out.println("i = " + i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread5  依然在运行");
        }
    }
}
