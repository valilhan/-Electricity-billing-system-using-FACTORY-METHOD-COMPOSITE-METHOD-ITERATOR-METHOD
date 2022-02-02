package com.company.factory;

import com.company.consumer.CommercialConsumer;
import com.company.consumer.Consumer;

public class CommercialConsumerFactory extends ConsumerFactory{
    @Override
    public Consumer createConsumer() {
        return new CommercialConsumer();
    }
}
