package com.example.el;

public class SalesBean {

    private double q1, q2, q3, q4;

    public SalesBean(double q1Sales,
            double q2Sales,
            double q3Sales,
            double q4Sales) {
        q1 = q1Sales;
        q2 = q2Sales;
        q3 = q3Sales;
        q4 = q4Sales;
    }

    public double getQ1() {
        return (q1);
    }

    public double getQ2() {
        return (q2);
    }

    public double getQ3() {
        return (q3);
    }

    public double getQ4() {
        return (q4);
    }

    public double getTotal() {
        return (q1 + q2 + q3 + q4);
    }
}
