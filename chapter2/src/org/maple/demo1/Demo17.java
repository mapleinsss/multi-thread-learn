package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-12 15:46
 * @description 可以通过不同的锁对象，提高效率,应该是一组共享资源使用一个锁，而不是所有方法都使用一把锁。
 */
public class Demo17 {
    public static void main(String[] args) {
        Service17 service17 = new Service17();
        T17A ta = new T17A(service17);
        ta.setName("a");
        ta.start();
        T17B tb = new T17B(service17);
        tb.setName("b");
        tb.start();
    }
}

class Service17 {
    private String usernameParam;
    private String passwordParam;
    private String anyString = new String();

    public void setUsernamePassword(String username, String password) {
        try {
            synchronized (anyString) {
                System.out.println("Thread:" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 进入同步代码块");
                usernameParam = username;
                Thread.sleep(3000);
                passwordParam = password;
                System.out.println("username " + username + " password " + password);
                System.out.println("Thread:" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 离开同步代码块");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void methodB() {
        System.out.println("b begin");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b end");
    }
}

class T17A extends Thread{
    private Service17 service17;
    public T17A (Service17 service17){
        this.service17 = service17;
    }

    @Override
    public void run() {
        service17.setUsernamePassword("a","aa");
    }
}

class T17B extends Thread{
    private Service17 service17;
    public T17B (Service17 service17){
        this.service17 = service17;
    }

    @Override
    public void run() {
        service17.methodB();
    }
}