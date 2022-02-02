package com.company.consumer;

public class CommercialConsumer extends Consumer{

    public CommercialConsumer(){
        super();
    }

    public CommercialConsumer(Account acc) {
        super(acc);
    }

    public float getPricePerKWh(){
        return (float) 0.61;
    }
}
