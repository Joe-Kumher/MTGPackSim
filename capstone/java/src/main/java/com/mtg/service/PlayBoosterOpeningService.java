package com.mtg.service;

import com.mtg.model.Card; // Import Card model
import com.mtg.model.ScryfallCardList; //  container class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@Service
public class PlayBoosterOpeningService {

    private final ScryfallService scryfallService;
    private final Random random;


    @Autowired
    public PlayBoosterOpeningService(ScryfallService scryfallService) {
        this.scryfallService = scryfallService;
        this.random = new Random();
    }


    public List<Card> openPlayBooster(String setCode) {
        // a list to hold the total number of cards
        List<Card> openedPack = new ArrayList<>(15);

        //temporary api list of cards. will switch to db soon

        List<Card> setCards;
        try {
            setCards = scryfallService.getCardsBySet(setCode);
        } catch (Exception e) {
            System.err.println("Error fetching cards for set " + setCode + ": " + e.getMessage());
            return openedPack;
        }

        if (setCards.isEmpty()) {
            System.err.println("No cards found for set code: " + setCode + ". Cannot open pack.");
            return openedPack;
        }

        //Slot #1-6 : Commons
        List<Card>


    }

    private List<Card> filterCardsByRarity(List<Card> cards, String rarity) {
        return cards.stream()
                .filter(card -> card.getRarity().equalsIgnoreCase(rarity))
                .collect(Collectors.toList());
    }

}

