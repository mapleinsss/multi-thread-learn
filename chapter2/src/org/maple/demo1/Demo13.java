package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-12 14:49
 * @description 演示通过锁住会出现线程安全的代码，减少不需要同步代码执行的等待时间
 */
public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        Task13 task = new Task13();
        T13A ta = new T13A(task);
        ta.start();
        T13B tb = new T13B(task);
        tb.start();
        Thread.sleep(10000);
        long beginTime = CommonUtils13.beginTime1;
        if(CommonUtils13.beginTime2 < CommonUtils13.beginTime1){
            // 取先开始的
            beginTime = CommonUtils13.beginTime2;
        }
        long endTime = CommonUtils13.endTime1;
        if(CommonUtils13.endTime2 > CommonUtils13.endTime1){
            // 取最后结束的
            endTime = CommonUtils13.endTime2;
        }
        System.out.println("耗时：" + (endTime - beginTime) / 1000);
    }
}

class Task13{
    private String getData1;
    private String getData2;

    public  void doLongTimeTask(){
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            String privateGetData1 = "长时间处理任务从远程返回的值 1 threadName = " +Thread.currentThread().getName();
            String privateGetData2 = "长时间处理任务从远程返回的值 2 threadName = " +Thread.currentThread().getName();
            synchronized (this){
                getData1 = privateGetData1;
                getData2 = privateGetData2;
            }
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CommonUtils13{
    public static long beginTime1;
    public static long endTime1;
    public static long beginTime2;
    public static long endTime2;
}

class T13A extends Thread{
    private Task13 task;
    public T13A (Task13 task){
        this.task =task;
    }

    @Override
    public void run() {
        CommonUtils13.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils13.endTime1 = System.currentTimeMillis();
    }
}

class T13B extends Thread{
    private Task13 task;
    public T13B (Task13 task){
        this.task =task;
    }

    @Override
    public void run() {
        CommonUtils13.beginTime2 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils13.endTime2 = System.currentTimeMillis();
    }
}