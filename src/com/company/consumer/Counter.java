package com.company.consumer;

public class Counter {
    private float consumption;

    public float getConsumption(){
        return consumption;
    }

    public void addConsumption(float val){
        if( val > 0 )
            consumption += val;
    }

    public void subtractConsumption(float val){
        if( val > 0 )
            consumption -= val;
    }

    public void nullifyConsumption(){
        consumption = 0;
    }
}
