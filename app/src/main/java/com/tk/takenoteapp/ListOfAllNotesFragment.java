package com.tk.takenoteapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.w3c.dom.Text;

import java.util.ArrayList;

import adapter.NotesAdapter;
import model.TextModel;


public class ListOfAllNotesFragment extends Fragment {
    private RecyclerView recyclerView;
    private NotesAdapter notesAdapter;
    private ArrayList<TextModel> notes;
    SendMessage SM;

    public ListOfAllNotesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notes = new ArrayList<TextModel>();
        notesAdapter = new NotesAdapter(getActivity(), notes);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_of_all_notes, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(notesAdapter);
        createListData();
        SM.sendArrayListOfNotes(notes);
        return view;
    }

    public void createListData(){
        TextModel note = new TextModel("dede", "utku", "nebi");
        notes.add(note);

        note = new TextModel("dede", "tutku", "tnebi");
        notes.add(note);

        note = new TextModel("dede", "ttutku", "ttnebi");
        notes.add(note);

        note = new TextModel("dede", "tttutku", "tttnebi");
        notes.add(note);

        note = new TextModel("adede", "autku", "anebi");
        notes.add(note);

        note = new TextModel("aadede", "aautku", "aanebi");
        notes.add(note);

        note = new TextModel("aaadede", "aaautku", "aaanebi");
        notes.add(note);

        note = new TextModel("aaadede", "aaautku", "aaanebi");
        notes.add(note);

        notesAdapter.notifyDataSetChanged();
    }


    public interface SendMessage {
        void sendArrayListOfNotes(ArrayList<TextModel> notes);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try{
            SM = (SendMessage) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException("error in retrieving data. Please try again.");
        }
    }
}
