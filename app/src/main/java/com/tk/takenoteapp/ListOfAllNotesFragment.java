package com.tk.takenoteapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import adapter.NotesAdapter;
import adapter.RecyclerViewClickListener;
import model.TextModel;
import model.TextNotesList;


public class ListOfAllNotesFragment extends Fragment {
    private RecyclerView recyclerView;
    private NotesAdapter notesAdapter;
    private TextNotesList notes;
    private getDataForNotesArrayList gDataFromNotesArrayList;

    public ListOfAllNotesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notes = gDataFromNotesArrayList.getNotesArraylistData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_of_all_notes, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                TextModel aSingleNote = notes.getNote(position);
                FragmentTransaction ft = getActivity().getSupportFragmentManager()
                        .beginTransaction();
                Fragment fragment = ShowNoteFragment.newInstance(aSingleNote);
                ft.replace(R.id.frame_fragmentHolder, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        };
        notesAdapter = new NotesAdapter(getActivity(), notes.getNotesList(),listener);
        recyclerView.setAdapter(notesAdapter);
        notesAdapter.notifyDataSetChanged();
        return view;
    }

    public interface getDataForNotesArrayList {
        public TextNotesList getNotesArraylistData();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            gDataFromNotesArrayList = (getDataForNotesArrayList) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " must implement getNotesArraylistData");
        }
    }

}
