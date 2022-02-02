package com.company.consumer;

public class Account {
    private String email;
    private String password;

    private Account(){}

    public Account(String em, String psw){
        email = em;
        password = psw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String em) {
        email = em;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String psw) {
        password = psw;
    }
}
