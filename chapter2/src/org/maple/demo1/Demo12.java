package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-12 14:44
 * @description 这样锁无效率提高
 */
public class Demo12 {
    public static void main(String[] args) {
        Service12 service = new Service12();
        T12a t12a = new T12a(service);
        t12a.setName("a");
        t12a.start();
        T12b t12b = new T12b(service);
        t12b.setName("b");
        t12b.start();
    }
}

class Service12 {
    public void serviceMethod() {
        try {
            synchronized (this) {
                System.out.println("begin time = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end  time = " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class T12a extends Thread{
    private Service12 service12;
    public T12a(Service12 service12){
        this.service12 =service12;
    }
    @Override
    public void run() {
        service12.serviceMethod();
    }
}

class T12b extends Thread{
    private Service12 service12;
    public T12b(Service12 service12){
        this.service12 =service12;
    }
    @Override
    public void run() {
        service12.serviceMethod();
    }
}