package com.company.factory;

import com.company.consumer.Consumer;
import com.company.iterator.Iterator;

import java.util.ArrayList;
import java.util.List;

public class Consumers {
    private final List<Consumer> consumers = new ArrayList<>();

    public void push(Consumer cns){
        consumers.add(cns);
    }

    public Consumer pop(ConsumerListIterator it){
        var element = consumers.get(it.getIndex());
        consumers.remove(it.getIndex());
        return element;
    }

    public int getSize(){
        return consumers.size();
    }

    public ConsumerListIterator createIterator(){
        return new ConsumerListIterator(this);
    }

    public class ConsumerListIterator implements Iterator<Consumer> {
        private final Consumers collection;
        private int index;

        public ConsumerListIterator(Consumers cnss) {
            collection = cnss;
        }

        public int getIndex(){
            return index;
        }

        @Override
        public void next() {
            index++;
        }

        @Override
        public Consumer current() {
            return collection.consumers.get(index);
        }

        @Override
        public boolean isValid() {
            return (index < collection.getSize() );
        }

        @Override
        public boolean isLast() {
            return (index == collection.getSize()-1);
        }
    }
}
