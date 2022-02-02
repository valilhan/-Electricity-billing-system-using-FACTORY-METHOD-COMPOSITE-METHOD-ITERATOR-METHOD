package com.company.bill;

import com.company.iterator.Iterator;

import java.util.ArrayList;
import java.util.List;

public class BillCollection {
    private List<Bill> bills = new ArrayList<>();

    public void push(Bill bill){
        bills.add(bill);
    }

    public Bill pop(BillListIterator it){
        var element = bills.get(it.getIndex());
        bills.remove(it.getIndex());
        return element;
    }

    public int getSize(){
        return bills.size();
    }

    public BillListIterator createIterator(){
        return new BillListIterator(this);
    }

    public class BillListIterator implements Iterator<Bill> {
        private final BillCollection collection;
        private int index;

        public BillListIterator(BillCollection bills) {
            collection = bills;
        }

        public int getIndex(){
            return index;
        }

        @Override
        public void next() {
            index++;
        }

        @Override
        public Bill current() {
            return collection.bills.get(index);
        }

        @Override
        public boolean isValid() {
            return (index< collection.getSize());
        }

        @Override
        public boolean isLast() {
            return (index == collection.getSize() - 1);
        }
    }
}
