package com.company.controller;

import com.company.Contact;
import com.company.model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.company.Main.start;
import static com.company.controller.Controller.*;

public class Json {

    public static void saveToJson() {
        for (String name : Contact.contacts.keySet()) {
            User user = Contact.contacts.get(name);
            System.out.println(name + "\n" + userService.contactNumbers(user) +
                    emailService.contactEmails(user) +
                    " " + user.getCompany());
            //Crate json file
            JSONParser jsonParser = new JSONParser();

            try (FileReader reader = new FileReader("employees.json")) {
                //Read JSON file
                Object obj = jsonParser.parse(reader);

                JSONArray existingData = (JSONArray) obj;

                for (Object existingDatum : existingData) {

                    JSONObject explrObject = (JSONObject) existingDatum;
                    phonebookList.add(explrObject);

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
            phoneDetails.put("Number", userService.contactNumbers(user));
            phoneDetails.put("Email", emailService.contactEmails(user));
            phoneObject.put(name, phoneDetails);
            phonebookList.add(phoneObject);

            //Write JSON file
            try (FileWriter file = new FileWriter("employees.json")) {
                file.write(phonebookList.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }


    public static void showAllJson() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("employees.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;

            employeeList.forEach(emp -> parsephoneObject((JSONObject) emp));
            convertToUserList(employeeList);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        start();

    }

    private static void convertToUserList(JSONArray employeeList) throws Exception {




    }


    private static void parsephoneObject(JSONObject employee) {
//        //Get employee object within list
//        JSONObject phoneObject2 = (JSONObject) employee.get("");
//        //employeeList.add(employeeObject2);
//
//        System.out.println(employee);
//
//
//        //Get employee last name
//        String lastName = (String) phoneObject2.get("Name");
//        System.out.println(lastName);
//
//        String number = (String) phoneObject2.get("Number");
//        System.out.println(number);


        //Get employee object within list
//        JSONObject contactObject = (JSONObject) employee.get("employee");
//
//        //Get employee first name
//        String Name = (String) contactObject.get("tName");
//        System.out.println(Name);
//
//        //Get employee last name
//        String number = (String) contactObject.get("Number");
//        System.out.println(number);
//        //Get Contact email
//        String email = (String) contactObject.get("email");
//        System.out.println(email);


    }


}
