package model;

import java.util.ArrayList;

public class TextNotesList {
    private ArrayList<TextModel> notesList;

    public TextNotesList(){
        notesList = new ArrayList<>();
        createListData();
    }

    public ArrayList<TextModel> getNotesList(){
        return notesList;
    }

    public void setNotesList(TextModel aNote){
        notesList.add(aNote);
    }

    public void createListData(){
        TextModel note = new TextModel("comp101", "loops");
        notesList.add(note);

        note = new TextModel("comp101", "memory");
        notesList.add(note);

        note = new TextModel("comp101", "binary system");
        notesList.add(note);

        note = new TextModel("comp101", "variables");
        notesList.add(note);

        note = new TextModel("comp200", "arrays");
        notesList.add(note);

        note = new TextModel("comp200", "linklists");
        notesList.add(note);

        note = new TextModel("comp200", "binary tree");
        notesList.add(note);

        note = new TextModel("comp200", "hash");
        notesList.add(note);
    }
}
