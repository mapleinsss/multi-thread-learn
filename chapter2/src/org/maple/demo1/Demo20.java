package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-12 16:55
 * @description 注意常量池带来的锁问题
 *              例如 ：  String a = "a"; String b = "b"  此时 a==b 为 true
 *              可以看到运行的结果，由于使用的是常量池的 "AA" ，此时锁的是AA，所以一个线程进去另一个线程再也进不去了
 */
public class Demo20 {
    public static void main(String[] args) {
        Service20 service20 = new Service20();
        T20A ta = new T20A(service20);
        ta.setName("a");
        T20B tb = new T20B(service20);
        tb.setName("b");
        ta.start();
        tb.start();
    }
}

class Service20{
    public static void print(String stringParam){
        try {
            synchronized (stringParam){
                while (true){
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class T20A extends Thread{
    private Service20 service20;
    public T20A (Service20 service20){
        this.service20 = service20;
    }

    @Override
    public void run() {
        service20.print("AA");
    }
}

class T20B extends Thread{
    private Service20 service20;
    public T20B (Service20 service20){
        this.service20 = service20;
    }

    @Override
    public void run() {
        service20.print("AA");
    }
}