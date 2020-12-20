package com.sishir.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //*********findviewbyid() *************
        TextView numbers = (TextView) findViewById(R.id.txtNumbers);
        TextView colors = (TextView) findViewById(R.id.txtColors);
        TextView familyMembers = (TextView) findViewById(R.id.txtFamilyMembers);
        TextView phrases = (TextView) findViewById(R.id.txtPhrases);
        //**************************************
        //*******************setting click listeners for all the text*********************
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
              //  intent.putExtra("numbers",numberStrArray);
                startActivity(intent);
                Toast.makeText(v.getContext(),"opening numbersActivity",Toast.LENGTH_SHORT).show();
            }
        });
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(intent);
                Toast.makeText(v.getContext(),"opening colors",Toast.LENGTH_SHORT).show();
            }
        });
        familyMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(intent);
                Toast.makeText(v.getContext(),"opening family members",Toast.LENGTH_SHORT).show();
            }
        });
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(intent);
                Toast.makeText(v.getContext(),"opening phrases",Toast.LENGTH_SHORT).show();
            }
        });
        // ****** DONE WITH THE clickListeners**************
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("MainActivity","onStart()");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.v("MainActivity","onResume()");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.v("MainActivity","onPause");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("MainActivity","onDestroy()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MainActivity","onStop()");
    }
}
