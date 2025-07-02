package com.banking.app.payload;

public class UserPayload {

    private String userName;
    private String password;

    public UserPayload(String userName, String password,String role) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
