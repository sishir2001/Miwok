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

public class PhrasesActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        // ***** numbers in word arraylist******
        ArrayList<Word> strPhrases = new ArrayList<Word>();
        strPhrases.add(new Word("minto wuksus","Where are you going?",R.raw.phrase_where_are_you_going));
        strPhrases.add(new Word("tinnә oyaase'nә","What is your name?",R.raw.phrase_what_is_your_name));
        strPhrases.add(new Word("oyaaset...","My name is...",R.raw.phrase_my_name_is));
        strPhrases.add(new Word("michәksәs?","How are you feeling?",R.raw.phrase_how_are_you_feeling));
        strPhrases.add(new Word("kuchi achit","I’m feeling good.",R.raw.phrase_im_feeling_good));
        strPhrases.add(new Word("әәnәs'aa?","Are you coming?",R.raw.phrase_are_you_coming));
        strPhrases.add(new Word("hәә’ әәnәm","Yes, I’m coming.",R.raw.phrase_yes_im_coming));
        strPhrases.add(new Word("әәnәm","I’m coming.",R.raw.phrase_im_coming));
        strPhrases.add(new Word("yoowutis","Let’s go.",R.raw.phrase_lets_go));
        strPhrases.add(new Word("әnni'nem","Come here.",R.raw.phrase_come_here));
        // ******** added the numbers to ArrayList

        // creating the ArrayAdapter which converts the objects into views for Views that recycle views.
        // ArrayAdapter declaration, initialization and instatiation
        WordAdapter itemAdapter = new WordAdapter(this,strPhrases,R.color.aqua);// WordAdapter is a custom class adapter where it is customized to hold two textViews
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
                    Word obj = itemAdapter.getItem(position);
                    // TODO implement the audio focus.
                    //    create a onAudioFocusChangeListener
                    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
                        @Override
                        public void onAudioFocusChange(int focusChange) {
                            if(focusChange == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT){
                                // play the audio.
                                if(mediaPlayer == null){
                                    mediaPlayer = MediaPlayer.create(PhrasesActivity.this,obj.getVoiceId());
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
                        Log.v("PhrasesActivity","Current Word "+ obj);
                        // releasing the mediaplayer so that user can change the voice notes.
                        if(mediaPlayer != null){
                            mediaPlayer.release();
                            mediaPlayer = null;
                        }

                        //if(mediaPlayer == null) {
                        mediaPlayer = MediaPlayer.create(PhrasesActivity.this, obj.getVoiceId());
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
                        Toast.makeText(PhrasesActivity.this,"AudioFocus not granted",Toast.LENGTH_SHORT).show();
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
    protected void onStop(){
        super.onStop();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}