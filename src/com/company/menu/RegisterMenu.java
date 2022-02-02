package com.company.menu;

import java.util.Scanner;

public class RegisterMenu {
    public static RegisterFields run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("________________________________");
        System.out.println("Welcome to Register Menu");
        System.out.println("1 -> to register as residential consumer");
        System.out.println("2 -> to register as commercial consumer");
        System.out.println("3 -> to register as industrial consumer");
        System.out.print(">: ");
        var fields = new RegisterFields();
        fields.type = sc.nextInt();
        System.out.print("  Email : ");
        fields.email = sc.next();
        System.out.print("Password: ");
        fields.password = sc.next();
        return fields;
    }
    public static class RegisterFields {
        public int type;
        public String email;
        public String password;
    }
}

