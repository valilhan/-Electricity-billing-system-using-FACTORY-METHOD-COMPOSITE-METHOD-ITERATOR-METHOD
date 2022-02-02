package com.company;

import com.company.bill.Month;
import com.company.bill.MonthlyBill;
import com.company.bill.YearlyBill;
import com.company.consumer.*;
import com.company.factory.CommercialConsumerFactory;
import com.company.factory.Consumers;
import com.company.factory.IndustrialConsumerFactory;
import com.company.factory.ResidentialConsumerFactory;
import com.company.menu.LoginMenu;
import com.company.menu.RegisterMenu;

import java.util.Random;
import java.util.Scanner;

public class Application {
    ResidentialConsumerFactory residential = new ResidentialConsumerFactory();
    CommercialConsumerFactory commercial = new CommercialConsumerFactory();
    IndustrialConsumerFactory industrial = new IndustrialConsumerFactory();
    Consumer consumer = null;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    int day = 1;
    Month month = Month.JANUARY;
    int year = 2021;

    public void run(){
        while( true ){
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
            System.out.println("Today is " + day + " " + month.toString() + " " + year);
            if( consumer == null ){ /// When the user is signed out.
                System.out.println("________________________________");
                System.out.println("0 -> to exit");
                System.out.println("1 -> to login");
                System.out.println("2 -> to register");
                System.out.println("3 -> for passing days");
                System.out.println("4 -> to list all users");
                System.out.print(">: ");
                int type = scanner.nextInt();
                if( type == 0 ) {
                    break;
                }
                else if( type == 1 ){
                    askForLogin();
                }
                else if( type == 2 ){
                    askForRegistration();
                }
                else if( type == 3 ){
                    askForPassingDays();
                }
                else if( type == 4){
                    printAllConsumers();
                }
            }else{ /// When the user is signed in.
                System.out.println("________________________________");
                if( consumer instanceof ResidentialConsumer )
                    System.out.println("You are residential consumer");
                if( consumer instanceof  CommercialConsumer )
                    System.out.println("You are commercial consumer");
                if( consumer instanceof IndustrialConsumer )
                    System.out.println("You are industrial consumer");
                System.out.println("           Email          : " + consumer.getAccount().getEmail());
                System.out.println("         Password         : " + consumer.getAccount().getPassword());
                System.out.println("Consumption(Current Month): " + consumer.getConsumption() + "KWh");
                System.out.println("You have " + consumer.unpaidBills.getSize() + " unpaid bills");
                System.out.println("You have " + consumer.paidBills.getSize() + " paid bills");
                System.out.println("________________________________");
                System.out.println("0 -> to sign out");
                System.out.println("1 -> to list all unpaid bills");
                System.out.println("2 -> to pay a bill");
                System.out.print(">: ");
                int type = scanner.nextInt();
                if( type == 0 ){
                    consumer = null;
                }
                else if( type == 1 ){
                    printAllUnpaidBills();
                }
                else if( type == 2 ){
                    payBill();
                }
            }
        }
    }
    public void printAllUnpaidBills(){
        var it = consumer.unpaidBills.createIterator();
        while( it.isValid() ){
            System.out.println("________________________________");
            if( it.current() instanceof MonthlyBill){
                System.out.println("------- Monthly Bill -------");
                System.out.println("   Month   : " + ((MonthlyBill) it.current()).getMonth().toString());
                System.out.println("    Year   : " + ((MonthlyBill) it.current()).getYear());
            }
            else if ( it.current() instanceof YearlyBill ){
                System.out.println("------- Yearly Bill -------");
                System.out.println("    Year   : " + ((YearlyBill) it.current()).getYear());
            }
            System.out.println("Consumption: " + it.current().getConsumption() + "KWh");
            System.out.println("   total   : " + it.current().getTotal() + "$");
            it.next();
        }
    }
    public void payBill(){
        var it = consumer.unpaidBills.createIterator();
        if( it.isValid() ) {
            consumer.paidBills.push(consumer.unpaidBills.pop(it));
        }
    }
    public void askForRegistration()
    {
        var fields = RegisterMenu.run();
        if( fields.type == 1 ){
            Consumer new_consumer = residential.createConsumer();
            new_consumer.setAccount(new Account(fields.email, fields.password));
            residential.addConsumer(new_consumer);
        }
        else if( fields.type == 2 ){
            Consumer new_consumer = commercial.createConsumer();
            new_consumer.setAccount(new Account(fields.email, fields.password));
            commercial.addConsumer(new_consumer);
        }
        else if( fields.type == 3 ){
            Consumer new_consumer = industrial.createConsumer();
            new_consumer.setAccount(new Account(fields.email, fields.password));
            industrial.addConsumer(new_consumer);
        }
    }
    public void askForLogin()
    {
        var fields = LoginMenu.run();
        for( int i = 0; i < 3; i ++ ) {
            Consumers.ConsumerListIterator it;
            if( i == 0 ) it = residential.getIterator();
            else if( i == 1 ) it = commercial.getIterator();
            else it = industrial.getIterator();
            while (it.isValid()) {
                if (it.current().getAccount().getEmail().equals(fields.email) &&
                        it.current().getAccount().getPassword().equals(fields.password)) {
                    consumer = it.current();
                    break;
                }
                it.next();
            }
        }
        if( consumer == null ){
            System.out.println("*** You have entered wrong Email or Password ***");
        }
    }
    public void askForPassingDays()
    {
        System.out.println("________________________________");
        System.out.println("Enter the number of days to pass");
        System.out.print(">: ");
        int days = scanner.nextInt();
        while( days > 0 ){
            days --;
            day ++;
            for( int i = 0; i < 3; i ++ ) {
                Consumers.ConsumerListIterator it;
                if( i == 0 ) it = residential.getIterator();
                else if( i == 1 ) it = commercial.getIterator();
                else it = industrial.getIterator();
                while( it.isValid() ) {
                    it.current().addConsumption(random.nextInt((i + 1) * 100));
                    if( day == 31 ){
                        if( i != 2) {
                            it.current().unpaidBills.push(new MonthlyBill(month, year, it.current().getConsumption(),
                                    it.current().getConsumption() * it.current().getPricePerKWh()));
                            it.current().nullifyConsumption();
                        }
                        else{
                            var itt = it.current().unpaidBills.createIterator();
                            while(itt.isValid() && !itt.isLast()){
                                itt.next();
                            }
                            if( itt.isValid() && ((YearlyBill) itt.current()).getYear() == year){
                                ((YearlyBill) itt.current()).addNewBill(new MonthlyBill(month, year,
                                        it.current().getConsumption(),
                                        it.current().getConsumption() * it.current().getPricePerKWh()));
                            }
                            else{
                                var bill = new YearlyBill(year);
                                bill.addNewBill(new MonthlyBill(month, year, it.current().getConsumption(),
                                        it.current().getConsumption() * it.current().getPricePerKWh()));
                                it.current().unpaidBills.push(bill);
                            }
                            it.current().nullifyConsumption();
                        }
                    }
                    it.next();
                }
            }
            if( day == 31 ){
                day = 1;
                if( month.equals(Month.DECEMBER) )
                    year++;
                month = month.next();
            }
        }
    }
    public void printAllConsumers(){
        System.out.println("________________________________");
        for( int i = 0; i < 3; i ++ ) {
            Consumers.ConsumerListIterator it;
            if( i == 0 ) it = residential.getIterator();
            else if( i == 1 ) it = commercial.getIterator();
            else it = industrial.getIterator();
            while( it.isValid() ){
                System.out.print(it.current().getAccount().getEmail());
                System.out.print(" " + it.current().getAccount().getPassword());
                System.out.println(" " + it.current().getConsumption());
                it.next();
            }
        }
    }
}
