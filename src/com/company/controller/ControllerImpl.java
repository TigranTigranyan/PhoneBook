package controller;
import mainStart.Contact;
import model.Number;
import model.*;
import services.EmailService;
import services.NumberService;
import services.UserService;

public class ControllerImpl implements UserController {

    static UserService userService = new UserService();
    static NumberService numberService = new NumberService();
    static EmailService emailService = new EmailService();

    @Override
    public void create(String userName, User user) {
        userService.addNewContact(userName, user);
    }

    @Override
    public void delete(String name) {
        userService.delete(name);
    }

    @Override
    public void addNumberInExisting(String userName, Number number) {
        numberService.addNumber(Contact.contacts.get(userName), number);

    }


    @Override
    public void addEmailInExisting(String userName, Email email) {
        emailService.addEmail(Contact.contacts.get(userName), email);
    }


    @Override
    public void updateNumber(String userName, Number number, int index) {
        userService.update(userName, number, index);
    }

    @Override
    public void updateEmail(String userName, Email email, int index) {
        userService.update(userName, email, index);
    }

    @Override
    public String showAllNumbersOfAUser(String name) {
        return numberService.contactNumbers(Contact.contacts.get(name));
    }

    @Override
    public String showAllEmailsOfAUser(String name) {
        return emailService.contactEmails(Contact.contacts.get(name));
    }

    @Override
    public String getAllNames() {
        return userService.contactNames();
    }

    @Override
    public void showAll() {
        System.out.println("---------------");
        for (String name : Contact.contacts.keySet()) {
            User user = Contact.contacts.get(name);
            System.out.println("Name: " + name + "\n\nNumbers: \n" + numberService.contactNumbers(user) +
                    "\nEmails: \n" + emailService.contactEmails(user) +
                    "\nCompany: " + user.getCompany());
            System.out.println("---------------");
        }
    }
}
