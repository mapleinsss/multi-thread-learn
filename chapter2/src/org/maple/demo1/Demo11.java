package org.maple.demo1;

/**
 * @author Mapleins
 * @date 2019-09-12 14:27
 * @description 演示 synchronized 同步方法的耗时，引出下面使用 synchronized 代码块
 */
public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        T11A ta = new T11A(task);
        ta.start();
        T11B tb = new T11B(task);
        tb.start();
        Thread.sleep(10000);
        long beginTime = CommonUtils.beginTime1;
        if(CommonUtils.beginTime2 < CommonUtils.beginTime1){
            // 取先开始的
            beginTime = CommonUtils.beginTime2;
        }
        long endTime = CommonUtils.endTime1;
        if(CommonUtils.endTime2 > CommonUtils.endTime1){
            // 取最后结束的
            endTime = CommonUtils.endTime2;
        }
        System.out.println("耗时：" + (endTime - beginTime) / 1000);
    }
}

class Task{
    private String getData1;
    private String getData2;

    public synchronized  void doLongTimeTask(){
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            getData1 = "长时间处理任务从远程返回的值 1 threadName = " +Thread.currentThread().getName();
            getData2 = "长时间处理任务从远程返回的值 2 threadName = " +Thread.currentThread().getName();
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CommonUtils{
    public static long beginTime1;
    public static long endTime1;
    public static long beginTime2;
    public static long endTime2;
}

class T11A extends Thread{
    private Task task;
    public T11A (Task task){
        this.task =task;
    }

    @Override
    public void run() {
        CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}

class T11B extends Thread{
    private Task task;
    public T11B (Task task){
        this.task =task;
    }

    @Override
    public void run() {
        CommonUtils.beginTime2 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}