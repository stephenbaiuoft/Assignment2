package com.example.stephenbai.assignment2;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class loadFilesFrag extends Fragment   {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_load_files, container, false);

        ListView listview = (ListView) v.findViewById(R.id.fraglist) ;
                //v.findViewById(R.id.fraglist);

        ArrayList<String> entries = new ArrayList<String>();
        ArrayAdapter<String> adapter=null;

        File dir = new File(v.getContext().getFilesDir(), ".");
        File[] filesList = dir.listFiles();
        if (filesList != null) {
            for (File filename : filesList) {
                if (filename.isFile()) {

                    entries.add( filename.getName());
                }
            }

        }

        // if within a fragment
        adapter=  new ArrayAdapter<String>( getActivity().getApplicationContext(),
                android.R.layout.simple_list_item_1,
                entries);

        listview.setAdapter(adapter);

        return v;
    }



/*
        File dir = new File(v.getContext().getFilesDir(), ".");
        File[] filesList = dir.listFiles();
        if (filesList != null) {

            for (File filename : filesList) {
                if (filename.isFile()) {
                }
            }

        }
        */


}
