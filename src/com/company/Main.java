package com.company;

import com.company.controller.Controller;
import com.company.model.PhoneNumberType;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

    }

    public static void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insert name");
        String userName = sc.next();

        System.out.println("Insert email");
        String email = sc.next();

        System.out.println("Insert company");
        String company = sc.next();
        System.out.println("Insert phone number");
        String phoneNumber = sc.next();

        System.out.println("Insert number type");
        PhoneNumberType numberType = PhoneNumberType.HOME;


        new Controller().add();
    }

}




