package com.nagarro.quotes.model;

import java.util.UUID;

/**
 * BaseModel
 */
public abstract class BaseModel {

    private final UUID Id;

    protected BaseModel(UUID id) {
        this.Id = id;
    }

    public UUID getId() {
        return this.Id;
    }
}