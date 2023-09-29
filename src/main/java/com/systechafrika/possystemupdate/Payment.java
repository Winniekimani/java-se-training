package com.systechafrika.possystemupdate;

public class Payment {
    private int id;
    private double totalAmount;
    private double amountGiven;
    private double changeAmount;

    public Payment(int id, double totalAmount, double amountGiven, double changeAmount) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.amountGiven = amountGiven;
        this.changeAmount = changeAmount;
    }

    public Payment(double totalAmount, double amountGiven, double changeAmount) {
        this.totalAmount = totalAmount;
        this.amountGiven = amountGiven;
        this.changeAmount = changeAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getAmountGiven() {
        return amountGiven;
    }

    public void setAmountGiven(double amountGiven) {
        this.amountGiven = amountGiven;
    }

    public double getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(double changeAmount) {
        this.changeAmount = changeAmount;
    }

    @Override
    public String toString() {
        return "Payment [id=" + id + ", totalAmount=" + totalAmount + ", amountGiven=" + amountGiven + ", changeAmount="
                + changeAmount + "]";
    }

}