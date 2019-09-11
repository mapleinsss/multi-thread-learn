package org.maple.demo7synchronized;

/**
 * @author Mapleins
 * @date 2019-09-10 8:57
 * @description 模仿登录的 servlet
 */
public class LoginServlet {

    private static String usernameRef;
    private static String passwordRef;

    synchronized public static void doPost(String username, String password) {
        try {
            usernameRef = username;
            if ("a".equals(username)) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println(Thread.currentThread().getName() + "  usernameRef: " + usernameRef + "  passwordRef: " + passwordRef);
        } catch (Exception e) {

        }
    }
}
