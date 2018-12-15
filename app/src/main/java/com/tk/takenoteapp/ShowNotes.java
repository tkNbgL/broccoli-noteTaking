package com.tk.takenoteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import model.RetroTextList;
import network.GetDataService;
import network.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowNotes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notes);

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<RetroTextList> getOneTexts = service.getOneTexts();
        getOneTexts.enqueue(new Callback<RetroTextList>(){
            @Override
            public void onResponse(Call<RetroTextList> call, Response<RetroTextList> response){
                generateText(response.body());
            }

            @Override
            public void onFailure(Call<RetroTextList> call, Throwable t){
                // Toast.makeText(ShowNotes.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                Log.e(call.toString(), "In the onFailure function: " + t);
            }
        });
    }

    private void generateText(RetroTextList textList){
        TextView textViewSubject = (TextView) findViewById(R.id.ShowNoteSubject);
        TextView textViewNote = (TextView) findViewById(R.id.ShowNoteNote);
        textViewSubject.setText(textList.getSubject());
        textViewNote.setText(textList.getNote());
    }


}
