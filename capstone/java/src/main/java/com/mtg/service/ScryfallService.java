package com.mtg.service;

import com.mtg.model.Card;
import com.mtg.model.ScryfallCardList; // Import the new class
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.ParameterizedTypeReference; // No longer needed for the top level
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.List;
import java.nio.charset.StandardCharsets;

@Service
public class ScryfallService {

    private static final String API_BASE_URL = "https://api.scryfall.com";

    private final RestClient restClient;

    @Autowired
    public ScryfallService(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<Card> getCardsBySet(String setCode) {
        String url = API_BASE_URL + "/cards/search?q=e:" + setCode + "&unique=prints&order=set";

        try {
            // Deserialize into the ScryfallCardList container
            ScryfallCardList cardListResponse = restClient.get()
                    .uri(url)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                            (request, response) -> {
                                try {
                                    byte[] bodyBytes = response.getBody().readAllBytes();
                                    throw new RestClientResponseException(
                                            "Error fetching cards from Scryfall API",
                                            response.getStatusCode().value(),
                                            response.getStatusText(),
                                            response.getHeaders(),
                                            bodyBytes,
                                            StandardCharsets.UTF_8
                                    );
                                } catch (IOException e) {
                                    throw new RestClientResponseException(
                                            "Error fetching cards from Scryfall API (failed to read body)",
                                            response.getStatusCode().value(),
                                            response.getStatusText(),
                                            response.getHeaders(),
                                            null,
                                            null
                                    );
                                }
                            })
                    // Change the target type to the new container class
                    .body(ScryfallCardList.class); // No ParameterizedTypeReference needed here

            // Return the list of cards from the 'data' field
            return cardListResponse.getData();

        } catch (RestClientResponseException e) {
            System.err.println("Scryfall API Error: " + e.getRawStatusCode() + " - " + e.getResponseBodyAsString());
            throw e;
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            throw new RuntimeException("Failed to fetch cards from Scryfall", e);
        }
    }
}