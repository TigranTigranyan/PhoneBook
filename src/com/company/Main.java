package com.company;

import com.company.controller.Controller;
import com.company.model.Number;
import com.company.model.PhoneNumberType;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Controller controller = new Controller();

    public static void main(String[] args) {
        start();
    }

    public static void start() {


        System.out.println("Add new contact.... press 1");
        System.out.println("Add in existing contact... press 2");
        System.out.println("Update existing contact...press 3");

        int step = sc.nextInt();

        if (step == 1) {
            addNew();
        }
        if (step == 2) {
           addExist();
        }
    }

    public static void addNew() {
        System.out.println("Add contact name");
        String name = sc.next();


        System.out.println("Add number");
        String number = sc.next();



        System.out.println("Insert company name");
        String company = sc.next();

        List<Number> numbers = new LinkedList<>();
        numbers.add(new Number(number,selectPhoneType()));
        controller.create(name, numbers, null, company);
    }

    public static void addExist() {
        controller.showAll();
        System.out.println("Choose contact");
        String name = sc.next();

        System.out.println("Add number");
        String number = sc.next();

        controller.addInExisting(name, number,selectPhoneType() );
    }

    private static void updateExistingNumber(){
        controller.showAll();

        System.out.println("Choose contact");
        String name = sc.next();





    }
    private static PhoneNumberType selectPhoneType() {
        System.out.println("Add number type");
        System.out.println("""
                1: HOME
                2: SCHOOL
                3: WORK
                4: MOBILE
                """);
        int numberType = sc.nextInt();
        PhoneNumberType phoneNumberType = PhoneNumberType.HOME;
        switch (numberType) {
            case 1:
                phoneNumberType = PhoneNumberType.HOME;
            case 2:
                phoneNumberType = PhoneNumberType.SCHOOL;
            case 3:
                phoneNumberType = PhoneNumberType.WORK;
            case 4:
                phoneNumberType = PhoneNumberType.MOBILE;
        }
        return phoneNumberType;
    }



}




