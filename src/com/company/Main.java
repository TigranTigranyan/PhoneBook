package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Scanner sc = new Scanner(System.in);
        GUI gui = new GUI();
        boolean stop = false;
        while (!stop) {
            System.out.println("Add new contact.... press 1");
            System.out.println("Add in existing contact... press 2");
            System.out.println("Update existing contact...press 3");
            System.out.println("Add email in existing contact4");
            System.out.println("Show all contacts...press5");
            System.out.println("Delete contact...press6");
            System.out.println("For exit...press 0");

            int step = sc.nextInt();

            switch (step) {
                case 1:
                    gui.addNew();
                    break;
                case 2:
                    gui.addNumberInExist();
                    break;
                case 3:
                    gui.updateExistingNumber();
                    break;
                case 5:
                    gui.showAll();
                    break;
                case 4:
                    gui.addEmailInExist();
                    break;
                case 6:
                    gui.delete();
                    break;
                case 0:
                    stop = true;
                    break;
                default:
                    break;
            }
        }
    }
}





