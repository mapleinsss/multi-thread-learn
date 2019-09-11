package org.maple.demo13stopInterrupt;

/**
 * @author Mapleins
 * @date 2019-09-10 15:35
 * @description stop() 会抛出 java.lang.ThreadDeath，不需要显式捕获
 */
public class Demo9 {
    public static void main(String[] args) {
        Thread9 t9 = new Thread9();
        t9.start();
    }
}

class Thread9 extends Thread{
    @Override
    public void run() {
        try{
            this.stop();
        } catch (ThreadDeath e){
            System.out.println("进入 catch");
            e.printStackTrace();
        }
    }
}
