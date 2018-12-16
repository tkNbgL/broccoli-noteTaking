package com.tk.takenoteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TextNote extends AppCompatActivity implements View.OnClickListener{

    EditText subject;
    EditText note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_note);

        subject = (EditText) findViewById(R.id.editTextSubject);
        note = (EditText) findViewById(R.id.editTextNote);
        Button sentButton = (Button) findViewById(R.id.submitText);
        sentButton.setOnClickListener(this);

    }

    public void onClick(View v){
       /* TextMessage incomingNote = new TextMessage();
        incomingNote.setSubject(subject.getText().toString());
        incomingNote.setNote(note.getText().toString());
        System.out.println(incomingNote.toString());*/
    }
}
