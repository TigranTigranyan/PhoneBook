package services;

import model.*;
import model.Number;

public interface Service {

    void addNewContact(String key, User value);

    void update(String userName, Number number, int index);

    void update(String userName, Email email, int index);

    String contactNames();

    void delete(String key);
}
