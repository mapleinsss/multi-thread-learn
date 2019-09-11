package org.maple.demo1getName;

/**
 * @author Mapleins
 * @date 2019-09-09 16:43
 * @description 查看 main 线程的 thread name
 */
public class Demo1 {

    public static void main(String[] args) {
        // main
        System.out.println(Thread.currentThread().getName());

    }
}
