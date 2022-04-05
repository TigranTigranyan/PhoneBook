package services;


import mainStart.Contact;
import model.*;
import model.Number;

public class UserService implements Service {

    @Override
    public void addNewContact(String key, User value) {
        Contact.contacts.put(key, value);
    }

    @Override
    public void update(String userName, Number number, int index) {
        Contact.contacts.get(userName).getNumbers().get(index - 1).setNumber(number.getNumber());
        Contact.contacts.get(userName).getNumbers().get(index - 1).setType(number.getType());
    }

    @Override
    public void update(String userName, Email email, int index) {
        Contact.contacts.get(userName).getEmails().get(index - 1).setEmail(email.getEmail());
        Contact.contacts.get(userName).getEmails().get(index - 1).setType(email.getType());
    }

    @Override
    public String contactNames() {
        StringBuilder s = new StringBuilder();
        int i = 1;
        for (String str : Contact.contacts.keySet()) {
            s.append(i).append(": ").append(str).append("\n");
            i++;
        }
        return s.toString();
    }

    @Override
    public void delete(String key) {
        Contact.contacts.remove(key);
    }
}
