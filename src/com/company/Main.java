package com.company;

import com.company.controller.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) throws IOException {
        GUI.start();
        Controller controller = new Controller();
        try {
            Files.writeString(Paths.get("phonebook.txt"), controller.getAllNames(), StandardOpenOption.APPEND);


        } catch (IOException e) {
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
}
