package org.maple.demo3randomCpu;

/**
 * @author Mapleins
 * @date 2019-09-09 16:53
 * @description 线程调度的随机性，cpu 不挺切换，多运行几次，可以看出不同结果
 *              线程调用 start ，只是线程进入就绪状态，等待 cpu 调度，当 cpu 调度到后，再执行 run 方法
 *              如果在 main 线程中，直接调用线程的 run() 方法，则是同步调用
 */
public class Demo3 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.setName("myThread1");
        myThread1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main -> " + Thread.currentThread().getName());
        }
    }

}


class MyThread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("myThread1 -> " + Thread.currentThread().getName());
        }
    }
}
