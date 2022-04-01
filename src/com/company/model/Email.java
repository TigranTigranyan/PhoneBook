package com.company.model;

public class Email {
    String email;
    EmailType type;

    public Email(String email, EmailType type) {
        this.email = email;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public EmailType getType() {
        return type;
    }
}
