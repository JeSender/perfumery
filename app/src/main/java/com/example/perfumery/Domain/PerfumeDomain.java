package com.example.perfumery.Domain;

public class PerfumeDomain {
    private String title;
    private String pic;
    private String description;
    private Double fee;
    private int star;
    private int time;
    private int numberInCart;

    public PerfumeDomain(String title, String pic, String description, Double fee, int star, int time) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
        this.star = star;
        this.time = time;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public String getTitle() {
        return title;
    }

    public String getPic() {
        return pic;
    }

    public String getDescription() {
        return description;
    }

    public Double getFee() {
        return fee;
    }

    public int getStar() {
        return star;
    }

    public int getTime() {
        return time;
    }
}
