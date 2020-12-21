package com.example.customlistview;

public class Products {

    private String title;
    private  String description;
    private String type;
    private Double price;
    private boolean sale;

    public Products(String title, String description, String type, Double price, boolean sale) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.price = price;
        this.sale = sale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean getSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }
}
