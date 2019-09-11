package org.maple.demo13stopInterrupt;

/**
 * @author Mapleins
 * @date 2019-09-10 15:41
 * @description TODO
 */
public class SynchronizedObject {

    private String username = "a";
    private String password = "aa";

    synchronized public void modify(String username,String password){
        try{
            this.username = username;
            Thread.sleep(100000);
            this.password = password;
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
