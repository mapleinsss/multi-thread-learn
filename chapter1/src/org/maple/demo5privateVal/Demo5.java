package org.maple.demo5privateVal;

/**
 * @author Mapleins
 * @date 2019-09-09 17:10
 * @description 不共享实例变量
 *              各线程拥有自己的变量，不存在多个线程访问一个实例变量的问题
 */
public class Demo5 {

    public static void main(String[] args) {
        MyThread2 a = new MyThread2("A");
        MyThread2 b = new MyThread2("B");
        MyThread2 c = new MyThread2("C");
        a.start();
        b.start();
        c.start();
    }
}

class MyThread2 extends Thread {

    private int count = 3;

    public MyThread2(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (count > 0) {
            count--;
            System.out.println("由" + this.getName() + "计算，count = " + count);
        }
    }
}
