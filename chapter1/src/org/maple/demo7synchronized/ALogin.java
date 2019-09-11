package org.maple.demo7synchronized;

/**
 * @author Mapleins
 * @date 2019-09-10 8:59
 * @description TODO
 */
public class ALogin extends Thread {

    @Override
    public void run() {
        LoginServlet.doPost("a","aa");
    }
}
