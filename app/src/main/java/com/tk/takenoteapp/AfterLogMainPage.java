package com.tk.takenoteapp;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import adapter.NotesAdapter;
import model.TextModel;
import model.TextNotesList;

public class AfterLogMainPage extends AppCompatActivity implements ListOfAllNotesFragment.getDataForNotesArrayList,
                                                                    TakeNoteFragment.setNoteToNotesList,
                                                                    TakeNoteFragment.getFragmentList{

    private BottomNavigationView bottomNavigationView;
    private List<Fragment> fragments;
    private TextNotesList textNotesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_log_main_page);
        textNotesList = new TextNotesList();
        fragments = new ArrayList<>(3);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        setListenerForBotMenu(bottomNavigationView);
        buildFragmentsList();
        switchFragment(0);
    }



    public void setListenerForBotMenu(BottomNavigationView bottom){
        bottom.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.mainPage:
                                switchFragment(0);
                                return true;
                            case R.id.create:
                                switchFragment(1);
                                return true;
                            case R.id.inbox:
                        }
                        return true;
                    }
                }
        );
    }

    private void buildFragmentsList(){
        ListOfAllNotesFragment listOfAllNotesFragment = buildFragmentListOfAllFragment();
        TakeNoteFragment takeNoteDialogFragment = buildTakeNoteDialogFragment();
        fragments.add(listOfAllNotesFragment);
        fragments.add(takeNoteDialogFragment);
    }

    private ListOfAllNotesFragment buildFragmentListOfAllFragment(){
        ListOfAllNotesFragment fragment = new ListOfAllNotesFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    private TakeNoteFragment buildTakeNoteDialogFragment(){
        TakeNoteFragment fragment = new TakeNoteFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }



    private void switchFragment(int pos){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_fragmentHolder, fragments.get(pos)).commit();
    }


    @Override
    public TextNotesList getNotesArraylistData() {
        return textNotesList;
    }

    @Override
    public void setNewTextNoteToList(TextModel newNode) {
        textNotesList.setNotesList(newNode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public Fragment getFragmentListToRedirect() {
        return fragments.get(0);
    }
}
