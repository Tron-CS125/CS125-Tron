package com.example.tron;

public class GlobalArenaSizeVariables {
    private static GlobalArenaSizeVariables instance;
    //small = 15 x 15
    //normal = 23 x 23
    //large = 35 x 35

    private int data;

    // Restrict the constructor from being instantiated
    private GlobalArenaSizeVariables(){}

    public void setData(int inputData){
        this.data = inputData;
    }
    public int getData(){
        return this.data;
    }

    public static synchronized GlobalArenaSizeVariables getInstance(){
        if(instance==null){
            instance=new GlobalArenaSizeVariables();
        }
        return instance;
    }
}