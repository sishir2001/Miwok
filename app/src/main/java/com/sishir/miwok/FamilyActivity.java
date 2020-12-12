package com.sishir.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        // ***** numbers in word arraylist******
        ArrayList<Word> strFamily = new ArrayList<Word>();
        strFamily.add(new Word("әpә","father",R.drawable.family_father));
        strFamily.add(new Word("әṭa","mother",R.drawable.family_mother));
        strFamily.add(new Word("angsi","son",R.drawable.family_son));
        strFamily.add(new Word("tune","daughter",R.drawable.family_daughter));
        strFamily.add(new Word("taachi","older brother",R.drawable.family_older_brother));
        strFamily.add(new Word("chalitti","younger brother",R.drawable.family_younger_brother));
        strFamily.add(new Word("teṭe","older sister",R.drawable.family_older_sister));
        strFamily.add(new Word("kolliti","younger sister",R.drawable.family_younger_sister));
        strFamily.add(new Word("ama","grandmother",R.drawable.family_grandmother));
        strFamily.add(new Word("paapa","grandfather",R.drawable.family_grandfather));
        // ******** added the numbers to ArrayList

        // creating the ArrayAdapter which converts the objects into views for Views that recycle views.
        // ArrayAdapter declaration, initialization and instatiation
        WordAdapter itemAdapter = new WordAdapter(this,strFamily,R.color.green);// WordAdapter is a custom class adapter where it is customized to hold two textViews
        // finding the listview
        // *****
      ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(itemAdapter);

    }
}