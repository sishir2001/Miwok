package com.sishir.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mcolorResourceId;
    public WordAdapter(Context context, ArrayList<Word> imageList,int colorResourceId){
        super(context,0,imageList);
        mcolorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View imageListView = convertView;
        if(imageListView == null){
            imageListView = LayoutInflater.from(getContext()).inflate(R.layout.list_view,parent,false);
        }
        Word obj = getItem(position);
        TextView imgMiwokWord = (TextView) imageListView.findViewById(R.id.imagemiwok_txtView);
        imgMiwokWord.setText(obj.getMiwokTranslation());

        TextView imgDefaultWord = (TextView) imageListView.findViewById(R.id.imageenglish_txtView);
        imgDefaultWord.setText(obj.getDefaultTranslation());
        ImageView imgImage = (ImageView) imageListView.findViewById(R.id.imageImageview);
        if(obj.checkImgAssigned()){
            imgImage.setImageResource(obj.getImgId());
            imgImage.setVisibility(View.VISIBLE);
        }
        else{
            imgImage.setVisibility(View.GONE);
        }
        /*
        setting the background color
         */
        View container = imageListView.findViewById(R.id.LinearLayoutListview);
        int color = ContextCompat.getColor(getContext(),mcolorResourceId);// this is required for the context, specification of which activity.getColor is an static method of the ContextCompact class
        container.setBackgroundColor(color);
        View container2 = imageListView.findViewById(R.id.imgPlay);
        container2.setBackgroundColor(color);
        return imageListView;
    }

}
