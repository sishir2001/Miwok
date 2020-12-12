package com.sishir.miwok;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        // ***** numbers in word arraylist******
        ArrayList<Word> strNumbers = new ArrayList<Word>();
        strNumbers.add(new Word("lutti","one",R.drawable.number_one));
        strNumbers.add(new Word("ottiko","two",R.drawable.number_two));
        strNumbers.add(new Word("toolokusa","three",R.drawable.number_three));
        strNumbers.add(new Word("oyyisa","four",R.drawable.number_four));
        strNumbers.add(new Word("mossaka","five",R.drawable.number_five));
        strNumbers.add(new Word("temmokka","six",R.drawable.number_six));
        strNumbers.add(new Word("kanekaku","seven",R.drawable.number_seven));
        strNumbers.add(new Word("kawinta","eight",R.drawable.number_eight));
        strNumbers.add(new Word("wo'e","nine",R.drawable.number_nine));
        strNumbers.add(new Word("na'aacha","ten",R.drawable.number_ten));
        // ******** added the numbers to ArrayList

        // creating the ArrayAdapter which converts the objects into views for Views that recycle views.
        // ArrayAdapter declaration, initialization and instatiation
        WordAdapter itemAdapter = new WordAdapter(this,strNumbers,R.color.orange);// WordAdapter is a custom class adapter where it is customized to hold two textViews
        // finding the listview
        // *****
      ListView listView = (ListView)findViewById(R.id.listview);
      listView.setAdapter(itemAdapter);


        //********




    }
}