package com.mtg.model; // You might want a separate package for API response models

import com.fasterxml.jackson.annotation.JsonProperty; // Needed for mapping snake_case JSON keys
import com.mtg.model.Card; // Import your Card model

import java.util.List;

// This class mirrors the structure of the Scryfall API's List object response
public class ScryfallCardList {

    private String object; // Should be "list"
    @JsonProperty("total_cards") // Map the JSON key "total_cards" to this field
    private int totalCards;
    @JsonProperty("has_more") // Map the JSON key "has_more" to this field
    private boolean hasMore;
    @JsonProperty("next_page") // Map the JSON key "next_page" to this field (can be null)
    private String nextPage;
    private List<Card> data; // This field will hold the list of Card objects

    // Getters and setters (or use Lombok if you have it set up)

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getTotalCards() {
        return totalCards;
    }

    public void setTotalCards(int totalCards) {
        this.totalCards = totalCards;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public List<Card> getData() {
        return data;
    }

    public void setData(List<Card> data) {
        this.data = data;
    }
}