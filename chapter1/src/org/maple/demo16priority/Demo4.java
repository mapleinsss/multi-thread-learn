package org.maple.demo16priority;

/**
 * @author Mapleins
 * @date 2019-09-11 10:12
 * @description 设置优先级有随机性和不确定性，优先级和打印的先后顺序无关
 */
public class Demo4 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread3 t3 = new Thread3();
            Thread4 t4 = new Thread4();
            t3.setPriority(6);
            t4.setPriority(5);
            t3.start();
            t4.start();
        }
    }
}

