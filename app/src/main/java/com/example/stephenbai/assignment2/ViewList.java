package com.example.stephenbai.assignment2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

// to view available movies

public class ViewList extends ListActivity {
    private ListView  listView;

    private ArrayList<String> entries=null;
    private ArrayAdapter<String> adapter=null;

    // temp for holding up to 50
    public static String[] TempListing = new String[50];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        listView = getListView();
        entries=new ArrayList<String>();

       // String [] tentries =  new String[];


        File dir = new File(getApplicationContext().getFilesDir(), "." );
        File[] filesList = dir.listFiles();
        if (filesList != null) {

            for (File filename : filesList) {
                if (filename.isFile()  ) {

                    //InputStream instream;
                    try {
// open the file for reading
                        //instream = new FileInputStream(filename);

// if file the available for reading

                            // prepare the file for reading
                            //InputStreamReader inputreader = new InputStreamReader(instream);
                            BufferedReader buffreader = new BufferedReader( new FileReader(filename));

                            String line;
                            line = buffreader.readLine();
                            // read every line of the file into the line-variable, on line at the time
                            while(line !=null ){
                                // add to entries array list
                                entries.add(line);

                                line = buffreader.readLine();
                                // do something with the line
                            }

                        }

                    catch (Exception ex) {
                        // print stack trace.
                    }

                }
            }
        }

        Intent intent = getIntent();
        ArrayList<String> temp = intent.getStringArrayListExtra("templisting");

        if (!temp.isEmpty()) {
            entries.add("Below is Unsaved Data Members");


            for (int i = 0; i < temp.size(); i++) {
                entries.add(temp.get(i));
            }
        }

        adapter=  new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                entries);

        this.listView.setAdapter(adapter);

    }



   /* private void addWord() {
        if (adapter.getCount()<items.length) {
            adapter.add(items[adapter.getCount()]);
        }
    }*/

}
