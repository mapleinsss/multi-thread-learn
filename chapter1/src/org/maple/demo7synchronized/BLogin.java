package org.maple.demo7synchronized;

/**
 * @author Mapleins
 * @date 2019-09-10 9:00
 * @description TODO
 */
public class BLogin extends Thread {

    @Override
    public void run() {
        LoginServlet.doPost("b","bb");
    }
}
