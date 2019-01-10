package com.tk.takenoteapp;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import java.util.Calendar;

import model.TextModel;

/**
 * A fragment with a Google +1 button.
 */
public class TakeNoteFragment extends Fragment {
    private EditText addSubject;
    private EditText addNote;
    private Button submitNote;
    private FloatingActionButton addImgButton;
    private setNoteToNotesList sNoteToNotesList;
    private getFragmentList gFragmentList;
    private final int REQUEST_IMAGE_CAPTURE = 1;
    private Bitmap imageBitmap;

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

                TextModel aNote;

                if(imageBitmap == null){
                    aNote = new TextModel(addSubject.getText().toString(), addNote.getText().toString()
                            ,Calendar.getInstance().getTime());
                }else{
                    aNote = new TextModel(addSubject.getText().toString(), addNote.getText().toString()
                            ,Calendar.getInstance().getTime(),
                            imageBitmap);
                }

                sNoteToNotesList.setNewTextNoteToList(aNote);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_fragmentHolder, gFragmentList.getFragmentListToRedirect()).commit();
            }
        });

        addImgButton = view.findViewById(R.id.circle_button_add_img);
        addImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("dedededede");//implement camera integration
                dispatchTakePictureIntent();
            }
        });


        return view;
    }


    private void dispatchTakePictureIntent(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null){
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            if(imageBitmap != null)
                System.out.println("hell yea");
            else
                System.out.println("fuck off");
        }
    }

    public interface setNoteToNotesList{
        public void setNewTextNoteToList(TextModel newNode);
    }

    public interface getFragmentList{
        public Fragment getFragmentListToRedirect();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            sNoteToNotesList = (setNoteToNotesList) context;
            gFragmentList = (getFragmentList) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " must implement setNewTextNoteToList");
        }
    }

}
