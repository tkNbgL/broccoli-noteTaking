package model;

//this class will be used to provide dummy data
public class TextModel {
    private String tags;
    private String subject;
    private String note;

    public TextModel(){

    }

    public TextModel(String tags, String subject, String note){
        this.tags = tags;
        this.subject = subject;
        this.note = note;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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
