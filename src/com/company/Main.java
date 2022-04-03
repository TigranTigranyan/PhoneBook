package com.company;

import com.company.controller.Controller;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GUI.start();

    public static void main(String[] args) throws IOException {
        start();
        try {
            Files.writeString(Paths.get("phonebook.txt"), Controller.getAllNames(), StandardOpenOption.APPEND);


        }catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
//
//        InputStream inputStream = null;
//        try {
//            File file = new File(new File(Controller.getAllNames() + "phonebook.txt").getName());
//            inputStream = new FileInputStream(file);
//
//            //...
//        }
//        finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }


    }
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void start() {
        Scanner sc = new Scanner(System.in);
        GUI gui = new GUI();
        boolean programIsRunning = true;

        System.out.println("Add new contact");
//        gui.addNewContact();
        while (programIsRunning) {
            System.out.println(ANSI_BLUE+"""
                    press 1: Add new contact
                    press 2: Add new number in existing contact
                    press 3: Update existing contact
                    press 4: Add email in existing contact
                    press 5: Show all contacts
                    press 6: Delete contact
                    press 0: Exit
                    """);
            int command = sc.nextInt();

            switch (command) {
                case 1:
                    gui.addNewContact();
                    break;
                case 2:
                    gui.addNumberInExisting();
                    break;
                case 3:
                    gui.updateExistingNumber();
                    break;
                case 4:
                    gui.addEmailInExisting();
                    break;
                case 5:
                    gui.showAll();
                    break;
                case 6:
                    gui.delete();
                    break;
                case 0:
                    programIsRunning = false;
                    break;
                default:
                    break;
            }
        }
    }
}
