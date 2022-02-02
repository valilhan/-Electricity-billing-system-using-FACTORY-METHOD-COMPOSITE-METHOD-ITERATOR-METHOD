package com.company.factory;

import com.company.consumer.Consumer;

public abstract class ConsumerFactory {
    private final Consumers consumers = new Consumers();
    public abstract Consumer createConsumer();
    public void addConsumer(Consumer cns){
        consumers.push(cns);
    }

    public Consumers.ConsumerListIterator getIterator(){
        return consumers.createIterator();
    }

    public int getSize(){
        return consumers.getSize();
    }

}
