package com.company.controller;

import com.company.Contact;
import com.company.model.Number;
import com.company.model.*;
import com.company.services.EmailService;
import com.company.services.PhoneService;
import com.company.services.UserService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.List;

public class Controller {
    static PhoneService phoneService = new PhoneService();
    static UserService userService = new UserService();
    static EmailService emailService = new EmailService();
    public static final String ANSI_PURPLE = "\u001B[35m";
    static JSONObject employeeDetails = new JSONObject();
    static JSONObject employeeObject = new JSONObject();
    static JSONArray employeeList = new JSONArray();


    public static void create(String userName, List<Number> numbers, List<Email> emails, String company) {
        phoneService.addNew(userName, new User(numbers, emails, company));
    }

    public void delete(String name) {
        phoneService.delete(name);
    }

    public void addNumberInExisting(String userName, String number, PhoneNumberType phoneNumberType) {
        userService.addNumber(Contact.contacts.get(userName), new Number(number, phoneNumberType));
    }

    public void addEmailInExisting(String userName, String email, EmailType emailType) {
        emailService.addEmail(Contact.contacts.get(userName), new Email(email, emailType));
    }

    public void update(String userName, String number, PhoneNumberType phoneNumberType, int index) {
        phoneService.update(userName, number, phoneNumberType, index);
    }

    public String showUserAllNumber(String name) {
        return userService.contactNumbers(Contact.contacts.get(name));
    }

    public static String getAllNames() {
        return phoneService.printContactNames();
    }

    public static CharSequence showAll() {

        /**
         * Read from jile "phonebook.txt"
         */
//        File file = new File("phonebook.txt");
//        Scanner sc = null;
//        try {
//            sc = new Scanner(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        while (sc.hasNextLine())
//            System.out.println(sc.nextLine());


        //______________________________________________________________


        System.out.println("---------------");
        for (String name : Contact.contacts.keySet()) {
            User user = Contact.contacts.get(name);
            System.out.println(ANSI_PURPLE+name + "\n" + userService.contactNumbers(user) +
                    emailService.contactEmails(user) +
                    " " + user.getCompany());
            System.out.println("---------------");

            JSONParser jsonParser = new JSONParser();

            try (FileReader reader = new FileReader("employees.json"))
            {
                //Read JSON file
                Object obj = jsonParser.parse(reader);

                JSONArray existingData = (JSONArray) obj;

                for (int i = 0; i < existingData.size(); i++) {

                    JSONObject explrObject = (JSONObject) existingData.get(i);
                    System.out.println(explrObject);
                    employeeList.add(explrObject);

                }

                //Iterate over employee array
                //for getting data from json
                //existingData.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //employeeDetails.put("Name", name);
            employeeDetails.put("Number", userService.contactNumbers(user));
            employeeDetails.put("Email", emailService.contactEmails(user));
            employeeObject.put(name, employeeDetails);
            employeeList.add(employeeObject);

            //Write JSON file
            try (FileWriter file = new FileWriter("employees.json")) {
                file.write(employeeList.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return "";
    }

    private static void parseEmployeeObject(JSONObject employee)
    {
        //Get employee object within list
        JSONObject employeeObject2 = (JSONObject) employee.get("tikko");
        //employeeList.add(employeeObject2);

        System.out.println(employee);


        //Get employee last name
        String lastName = (String) employeeObject2.get("Email");
        System.out.println("here");
        System.out.println(lastName);

        String number = (String) employeeObject2.get("Number");
        System.out.println("herererer");
        System.out.println(number);

    }
}

