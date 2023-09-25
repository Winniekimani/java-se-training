package com.systechafrika.pos.jdbc;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private String description;
    private String category;

    public Product(int productId, String productName, double price, String description, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public Product(String productName, double price, String description, String category) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public Product(String name, Double price2, String description2, String category2) {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
