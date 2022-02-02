package com.company.bill;

public class MonthlyBill extends Bill {
    private final Month month;
    private final int year;

    public MonthlyBill(Month mn, int yr, float cns, float ttl) {
        year = yr;
        consumption = cns;
        total = ttl;
        month = mn;
    }

    public Month getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
