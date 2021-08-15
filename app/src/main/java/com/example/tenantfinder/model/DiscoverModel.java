package com.example.tenantfinder.model;

public class DiscoverModel {
    String title,phone, price, imageUrl;

    public DiscoverModel() {
    }

    public DiscoverModel(String title, String phone, String price, String imageUrl) {
        this.title = title;
        this.phone = phone;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
