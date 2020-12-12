package com.sishir.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        // ***** numbers in word arraylist******
        ArrayList<Word> strColor = new ArrayList<Word>();
        strColor.add(new Word("weṭeṭṭi","red",R.drawable.color_red));
        strColor.add(new Word("chokokki","green",R.drawable.color_green));
        strColor.add(new Word("takaaki","brown",R.drawable.color_brown));
        strColor.add(new Word("topoppi","gray",R.drawable.color_gray));
        strColor.add(new Word("kululli","black",R.drawable.color_black));
        strColor.add(new Word("kelelli","white",R.drawable.color_white));
        strColor.add(new Word("ṭopiisә","dusty yellow",R.drawable.color_dusty_yellow));
        strColor.add(new Word("chiwiiṭә","mustard yellow",R.drawable.color_mustard_yellow));

        // ******** added the numbers to ArrayList

        // creating the ArrayAdapter which converts the objects into views for Views that recycle views.
        // ArrayAdapter declaration, initialization and instatiation
        WordAdapter itemAdapter = new WordAdapter(this,strColor,R.color.purple_500);// WordAdapter is a custom class adapter where it is customized to hold two textViews
        // finding the listview
        // *****
       ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(itemAdapter);


    }
}