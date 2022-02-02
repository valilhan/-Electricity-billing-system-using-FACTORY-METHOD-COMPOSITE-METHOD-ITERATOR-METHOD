package com.company.bill;

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    private static Month[] vals = values();
    public Month next()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }
}
