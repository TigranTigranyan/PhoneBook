package model;

public enum EmailType {
    GMAIL(0), ICLOUD(1), OTHER(2);
    private int index;

    EmailType(int index){
        this.index=index;
    }
}
