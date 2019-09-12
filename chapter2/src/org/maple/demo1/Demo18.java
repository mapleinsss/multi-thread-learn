package org.maple.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mapleins
 * @date 2019-09-12 16:13
 * @description 演示分支判断会出现逻辑问题，造成脏读的情况
 */
public class Demo18 {
    public static void main(String[] args) throws InterruptedException {
        MyOneList myOneList = new MyOneList();
        T18A t18A = new T18A(myOneList);
        T18B t18B = new T18B(myOneList);
        t18A.setName("A");
        t18B.setName("B");
        t18A.start();
        t18B.start();
        Thread.sleep(6000);
        System.out.println("listSize : " + myOneList.getSize());
    }
}

class MyOneList {
    private List<String> list = new ArrayList<String>();

    synchronized public void add(String data) {
        list.add(data);
    }

    synchronized public int getSize() {
        return list.size();
    }
}

class Service18 {
    public MyOneList add(MyOneList list, String data) {
        try {
            /**
             * 虽然锁了 add 和 get 方法，但是此处判断的时候，两个线程同时过来，此时 list 都为空，所以都通过了判断
             * 所以最后集合的 size 为 2，不符合预期，所以在判断时也需要加同步,并且锁定的是共享变量
             */
            synchronized (list) {
                if (list.getSize() < 1) {
                    Thread.sleep(2000);
                    list.add(data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}

class T18A extends Thread {
    private MyOneList list;

    public T18A(MyOneList list) {
        this.list = list;
    }

    @Override
    public void run() {
        Service18 service = new Service18();
        service.add(list,"A");
    }
}

class T18B extends Thread {
    private MyOneList list;

    public T18B(MyOneList list) {
        this.list = list;
    }

    @Override
    public void run() {
        Service18 service = new Service18();
        service.add(list,"B");
    }
}