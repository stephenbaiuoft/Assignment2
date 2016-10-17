package com.example.stephenbai.assignment2;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.id.content;


public class MainActivity extends AppCompatActivity {
    private ArrayList <String> title_entries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getFragmentManager().findFragmentById(content) == null) {
            getFragmentManager().beginTransaction()
                    .add(android.R.id.content,
                            new mainfrag()).addToBackStack(null).commit();
        }

    }

    //mainfrag call enterTitle
    public void enterTitle(View enterTitle) {
        // initiates the entertitle fragment

        //Replace to new fragment
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content,
                        new enterTitleFrag()).addToBackStack(null).commit();

    }

    //mainfrag call enterTitle
    public void loadFiles(View v) {
        // initiates the load file fragment

        //Replace to new fragment
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content,
                        new loadFilesFrag()).addToBackStack(null).commit();

    }


    public void showViewList(View v) {
        // initiates the entertitle fragment
        Intent i = new Intent( this , ViewList.class);
        i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        //other.putExtra(OtherActivity.EXTRA_MESSAGE, getString(R.string.other));
        ArrayList <String> tmp = (ArrayList<String>) title_entries.clone();

        i.putStringArrayListExtra("templisting",tmp);

        //i.putExtra(ViewList.TempListing ,pass);

        startActivity(i);

    }

// store function
    public void store(View v){
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content,
                        new storefrag()).addToBackStack(null).commit();
    }



    public void back_to_mainfrag(View v){
        // return to previous stack
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount()>0){
            Log.i("MainActivity", "popping backstack");
            fm.popBackStack();
        }
    }



    //
    public void add_single_movie(View v){
        String title = "Unknown Movie";
        String actor = "Unknown Artist";
        String year;

        String line_entry;
        EditText Etitle,  Eactor;
        Spinner Eyear;

        Etitle = (EditText) findViewById(R.id.movie_title);

        // if user provides input
        if (!Etitle.getText().toString().isEmpty()){
            title = Etitle.getText().toString();
        }
        //title=Etitle.getHint().toString();

        Eyear = (Spinner) findViewById(R.id.spinner);
        year= Eyear.getSelectedItem().toString();


        Eactor = (EditText) findViewById(R.id.movie_actor);
        if (!Eactor.getText().toString().isEmpty()){
            actor = Eactor.getText().toString();
        }

        line_entry = "Title: <"+ title +">   |    Year: <" +  year + ">   |    Actor: <"+ actor+">"  ;
        String debug = "Added: " + line_entry ;
        Toast.makeText( getApplicationContext(), debug, Toast.LENGTH_SHORT).show();
        title_entries.add(line_entry);

    }

    public ArrayList<String> getTitle_entries(){
        // clear whatever is in there
        ArrayList<String> result = (ArrayList<String>) title_entries.clone();
        title_entries.clear();
        //title_entries.clear();
        return result;
    }

    public void exit(View v){
        finish();
    }

    public ArrayList<String> get_entries(){

        return title_entries;
    }
}