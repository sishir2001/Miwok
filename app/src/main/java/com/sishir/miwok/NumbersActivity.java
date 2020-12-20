package com.sishir.miwok;


import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
// anonymous class methods can only use final or global variables.
public class NumbersActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        // ***** numbers in word arraylist******
        final ArrayList<Word> strNumbers = new ArrayList<Word>();
        strNumbers.add(new Word("lutti","one",R.drawable.number_one,R.raw.number_one));
        strNumbers.add(new Word("ottiko","two",R.drawable.number_two,R.raw.number_two));
        strNumbers.add(new Word("toolokusa","three",R.drawable.number_three,R.raw.number_three));
        strNumbers.add(new Word("oyyisa","four",R.drawable.number_four,R.raw.number_four));
        strNumbers.add(new Word("mossaka","five",R.drawable.number_five,R.raw.number_five));
        strNumbers.add(new Word("temmokka","six",R.drawable.number_six,R.raw.number_six));
        strNumbers.add(new Word("kanekaku","seven",R.drawable.number_seven,R.raw.number_seven));
        strNumbers.add(new Word("kawinta","eight",R.drawable.number_eight,R.raw.number_eight));
        strNumbers.add(new Word("wo'e","nine",R.drawable.number_nine,R.raw.number_nine));
        strNumbers.add(new Word("na'aacha","ten",R.drawable.number_ten,R.raw.number_ten));
        // ******** added the numbers to ArrayList

        // creating the ArrayAdapter which converts the objects into views for Views that recycle views.
        // ArrayAdapter declaration, initialization and instatiation
        WordAdapter itemAdapter = new WordAdapter(this,strNumbers,R.color.orange);// WordAdapter is a custom class adapter where it is customized to hold two textViews
        // finding the listview
        // *****
      ListView listView = (ListView)findViewById(R.id.listview);
      listView.setAdapter(itemAdapter);
      // adding clicklisteners for everyItem in an adapterView.
      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              // playing sound when clicked.
              try{
                  // TODO below both the lines are useful.
               //   Word obj = strNumbers.get(position);
                  Word obj = itemAdapter.getItem(position);
                  //writing the current state of the object
                  Log.v("NumbersActivity","Current Word "+ obj);
                  // releasing the mediaplayer so that user can change the voice notes.
                  if(mediaPlayer != null){
                      mediaPlayer.release();
                      mediaPlayer = null;
                  }

                  //if(mediaPlayer == null) {
                      mediaPlayer = MediaPlayer.create(NumbersActivity.this, obj.getVoiceId());
                    //}
                  mediaPlayer.start();
                  //releasing the resources
                 mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                     @Override
                     public void onCompletion(MediaPlayer mp) {
                         mediaPlayer.release();
                         mediaPlayer = null;
                     }
                 });
              }
              catch (NullPointerException ne){
                  Log.v("NumbersAvtivity","NPE");
              }
              catch(Exception e){
                  Log.v("NumbersActivity","Some fucking exception");
              }
          }
      });

        //********

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}