package com.tk.takenoteapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import model.TextModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowNoteFragment extends Fragment {
    private static final String NOTESOBJET_KEY = "notesobject_key";
    private TextModel textModel;

    public ShowNoteFragment() {
        // Required empty public constructor
    }

    public static ShowNoteFragment newInstance(TextModel textModel){
        ShowNoteFragment fragment = new ShowNoteFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(NOTESOBJET_KEY, textModel);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_note, container, false);

        textModel = (TextModel) getArguments().getSerializable(NOTESOBJET_KEY);
        EditText subject = (EditText) view.findViewById(R.id.add_subject_show_note);
        EditText note = (EditText) view.findViewById(R.id.add_note_show_note);
        ImageView dataImage = (ImageView) view.findViewById(R.id.imageView2);
        subject.setText(textModel.getSubject());
        note.setText(textModel.getNote());
        dataImage.setImageBitmap(textModel.getNotesImage());
        return view;
    }

}
