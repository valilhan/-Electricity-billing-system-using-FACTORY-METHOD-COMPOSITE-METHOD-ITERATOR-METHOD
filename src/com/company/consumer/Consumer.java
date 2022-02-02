package com.company.consumer;

import com.company.bill.BillCollection;

public class Consumer extends Counter{
    private Account account;
    public BillCollection unpaidBills = new BillCollection();
    public BillCollection paidBills = new BillCollection();

    public Consumer(){
        account = null;
    }

    public Consumer(Account acc) {
        account = acc;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account acc) {
        account = acc;
    }

    public float getPricePerKWh(){
        return 1;
    }
}
