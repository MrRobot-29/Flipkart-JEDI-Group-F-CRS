package com.flipkart.bean;

import java.util.ArrayList;

public class PaymentReciept {
    private ArrayList<String> crs;

    private String billDue;

    private PaymentNotification pn;

    public PaymentReciept() {
    }

    public PaymentReciept(ArrayList<String> crs, String billDue, PaymentNotification pn) {
        this.crs = crs;
        this.billDue = billDue;
        this.pn = pn;
    }

    public ArrayList<String> getCrs() {
        return crs;
    }

    public void setCrs(ArrayList<String> crs) {
        this.crs = crs;
    }


    public String getBillDue() {
        return billDue;
    }

    public void setBillDue(String billDue) {
        this.billDue = billDue;
    }

    public PaymentNotification getPn() {
        return pn;
    }

    public void setPn(PaymentNotification pn) {
        this.pn = pn;
    }
}
