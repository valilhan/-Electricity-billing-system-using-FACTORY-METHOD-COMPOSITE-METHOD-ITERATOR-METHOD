package com.company.factory;

import com.company.consumer.Consumer;
import com.company.consumer.ResidentialConsumer;

public class ResidentialConsumerFactory extends ConsumerFactory{
    @Override
    public Consumer createConsumer() {
        return new ResidentialConsumer();
    }
}
