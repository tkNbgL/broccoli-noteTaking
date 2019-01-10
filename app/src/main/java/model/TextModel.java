package model;


import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.Date;

//this class will be used to provide dummy data
public class TextModel implements Serializable{
    private String subject;
    private String note;
    private Date currentTime;
    private Bitmap notesImage;

   /* public TextModel(){
        notes = new ArrayList<TextModel>();
        createDumpData();
    }*/

    public TextModel(String subject, String note, Date currentTime){
        this.subject = subject;
        this.note = note;
        this.currentTime = currentTime;
        this.notesImage = null;
    }

    public TextModel(String subject, String note, Date currentTime, Bitmap notesImage){
        this.subject = subject;
        this.note = note;
        this.currentTime = currentTime;
        this.notesImage = notesImage;
    }


    public Bitmap getNotesImage() {
        return notesImage;
    }

    public void setNotesImage(Bitmap notesImage) {
        this.notesImage = notesImage;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
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
