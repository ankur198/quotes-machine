package com.nagarro.quotes.model;

import java.util.UUID;

/**
 * Quote
 */
public class Quote extends BaseModel {

    private final String Quote;

    private final Person Person;

    public Quote(String Quote, Person Person) {
        super(UUID.randomUUID());
        this.Quote = Quote;
        this.Person = Person;
    }

    public Person getPerson() {
        return Person;
    }

    public String getQuote() {
        return Quote;
    }

}