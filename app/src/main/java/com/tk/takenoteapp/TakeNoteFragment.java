package com.tk.takenoteapp;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.plus.PlusOneButton;

import model.TextModel;

/**
 * A fragment with a Google +1 button.
 */
public class TakeNoteFragment extends Fragment {
    private EditText addSubject;
    private EditText addNote;
    private Button submitNote;
    private FloatingActionButton addImgButton;

    public TakeNoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_take_note, container, false);

        addSubject = view.findViewById(R.id.add_subject);
        addNote = view.findViewById(R.id.add_note);

        submitNote = view.findViewById(R.id.submit_note);
        submitNote.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(addSubject.getText() == null | addNote.getText() == null){
                    System.out.println("why don't you write something");
                    //add alert fragment
                    return;
                }

                TextModel aNote = new TextModel(addSubject.getText().toString(), addNote.getText().toString());

            }
        });

        addImgButton = view.findViewById(R.id.circle_button_add_img);
        addImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("dedededede");
            }
        });


        return view;
    }





}
