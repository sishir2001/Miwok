package com.sishir.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        // ***** numbers in word arraylist******
        ArrayList<Word> strFamily = new ArrayList<Word>();
        strFamily.add(new Word("әpә","father",R.drawable.family_father,R.raw.family_father));
        strFamily.add(new Word("әṭa","mother",R.drawable.family_mother,R.raw.family_mother));
        strFamily.add(new Word("angsi","son",R.drawable.family_son,R.raw.family_son));
        strFamily.add(new Word("tune","daughter",R.drawable.family_daughter,R.raw.family_daughter));
        strFamily.add(new Word("taachi","older brother",R.drawable.family_older_brother,R.raw.family_older_brother));
        strFamily.add(new Word("chalitti","younger brother",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        strFamily.add(new Word("teṭe","older sister",R.drawable.family_older_sister,R.raw.family_older_sister));
        strFamily.add(new Word("kolliti","younger sister",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        strFamily.add(new Word("ama","grandmother",R.drawable.family_grandmother,R.raw.family_grandmother));
        strFamily.add(new Word("paapa","grandfather",R.drawable.family_grandfather,R.raw.family_grandfather));
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
                    // TODO implement the audio focus.
                    //    create a onAudioFocusChangeListener
                    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
                        @Override
                        public void onAudioFocusChange(int focusChange) {
                            if(focusChange == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT){
                                // play the audio.
                                if(mediaPlayer == null){
                                    mediaPlayer = MediaPlayer.create(FamilyActivity.this,obj.getVoiceId());
                                }
                                mediaPlayer.start();
                                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        mediaPlayer.release();
                                        mediaPlayer = null;
                                    }
                                });
                            }
                            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                                // stop the music and release the resources
                                if(mediaPlayer != null){
                                    mediaPlayer.release();
                                    mediaPlayer = null;
                                }

                            }
                            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK ){
                                // pause the music.
                                mediaPlayer.pause();
                            }
                        }

                    };
                    AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                    int audioReq = audioManager.requestAudioFocus(afChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    // checking the audio request.
                    if(audioReq == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                        // play the music
                        //writing the current state of the object
                        Log.v("FamilyActivity","Current Word "+ obj);
                        // releasing the mediaplayer so that user can change the voice notes.
                        if(mediaPlayer != null){
                            mediaPlayer.release();
                            mediaPlayer = null;
                        }

                        //if(mediaPlayer == null) {
                        mediaPlayer = MediaPlayer.create(FamilyActivity.this, obj.getVoiceId());
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
                    else if(audioReq == AudioManager.AUDIOFOCUS_REQUEST_FAILED){
                        // do not play the music.
                        Toast.makeText(FamilyActivity.this,"AudioFocus not granted",Toast.LENGTH_SHORT).show();
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
    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}