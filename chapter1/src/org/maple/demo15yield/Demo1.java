package org.maple.demo15yield;

/**
 * @author Mapleins
 * @date 2019-09-11 9:20
 * @description yield() 方法的作用是放弃当前的 cpu 资源，让给其他的任务去占用 cpu 执行时间
 *              有可能刚放弃，马上又获得 cpu 时间片
 */
public class Demo1 {
    public static void main(String[] args) {
        new Thread1().start();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 1; i <= 50000000; i++) {
            count += i;
            /**
             * 注释  用时：16毫秒
             * 未注释 用时：19944毫秒
             */
//            Thread.yield();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - beginTime) + "毫秒");
    }
}