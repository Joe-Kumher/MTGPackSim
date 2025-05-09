package com.mtg; // Adjust package as needed

import com.mtg.model.Card;
import com.mtg.service.ScryfallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;

import java.util.List;

@Component // Marks this class as a Spring component
public class ScryfallApiTestRunner implements CommandLineRunner {

    private final ScryfallService scryfallService;

    @Autowired
    public ScryfallApiTestRunner(ScryfallService scryfallService) {
        this.scryfallService = scryfallService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------------------------------------");
        System.out.println("Testing ScryfallService...");
        System.out.println("--------------------------------------");

        String setCodeToTest = "ONE"; // Replace with a set code you want to test (e.g., "LTR", "MKM")

        try {
            List<Card> cards = scryfallService.getCardsBySet(setCodeToTest);

            if (cards.isEmpty()) {
                System.out.println("No cards found for set code: " + setCodeToTest);
            } else {
                System.out.println("Successfully fetched " + cards.size() + " cards for set code: " + setCodeToTest);
                System.out.println("Listing first 10 cards:");
                for (int i = 0; i < Math.min(cards.size(), 10); i++) {
                    Card card = cards.get(i);
                    System.out.println(" - " + card.getName() + " (" + card.getRarity() + ")");
                    // You can print more details if you like, e.g., card.getImageUrl()
                }
            }

        } catch (RestClientResponseException e) {
            System.err.println("Error calling Scryfall API: " + e.getRawStatusCode() + " - " + e.getStatusText());
            System.err.println("Response Body: " + e.getResponseBodyAsString());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred during API test: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for debugging
        }

        System.out.println("--------------------------------------");
        System.out.println("ScryfallService test finished.");
        System.out.println("--------------------------------------");
    }
}