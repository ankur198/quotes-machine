package com.nagarro.quotes.viewModel;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AddQuoteViewModel
 */
public class AddQuoteViewModel {

    private final UUID PersonId;

    private final String Quote;

    public AddQuoteViewModel(@JsonProperty("id") UUID PersonId, @JsonProperty("quote") String Quote) {
        this.PersonId = PersonId;
        this.Quote = Quote;
    }

    public UUID getPersonId() {
        return PersonId;
    }

    public String getQuote() {
        return Quote;
    }
}