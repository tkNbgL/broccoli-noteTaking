package com.tk.takenoteapp;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class AfterLogMainPage extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private List<ListOfAllNotesFragment> fragments = new ArrayList<>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_log_main_page);
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
                                System.out.println(item.getItemId());
                                break;
                            case R.id.tags :

                            case R.id.create:

                            case R.id.inbox:
                        }
                        return true;
                    }
                }
        );
    }

    private void buildFragmentsList(){
        ListOfAllNotesFragment listOfAllNotesFragment = buildFragment();
        fragments.add(listOfAllNotesFragment);
    }

    private ListOfAllNotesFragment buildFragment(){
        ListOfAllNotesFragment fragment = new ListOfAllNotesFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    private void switchFragment(int pos){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_fragmentHolder, fragments.get(pos)).commit();
    }


}
