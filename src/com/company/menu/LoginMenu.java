package com.company.menu;

import java.util.Scanner;

public class LoginMenu {
    public static LoginFields run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("________________________________");
        System.out.println("Welcome to Login Menu");
        var fields = new LoginFields();
        System.out.print("  Email : ");
        fields.email = sc.next();
        System.out.print("Password: ");
        fields.password = sc.next();
        return fields;
    }
    public static class LoginFields {
        public String email;
        public String password;
    }
}
