package com.tk.takenoteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import adapter.CustomListViewAdapter;
import model.RetroTextList;
import network.GetDataService;
import network.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowAllNotes extends AppCompatActivity {

    private ListView listView;
    private CustomListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_notes);
        getDataFromService();
    }


    private void getDataFromService(){
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArrayList<RetroTextList>> getTexts = service.getOneTexts();
        getTexts.enqueue(new Callback<ArrayList<RetroTextList>>() {
            @Override
            public void onResponse(Call<ArrayList<RetroTextList>> call, Response<ArrayList<RetroTextList>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<RetroTextList>> call, Throwable t) {
                Log.e(call.toString(), "In the onFailure function: " + t);
            }
        });
    }

    private void generateDataList(ArrayList<RetroTextList> textList){
        listView =(ListView) findViewById(R.id.textNote_list_view);
        listViewAdapter = new CustomListViewAdapter(this, textList);
        listView.setAdapter(listViewAdapter);
    }


}
