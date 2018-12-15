package model;

import com.google.gson.annotations.SerializedName;

public class RetroTextList {
    @SerializedName("id")
    private Integer id;
    @SerializedName("subject")
    private String subject;
    @SerializedName("note")
    private String note;

    public RetroTextList(Integer id, String subject, String note){
        this.id = id;
        this.subject = subject;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
