package com.sishir.miwok;
/*
* @linkview represents a vocablary for one who want to learn miwok language
* contains one miwok translation and default translation*/

public class Word {
     private String MiwokWord;
     private String DefaultWord;
     private static final int NO_IMG_ASSIGNED = -1;
    private int imgId = NO_IMG_ASSIGNED;
    public Word(String MiwokWord,String DefaultWord){
        this.DefaultWord = DefaultWord;
        this.MiwokWord = MiwokWord;
    }
    public Word(String imgMiwokWord,String imgDefaultWord,int imgId){
        this.DefaultWord = imgDefaultWord;
        this.MiwokWord = imgMiwokWord;
        this.imgId = imgId;
    }
    public String getDefaultTranslation(){
        return DefaultWord;
    }
    public String getMiwokTranslation(){
        return MiwokWord;
    }
    public int getImgId(){ return imgId; }
    public boolean checkImgAssigned(){
        return imgId != NO_IMG_ASSIGNED;
    }

}
