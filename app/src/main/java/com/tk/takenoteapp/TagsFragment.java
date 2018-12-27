package com.tk.takenoteapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapter.TagsAdapter;
import model.TextModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class TagsFragment extends Fragment {
    private RecyclerView recyclerView;
    private TagsAdapter tagsAdapter;
    private ArrayList<TextModel> notes;


    public TagsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //notes = data coming from other fragment
        tagsAdapter = new TagsAdapter(getActivity(), notes);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tags, container, false);
    }

}
