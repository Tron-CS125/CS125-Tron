package com.example.tron;

public class GlobalColorVariables {
    private static GlobalColorVariables instance;

    private int data;

    // Restrict the constructor from being instantiated
    private GlobalColorVariables(){}

    public void setData(int inputData){
        this.data = inputData;
    }
    public int getData(){
        return this.data;
    }

    public static synchronized GlobalColorVariables getInstance(){
        if(instance==null){
            instance=new GlobalColorVariables();
        }
        return instance;
    }
}
