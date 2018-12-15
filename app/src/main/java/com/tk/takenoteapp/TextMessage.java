package com.tk.takenoteapp;

public class TextMessage {
    private String subject;
    private String note;

    public TextMessage(){}

    public TextMessage(String subject, String note){
        this.subject = subject;
        this.note = note;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "subject='" + subject + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
