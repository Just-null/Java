package com.uml.bean;

public class Password {
    private String password;
    private String username;
    public Password(String username, String password){
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String toString(){
        return "账号:"+username+"\t"+"密码:"+password;
    }
}
