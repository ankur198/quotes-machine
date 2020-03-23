package com.nagarro.quotes.api;

import java.util.List;

import com.nagarro.quotes.model.Person;
import com.nagarro.quotes.service.PersonService;
import com.nagarro.quotes.service.QuoteService;
import com.nagarro.quotes.viewModel.AddPersonViewModel;
import com.nagarro.quotes.viewModel.AddQuoteViewModel;
import com.nagarro.quotes.viewModel.QuotesDisplayViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * helloWorldController
 */
@RequestMapping()
@RestController()
public class HelloWorldController {

    private QuoteService quoteService;
    private PersonService personService;

    @Autowired
    public HelloWorldController(QuoteService quoteService, PersonService personService) {
        this.quoteService = quoteService;
        this.personService = personService;
    }

    @GetMapping()
    public List<QuotesDisplayViewModel> hello() {
        return quoteService.GetAllQuotes();
    }

    @PostMapping()
    public AddQuoteViewModel postMethodName(@RequestBody AddQuoteViewModel entity) {
        quoteService.AddQuote(entity);
        return entity;
    }

    @GetMapping("person")
    public List<Person> GetAllPerson() {
        return personService.GetAll();
        // return null;
    }

    @PostMapping("person")
    public void AddPerson(@RequestBody AddPersonViewModel vm) {
        personService.Insert(vm);
    }

}