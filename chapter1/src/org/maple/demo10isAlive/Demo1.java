package org.maple.demo10isAlive;

/**
 * @author Mapleins
 * @date 2019-09-10 10:38
 * @description isAlive
 *                  测试线程是否处于活动状态
 *                          活动状态：线程已启动并尚未终止
 *                              线程处于正在运行，或者准备开始运行 （ 等待调度 ）就是存活的
 */
public class Demo1 {

    public static void main(String[] args) {
        MyThead myThead = new MyThead();
        // false
        System.out.println("begin : " + myThead.isAlive());
        myThead.start();
        // 此值应该是不确定的
        System.out.println("end : " + myThead.isAlive());
    }

}

class MyThead extends Thread {
    @Override
    public void run() {
        // true
        System.out.println("run: " + this.isAlive());
    }
}
