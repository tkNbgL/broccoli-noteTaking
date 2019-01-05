package model;

import java.util.ArrayList;

//this class will be used to provide dummy data
public class TextModel {
    private String subject;
    private String note;
    private ArrayList<TextModel> notes;

   /* public TextModel(){
        notes = new ArrayList<TextModel>();
        createDumpData();
    }*/

    public TextModel(String subject, String note){
        this.subject = subject;
        this.note = note;
    }

    private void createDumpData(){
        TextModel note = new TextModel("comp101", "loops");
        notes.add(note);

        note = new TextModel("comp101", "memory");
        notes.add(note);

        note = new TextModel("comp101", "binary system");
        notes.add(note);

        note = new TextModel("comp101", "variables");
        notes.add(note);

        note = new TextModel("comp200", "arrays");
        notes.add(note);

        note = new TextModel("comp200", "linklists");
        notes.add(note);

        note = new TextModel("comp200", "binary tree");
        notes.add(note);

        note = new TextModel("comp200", "hash");
        notes.add(note);
    }

    public ArrayList<TextModel> getNotes() {
        return notes;
    }

    public void addNewNote(TextModel textModel) {
        notes.add(textModel);
    }



    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
