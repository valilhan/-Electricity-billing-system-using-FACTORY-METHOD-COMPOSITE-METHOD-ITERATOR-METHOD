package com.company.bill;

public class YearlyBill extends Bill {
    private final BillCollection bills = new BillCollection();
    private int year;

    public YearlyBill( int yr) {
        year = yr;
    }

    public void addNewBill(Bill bill){
        consumption += bill.getConsumption();
        total += bill.getTotal();
        bills.push(bill);
    }

    public int getYear() {
        return year;
    }
}
