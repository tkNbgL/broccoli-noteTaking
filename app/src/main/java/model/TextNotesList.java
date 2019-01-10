package model;


import java.util.ArrayList;
import java.util.Calendar;

public class TextNotesList {
    private ArrayList<TextModel> notesList;


    public TextNotesList(){
        notesList = new ArrayList<>();
        createListData();
    }

    public TextModel getNote(int position){
        return notesList.get(position);
    }

    public ArrayList<TextModel> getNotesList(){
        return notesList;
    }

    public void setNotesList(TextModel aNote){
        notesList.add(aNote);
    }

    public void createListData(){
        TextModel note = new TextModel("comp101", "loops", Calendar.getInstance().getTime());
        notesList.add(note);

        note = new TextModel("comp101", "memory", Calendar.getInstance().getTime());
        notesList.add(note);

        note = new TextModel("comp101", "binary system", Calendar.getInstance().getTime());
        notesList.add(note);

        note = new TextModel("comp101", "variables", Calendar.getInstance().getTime());
        notesList.add(note);

        note = new TextModel("comp200", "arrays", Calendar.getInstance().getTime());
        notesList.add(note);

        note = new TextModel("comp200", "linklists", Calendar.getInstance().getTime());
        notesList.add(note);

        note = new TextModel("comp200", "binary tree", Calendar.getInstance().getTime());
        notesList.add(note);

        note = new TextModel("comp200", "hash", Calendar.getInstance().getTime());
        notesList.add(note);
    }
}
