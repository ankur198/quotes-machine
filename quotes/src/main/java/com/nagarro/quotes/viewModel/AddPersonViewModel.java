package com.nagarro.quotes.viewModel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AddPersonViewModel
 */
public class AddPersonViewModel {

    private final String Name;

    public AddPersonViewModel(@JsonProperty("name") String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

}