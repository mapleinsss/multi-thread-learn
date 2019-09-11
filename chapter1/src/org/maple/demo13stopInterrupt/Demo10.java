package org.maple.demo13stopInterrupt;

/**
 * @author Mapleins
 * @date 2019-09-10 15:40
 * @description 由于线程执行了500毫秒，被终止，线程任务并未完成，所有最后的结果为 b  :  aa
 *              所有使用 stop 有时候会导致一些问题的出现，故不推荐使用
 */
public class Demo10 {

    public static void main(String[] args) throws InterruptedException {
        SynchronizedObject obj = new SynchronizedObject();
        Thread10 t10 = new Thread10(obj);
        t10.start();
        Thread.sleep(500);
        t10.stop();
        System.out.println(obj.getUsername() + "  :  " + obj.getPassword());
    }
}

class Thread10 extends Thread {

    private SynchronizedObject object;

    public Thread10(SynchronizedObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.modify("b", "bb");
    }
}