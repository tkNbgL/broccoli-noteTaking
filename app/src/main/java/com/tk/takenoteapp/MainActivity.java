package com.tk.takenoteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonTakeNote = (Button) findViewById(R.id.takeNote);
        buttonTakeNote.setOnClickListener(this);
        Button buttonTakePhoto = (Button) findViewById(R.id.takePhoto);
        buttonTakePhoto.setOnClickListener(this);
        Button buttonRecordVoice = (Button) findViewById(R.id.recordVoice);
        buttonRecordVoice.setOnClickListener(this);
        Button buttonLookedAtNotes = (Button) findViewById(R.id.lookAtNotes);
        buttonLookedAtNotes.setOnClickListener(this);

    }

    public void onClick(View v){
       /* if(v.getId() == R.id.takeNote){
            Intent intent = new Intent(this, TextNote.class);
            startActivity(intent);
        }else if(v.getId() == R.id.takePhoto){
            Intent intent = new Intent(this, TakePhoto.class);
            startActivity(intent);
        }else if(v.getId() == R.id.lookAtNotes){
            Intent intent = new Intent(this, ShowAllNotes.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, RecordVoice.class);
            startActivity(intent);
        }*/
    }


}
