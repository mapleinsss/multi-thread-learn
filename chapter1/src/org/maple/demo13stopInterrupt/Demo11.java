package org.maple.demo13stopInterrupt;

/**
 * @author Mapleins
 * @date 2019-09-10 15:49
 * @description 通过 interrupt() + return 停止线程
 *              但是还是推荐使用 抛异常的地方法实现线程的停止，因为 catch 到异常还可以继续向上抛，使线程停止的时间得以传播
 */
public class Demo11 {

    public static void main(String[] args) throws InterruptedException {
        Thread11 t11 = new Thread11();
        t11.start();
        Thread.sleep(2000);
        t11.interrupt();
    }
}

class Thread11 extends Thread{

    @Override
    public void run() {
        while (true){
            if(this.isInterrupted()){
                System.out.println("停止了");
                return;
            }
            System.out.println("timer = " + System.currentTimeMillis());
        }
    }
}