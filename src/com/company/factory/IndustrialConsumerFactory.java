package com.company.factory;

import com.company.consumer.Consumer;
import com.company.consumer.IndustrialConsumer;

public class IndustrialConsumerFactory extends ConsumerFactory{
    @Override
    public Consumer createConsumer() {
        return new IndustrialConsumer();
    }
}
