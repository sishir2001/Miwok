package com.sishir.miwok;
/*
* @linkview represents a vocablary for one who want to learn miwok language
* contains one miwok translation and default translation*/

public class Word {
     private String MiwokWord;
     private String DefaultWord;
     private static final int NO_IMG_ASSIGNED = -1;
    private int imgId = NO_IMG_ASSIGNED;
    private static final int NO_VOICE_ASSIGNED = -1;
    private int voiceId = NO_VOICE_ASSIGNED;
    // below constructor for phrases activity
    public Word(String MiwokWord,String DefaultWord,int voiceId){
        this(MiwokWord,DefaultWord,NO_IMG_ASSIGNED,voiceId);
    }
    // below constructor for rest of the activities
    public Word(String imgMiwokWord,String imgDefaultWord,int imgId,int voiceId){
        this.DefaultWord = imgDefaultWord;
        this.MiwokWord = imgMiwokWord;
        this.imgId = imgId;
        this.voiceId = voiceId;
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
    public boolean checkVoiceAssigned(){
        return voiceId != NO_VOICE_ASSIGNED;
    }
    public int getVoiceId(){
        return voiceId;
    }
    @Override
    public String toString(){
        return "Word { " + MiwokWord + " " + DefaultWord +" "+ imgId + " " +voiceId +"} ";
    }
}
