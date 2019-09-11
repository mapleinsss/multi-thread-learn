package org.maple.demo7synchronized;

/**
 * @author Mapleins
 * @date 2019-09-10 9:00
 * @description TODO
 */
public class Client {

    public static void main(String[] args) {
        ALogin aLogin = new ALogin();
        aLogin.setName("A");
        aLogin.start();
        BLogin bLogin = new BLogin();
        bLogin.setName("B");
        bLogin.start();
    }
}
