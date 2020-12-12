package com.sishir.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        // ***** numbers in word arraylist******
        ArrayList<Word> strColor = new ArrayList<Word>();
        strColor.add(new Word("weṭeṭṭi","red",R.drawable.color_red,R.raw.number_one));
        strColor.add(new Word("chokokki","green",R.drawable.color_green,R.raw.number_one));
        strColor.add(new Word("takaaki","brown",R.drawable.color_brown,R.raw.number_one));
        strColor.add(new Word("topoppi","gray",R.drawable.color_gray,R.raw.number_one));
        strColor.add(new Word("kululli","black",R.drawable.color_black,R.raw.number_one));
        strColor.add(new Word("kelelli","white",R.drawable.color_white,R.raw.number_one));
        strColor.add(new Word("ṭopiisә","dusty yellow",R.drawable.color_dusty_yellow,R.raw.number_one));
        strColor.add(new Word("chiwiiṭә","mustard yellow",R.drawable.color_mustard_yellow,R.raw.number_one));

        // ******** added the numbers to ArrayList

        // creating the ArrayAdapter which converts the objects into views for Views that recycle views.
        // ArrayAdapter declaration, initialization and instatiation
        WordAdapter itemAdapter = new WordAdapter(this,strColor,R.color.purple_500);// WordAdapter is a custom class adapter where it is customized to hold two textViews
        // finding the listview
        // *****
       ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // playing sound when clicked.
                try{
                    Word obj = itemAdapter.getItem(position);
                    if(mediaPlayer == null) {
                        mediaPlayer = MediaPlayer.create(ColorsActivity.this, obj.getVoiceId());
                    }
                    mediaPlayer.start();
                    //releasing the resources
                    if(!mediaPlayer.isPlaying()){
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                }
                catch (NullPointerException ne){
                    Log.v("NumbersAvtivity","NPE");
                }
                catch(Exception e){
                    Log.v("NumbersActivity","Some fucking exception");
                }
            }
        });

    }
}