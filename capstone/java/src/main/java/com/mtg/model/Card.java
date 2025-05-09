package com.mtg.model;

public class Card {

    private String id;
    private String name;
    private String imageUrl;
    private String setCode;
    private String rarity;
    private Double marketValue;

    public Card(String id, String name, String imageUrl, String setCode, String rarity) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.setCode = setCode;
        this.rarity = rarity;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSetCode() {
        return setCode;
    }

    public void setSetCode(String setCode) {
        this.setCode = setCode;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public Double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Double marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", setCode='" + setCode + '\'' +
                ", rarity='" + rarity + '\'' +
                ", marketValue=" + marketValue +
                '}';
    }

}
