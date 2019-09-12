package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-12 14:09
 * @description 演示线程出现异常释放锁
 */
public class Demo9 {
    public static void main(String[] args) throws InterruptedException {
        Service9 service9 = new Service9();
        T9A ta = new T9A(service9);
        ta.setName("a");
        ta.start();
        Thread.sleep(500);
        T9B tb = new T9B(service9);
        tb.setName("b");
        tb.start();
    }
}

class Service9{
    synchronized public void testMethod(){
        if(Thread.currentThread().getName().equals("a")) {
            System.out.println("ThreadName = " + Thread.currentThread().getName() + " run beginTime = " + System.currentTimeMillis());
            int i = 1;
            while (i == 1) {
                if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
                    System.out.println("ThreadName = " + Thread.currentThread().getName() + " run exceptionTime = " + System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        } else {
            System.out.println("Thread B run time = " + System.currentTimeMillis());
        }
    }
}

class T9A extends Thread{
    private Service9 service9;

    public T9A (Service9 service9){
        this.service9 = service9;
    }

    @Override
    public void run() {
        service9.testMethod();
    }
}

class T9B extends Thread{
    private Service9 service9;

    public T9B (Service9 service9){
        this.service9 = service9;
    }

    @Override
    public void run() {
        service9.testMethod();
    }
}