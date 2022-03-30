package com.company.model;

public class User {
    private String emails;
    private String company;
    private String phoneNumbers;
    private PhoneNumberType numberType;
    private EmailType emailType;

    public User(String emails, String company, String phoneNumbers,
                PhoneNumberType numberType, EmailType emailType) {
        this.emails = emails;
        this.company = company;
        this.phoneNumbers = phoneNumbers;
        this.numberType = numberType;
        this.emailType = emailType;
    }


}
