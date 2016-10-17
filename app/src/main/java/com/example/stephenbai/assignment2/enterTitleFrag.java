package com.example.stephenbai.assignment2;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class enterTitleFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_enter_title, container, false);

        Spinner spinner = (Spinner)v.findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout

        //Within fragment, use getActiity() to replace this
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( getActivity() ,
                R.array.year_ary, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        Button done_adding = (Button) v.findViewById(R.id.done_adding);
        done_adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"this is testing for done_adding", Toast.LENGTH_SHORT).show();


                ((MainActivity)getActivity()).back_to_mainfrag(v);
            }
        });

        Button add = (Button) v.findViewById(R.id.add_entry);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).add_single_movie(v);
            }
        });



        // Inflate the layout for this fragment
        return v;
    }

}



