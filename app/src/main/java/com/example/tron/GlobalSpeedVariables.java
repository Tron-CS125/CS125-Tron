package com.example.tron;

public class GlobalSpeedVariables {
    private static GlobalSpeedVariables instance;
    // Slow = 225;
    // Normal = 150;
    // Fast = 75;

    private int data;

    // Restrict the constructor from being instantiated
    private GlobalSpeedVariables(){}

    public void setData(int inputData){
        this.data = inputData;
    }
    public int getData(){
        return this.data;
    }

    public static synchronized GlobalSpeedVariables getInstance(){
        if(instance==null){
            instance=new GlobalSpeedVariables();
        }
        return instance;
    }
}