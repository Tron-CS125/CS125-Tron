package com.example.tron;

import android.media.MediaPlayer;

public class GlobalMusicVariables {
    private static GlobalMusicVariables instance;

    private MediaPlayer data;

    // Restrict the constructor from being instantiated
    private GlobalMusicVariables(){}

    public void setData(MediaPlayer inputData){
        this.data = inputData;
    }
    public MediaPlayer getData(){
        return this.data;
    }

    public static synchronized GlobalMusicVariables getInstance(){
        if(instance==null){
            instance=new GlobalMusicVariables();
        }
        return instance;
    }
}
