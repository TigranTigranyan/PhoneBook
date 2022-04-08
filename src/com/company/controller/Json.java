package controller;

import mainStart.Contact;
import mainStart.GUI;
import mainStart.Helper;
import model.User;
import services.EmailService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static controller.ControllerImpl.*;

public class Json {
    static EmailService emailService = new EmailService();
    static Scanner sc = new Scanner(System.in);

    public static void saveToJson() {
        for (String name : Contact.contacts.keySet()) {
            User user = Contact.contacts.get(name);
            System.out.println("Name: " + name + "\n\nNumbers: \n" + numberService.contactNumbers(user) +
                    "\nEmails: \n" + emailService.contactEmails(user) +
                    "\nCompany: " + user.getCompany());
            /**
             * Write to json file
             */
            JSONParser jsonParser = new JSONParser();
            JSONArray phonelist = new JSONArray();
            try (FileReader reader = new FileReader("phonebook.json")) {
                Object obj = jsonParser.parse(reader);
                JSONArray existingData = (JSONArray) obj;
                for (Object existingDatum : existingData) {
                    JSONObject explrObject = (JSONObject) existingDatum;
                    phonelist.add(explrObject);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            JSONObject phonebookobj = new JSONObject();
            JSONObject phonedetal = new JSONObject();

            phonedetal.put("Name", name);
            phonedetal.put("Number", numberService.contactNumbers(user));
            phonedetal.put("Email", emailService.contactEmails(user));
            phonedetal.put("Company: ", user.getCompany());
            phonebookobj.put("Contact", phonedetal);
            phonelist.add(phonebookobj);

            try (FileWriter phonebook = new FileWriter("phonebook.json")) {
                phonebook.write(phonelist.toJSONString());
                phonebook.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public static void showAllinfoJson() {


        /**
         * read , and show all info contacts from json file
         */
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("phonebook.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray phonelist = (JSONArray) obj;
//            System.out.println(phonelist);
            phonelist.forEach(emp -> parsephoneObject((JSONObject) emp));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        GUI.start();

    }

    public static void showAllNames() {
        /**
         * Show only names from json file
         */
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("phonebook.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray phonelist = (JSONArray) obj;
//            System.out.println(phonelist);
            phonelist.forEach(emp -> parsephoneObjectname((JSONObject) emp));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        GUI.start();
    }

    /**
     * parse json to string
     *
     * @param contact
     */

    private static void parsephoneObject(JSONObject contact) {
        JSONObject phoneobject = (JSONObject) contact.get("Contact");
        String name = (String) phoneobject.get("Name");
        System.out.println("Name: " + name);
        String number = (String) phoneobject.get("Number");
        System.out.println("Number: " + number);
        String email = (String) phoneobject.get("Email");
        System.out.println("Email: " + email);
        String company = (String) phoneobject.get("Company: ");
        System.out.println("Company: " + company);
        System.out.println("____________________________");


    }

    private static void parsephoneObjectname(JSONObject contact) {
        JSONObject phoneobject = (JSONObject) contact.get("Contact");
        String name = (String) phoneobject.get("Name");
        System.out.println("Name: " + name);
    }

    /**
     * remove contact with index
     */

    public static void delitefromJson() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("phonebook.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray phonelist = (JSONArray) obj;
            phonelist.forEach(emp -> parsephoneObjectname((JSONObject) emp));
            phonelist.remove(sc.nextInt());
            try (FileWriter phonebook = new FileWriter("phonebook.json")) {
                phonebook.write(phonelist.toJSONString());
                phonebook.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    public static void UpdateJson() {

        JSONParser jsonParser = new JSONParser();
        JSONObject js = new JSONObject();
        JSONArray phonelist = new JSONArray();
        try (FileReader reader = new FileReader("phonebook.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray existingData = (JSONArray) obj;
            for (Object existingDatum : existingData) {
                JSONObject explrObject = (JSONObject) existingDatum;
                JSONObject phoneobject = (JSONObject) explrObject.get("Contact");
                String name = (String) phoneobject.get("Name");
                System.out.println("Name  " + name);
                if (name== sc.next()){
                    phoneobject.remove(sc.next());
                    phoneobject.put("Name", sc.nextLine());
                }
                explrObject.put("Contact", phoneobject);
                phonelist.add(explrObject);


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        try (FileWriter phonebook = new FileWriter("phonebook.json")) {
            phonebook.write(phonelist.toJSONString());
            phonebook.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


