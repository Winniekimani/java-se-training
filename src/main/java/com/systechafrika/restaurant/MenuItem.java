package com.systechafrika.restaurant;

public class MenuItem {

    private int itemId;
    private String itemName;
    private double itemPrice;

    public MenuItem(int itemId, String itemName, double itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    @Override
    public String toString() {
        return "MenuItem [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
    }

    // @Override
    // public String toString() {
    // return name + " - $" + price;
    // }
}
