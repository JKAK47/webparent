package org.vincent.web.front.controller.test.model;

/**
 * Created by PengRong on 2018/8/17.
 */
public class User {
    private  String loginname;
    private String password;
    private  String username;
    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
