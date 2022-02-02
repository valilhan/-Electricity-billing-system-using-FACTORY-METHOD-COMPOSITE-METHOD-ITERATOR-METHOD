package com.company.consumer;

public class ResidentialConsumer extends Consumer{

    public ResidentialConsumer(){
        super();
    }

    public ResidentialConsumer(Account acc){
        super(acc);
    }

    public float getPricePerKWh(){
        return (float) 0.93;
    }
}
