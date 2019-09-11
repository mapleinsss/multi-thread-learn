package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-11 17:17
 * @description synchronized 可重入锁，当一个线程获取锁对象后，调用下一个方法，再次获取锁时是可以再次得到该对象锁
 *                          比如某一个线程获取到某个对象的锁，此时这个对象还没释放锁，当再次要获取这个对象的锁的时候还是可以获取的
 *                          如果不可重入的话，就会造成死锁
 */
public class Demo7 {
    public static void main(String[] args) {
        T7 t7 = new T7();
        t7.start();
    }
}

class Service{
    synchronized public void service1(){
        System.out.println("service1");
        // 此时这个对象还没释放锁，当再次要获取这个对象的锁
        service2();
    }
    synchronized public void service2(){
        System.out.println("service2");
        service3();
    }
    synchronized public void service3(){
        System.out.println("service3");
    }

}

class T7 extends Thread{
    @Override
    public void run() {
        Service service = new Service();
        service.service1();
    }
}