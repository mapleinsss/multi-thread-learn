package org.maple.demo13stopInterrupt;

/**
 * @author Mapleins
 * @date 2019-09-10 15:31
 * @description 暴力停止，不建议使用 stop() 废弃方法
 */
public class Demo8 {
    public static void main(String[] args) throws InterruptedException {
        Thread8 t8 = new Thread8();
        t8.start();
        Thread.sleep(8000);
        t8.stop();
    }
}

class Thread8 extends Thread{

    private int i = 0;

    @Override
    public void run() {
        try{
            while (true) {
                i ++;
                System.out.println("i = " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
