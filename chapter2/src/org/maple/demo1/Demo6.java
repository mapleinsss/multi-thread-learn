package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-11 14:11
 * @description 脏读的产生
 */
public class Demo6 {
    public static void main(String[] args) throws InterruptedException {
        PublicVar publicVar = new PublicVar();
        T6A t6A = new T6A(publicVar);
        t6A.start();
        // 出现脏读的情况受此值影响
        Thread.sleep(200);
//        Thread.sleep(6000);
        publicVar.getValue();
    }
}

class PublicVar {
    public String username = "A";
    public String password = "AA";

    synchronized public void setValue(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("setValue method thread name = " + Thread.currentThread().getName() + " username = " + username + " password = " + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public void getValue() {
        System.out.println("getValue method thread name = " + Thread.currentThread().getName() + " username = " + username + " password = " + password);
    }
}

class T6A extends Thread{
    public PublicVar publicVar;
    public T6A(PublicVar publicVar){
        this.publicVar =publicVar;
    }

    @Override
    public void run() {
        publicVar.setValue("B","BB");
    }
}