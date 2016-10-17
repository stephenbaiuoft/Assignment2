package com.example.stephenbai.assignment2;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class mainfrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View result=inflater.inflate(R.layout.fragment_mainfrag, container, false);

        Button etitle =(Button) result.findViewById(R.id.etitle);
        etitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).enterTitle( v );
            }
        });

        Button button_view =(Button) result.findViewById(R.id.button_view);
        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).showViewList(v);
            }
        });


        Button button_load =(Button) result.findViewById(R.id.load);
        button_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).loadFiles(v);
            }
        });


        Button button_store =(Button) result.findViewById(R.id.store);
        button_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).store(v);
            }
        });

        //result.findViewById(R.id.button_view).setOnClickListener(this);


        Button button_exit =(Button) result.findViewById(R.id.exit);
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).exit(v);
            }
        });
        return result;
    }

    @Override
    public void onDestroyView (){

        super.onDestroyView();

        // save all unsaved data onto default temp file
        String filename = "DefaultTempFile.txt";
        File file = new File( getActivity().getApplicationContext().getFilesDir(), filename);

        PrintWriter outputStream;


        ArrayList<String> tmp = ((MainActivity)getActivity()).getTitle_entries();


        try {
            outputStream = new PrintWriter(new BufferedWriter( new FileWriter(file, true)));

            //v.getContext().openFileOutput(filename, v.getContext().MODE_APPEND);
            for (String line : tmp) {
                outputStream.println(line);
                //outputStream.write("***".getBytes());
            }

            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
