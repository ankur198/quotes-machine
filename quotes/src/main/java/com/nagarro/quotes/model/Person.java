package com.nagarro.quotes.model;

import java.util.UUID;

public class Person extends BaseModel {

    private final String Name;

    public Person(String Name) {
        super(UUID.randomUUID());
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }
}
