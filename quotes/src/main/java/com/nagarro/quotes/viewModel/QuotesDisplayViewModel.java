package com.nagarro.quotes.viewModel;

import java.util.UUID;

/**
 * QuotesDisplayViewModel
 */
public class QuotesDisplayViewModel {

    private final UUID Id;

    private final String Quote;

    private final String Author;

    public QuotesDisplayViewModel(UUID Id, String Quote, String Author) {
        this.Id = Id;
        this.Quote = Quote;
        this.Author = Author;
    }

    public String getAuthor() {
        return Author;
    }

    public String getQuote() {
        return Quote;
    }

    public UUID getId() {
        return Id;
    }
}