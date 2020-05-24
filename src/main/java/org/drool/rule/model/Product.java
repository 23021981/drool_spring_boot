package org.drool.rule.model;

public class Product {

    private String name;
    private String cardType;
    private double shoppingAmount;
    private double cashBackPercent;
    private double cashBackAmount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public double getShoppingAmount() {
        return shoppingAmount;
    }

    public void setShoppingAmount(double shoppingAmount) {
        this.shoppingAmount = shoppingAmount;
    }

    public double getCashBackPercent() {
        return cashBackPercent;
    }

    public void setCashBackPercent(double cashBackPercent) {
        this.cashBackPercent = cashBackPercent;
    }

    public double getCashBackAmount() {
        return cashBackAmount;
    }

    public void setCashBackAmount(double cashBackAmount) {
        this.cashBackAmount = cashBackAmount;
    }
}
