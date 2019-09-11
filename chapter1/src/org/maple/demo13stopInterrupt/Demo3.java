package org.maple.demo13stopInterrupt;

/**
 * @author Mapleins
 * @date 2019-09-10 11:41
 * @description interrupted 具有清除状态的功能
 */
public class Demo3 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        // true 第一次调用 interrupted 已经清除了中断状态
        System.out.println("是否停止了1？ = " +Thread.interrupted());
        // false 第二次调用 此线程的中断状态已经消除 所以返回 false
        System.out.println("是否停止了2？ = " +Thread.interrupted());
        System.out.println("end ~~~");
    }
}
