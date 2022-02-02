package com.company.consumer;

import com.company.bill.BillCollection;

public class IndustrialConsumer extends Consumer{

    public IndustrialConsumer(){
        super();
    }

    public IndustrialConsumer(Account acc) {
        super(acc);
    }

    public float getPricePerKWh(){
        return (float) 0.25;
    }
}
