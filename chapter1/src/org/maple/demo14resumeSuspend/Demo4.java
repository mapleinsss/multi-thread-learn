package org.maple.demo14resumeSuspend;

/**
 * @author Mapleins
 * @date 2019-09-11 9:10
 * @description 演示值不同步的问题
 */
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        final MyObject object = new MyObject();
        Thread t1 = new Thread(() -> object.setValue("a", "aa"));
        t1.setName("a");
        t1.start();
        Thread.sleep(500);
        Thread t2 = new Thread(object::printUsernamePassword);
        t2.start();
    }
}

class MyObject{

    private String username = "1";
    private String password = "11";
    public void setValue(String u,String p){
        this.username = u;
        if ("a".equals(Thread.currentThread().getName())) {
            System.out.println("停止 a 线程");
            Thread.currentThread().suspend();
        }
        this.password = p;
    }
    public void printUsernamePassword(){
        System.out.println(username + " " + password);
    }


}