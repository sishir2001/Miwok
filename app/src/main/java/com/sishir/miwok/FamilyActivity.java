package com.sishir.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        // ***** numbers in word arraylist******
        ArrayList<Word> strFamily = new ArrayList<Word>();
        strFamily.add(new Word("әpә","father",R.drawable.family_father,R.raw.number_one));
        strFamily.add(new Word("әṭa","mother",R.drawable.family_mother,R.raw.number_one));
        strFamily.add(new Word("angsi","son",R.drawable.family_son,R.raw.number_one));
        strFamily.add(new Word("tune","daughter",R.drawable.family_daughter,R.raw.number_one));
        strFamily.add(new Word("taachi","older brother",R.drawable.family_older_brother,R.raw.number_one));
        strFamily.add(new Word("chalitti","younger brother",R.drawable.family_younger_brother,R.raw.number_one));
        strFamily.add(new Word("teṭe","older sister",R.drawable.family_older_sister,R.raw.number_one));
        strFamily.add(new Word("kolliti","younger sister",R.drawable.family_younger_sister,R.raw.number_one));
        strFamily.add(new Word("ama","grandmother",R.drawable.family_grandmother,R.raw.number_one));
        strFamily.add(new Word("paapa","grandfather",R.drawable.family_grandfather,R.raw.number_one));
        // ******** added the numbers to ArrayList

        // creating the ArrayAdapter which converts the objects into views for Views that recycle views.
        // ArrayAdapter declaration, initialization and instatiation
        WordAdapter itemAdapter = new WordAdapter(this,strFamily,R.color.green);// WordAdapter is a custom class adapter where it is customized to hold two textViews
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
                        mediaPlayer = MediaPlayer.create(FamilyActivity.this, obj.getVoiceId());
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