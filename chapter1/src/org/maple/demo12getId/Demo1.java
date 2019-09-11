package org.maple.demo12getId;

/**
 * @author Mapleins
 * @date 2019-09-10 10:56
 * @description getId : 获取线程的唯一标识
 */
public class Demo1 {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " " + thread.getId());
    }
}

