package org.maple.demo8println;

/**
 * @author Mapleins
 * @date 2019-09-10 9:09
 * @description TODO
 */
public class MyThread4 extends Thread {

    private int i = 5;

    /**
     *     public void println(String x) {
     *         synchronized (this) {
     *             print(x);
     *             newLine();
     *         }
     *     }
     *     可以看到 println 是同步方法，但是他是针对字符串生成完毕后，进行同步， i-- 在进入 互斥区 就已经完成了，所以依然存在线程安全问题
     */
    @Override
    public void run() {
        System.out.println("i = " + (i--) + " threadName :" + Thread.currentThread().getName());
    }
}
