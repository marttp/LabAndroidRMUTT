package com.example.cryptorate;

import com.google.gson.annotations.SerializedName;

public class Cryptocurrency {

    @SerializedName("symbol")
    private String symbol;
    @SerializedName("name")
    private String name;
    @SerializedName("rank")
    private int rank;
    @SerializedName("price")
    private String price;

    public Cryptocurrency(String symbol, String name, int rank, String price) {
        this.symbol = symbol;
        this.name = name;
        this.rank = rank;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
