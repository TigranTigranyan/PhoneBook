package services;

import model.Number;
import model.User;

public class NumberService {
    public void addNumber(User user, Number number) {
        user.getNumbers().add(number);
    }

    public static String contactNumbers(User user) {
        StringBuilder str = new StringBuilder();
        for (Number num : user.getNumbers()) {
            str.append(num.getType()).append(" ").append(num.getNumber()).append("\n");
        }
        return str.toString();
    }
}
