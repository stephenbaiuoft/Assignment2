package com.example.stephenbai.assignment2;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class storefrag extends Fragment {

    private String filename = "DefaultTempFile.txt";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View result = inflater.inflate(R.layout.fragment_storefrag, container, false);

        Button confirm = (Button) result.findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputstring = (EditText) result.findViewById(R.id.file_name);
                if(!inputstring.getText().toString().isEmpty()){
                    filename = inputstring.getText().toString() + ".txt";
                }

                File file = new File(v.getContext().getFilesDir(), filename);
                PrintWriter outputStream;

                ArrayList<String> result = (ArrayList<String>) ((MainActivity)getActivity()).getTitle_entries().clone() ;

                try {
                    outputStream = new PrintWriter(new BufferedWriter( new FileWriter(file, true)));

                            //v.getContext().openFileOutput(filename, v.getContext().MODE_APPEND);
                    for (String line : result) {
                        outputStream.println(line);


                        //outputStream.write("***".getBytes());
                    }

                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            ((MainActivity)getActivity()).back_to_mainfrag( v );
            }
        });

        return result;
    }



}
