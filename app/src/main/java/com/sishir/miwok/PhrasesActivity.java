package com.sishir.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        // ***** numbers in word arraylist******
        ArrayList<Word> strPhrases = new ArrayList<Word>();
        strPhrases.add(new Word("minto wuksus","Where are you going?"));
        strPhrases.add(new Word("tinnә oyaase'nә","What is your name?"));
        strPhrases.add(new Word("oyaaset...","My name is..."));
        strPhrases.add(new Word("michәksәs?","How are you feeling?"));
        strPhrases.add(new Word("kuchi achit","I’m feeling good."));
        strPhrases.add(new Word("әәnәs'aa?","Are you coming?"));
        strPhrases.add(new Word("hәә’ әәnәm","Yes, I’m coming."));
        strPhrases.add(new Word("әәnәm","I’m coming."));
        strPhrases.add(new Word("yoowutis","Let’s go."));
        strPhrases.add(new Word("әnni'nem","Come here."));
        // ******** added the numbers to ArrayList

        // creating the ArrayAdapter which converts the objects into views for Views that recycle views.
        // ArrayAdapter declaration, initialization and instatiation
        WordAdapter itemAdapter = new WordAdapter(this,strPhrases,R.color.aqua);// WordAdapter is a custom class adapter where it is customized to hold two textViews
        // finding the listview
        // *****
        ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(itemAdapter);

    }
}