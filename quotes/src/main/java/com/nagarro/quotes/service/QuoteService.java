package com.nagarro.quotes.service;

import java.util.List;
import java.util.stream.Collectors;

import com.nagarro.quotes.dao.IBaseDao;
import com.nagarro.quotes.model.Person;
import com.nagarro.quotes.model.Quote;
import com.nagarro.quotes.viewModel.AddQuoteViewModel;
import com.nagarro.quotes.viewModel.QuotesDisplayViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * QuoteService
 */
@Service
public class QuoteService {

    private final IBaseDao<Quote> QuoteDao;

    private final IBaseDao<Person> PersonDao;

    @Autowired
    public QuoteService(@Qualifier("linkedList") final IBaseDao<Quote> QuoteDao,
            @Qualifier("arrayList") final IBaseDao<Person> PersonDao) {
        this.QuoteDao = QuoteDao;
        this.PersonDao = PersonDao;
    }

    public List<QuotesDisplayViewModel> GetAllQuotes() {
        var result = QuoteDao.GetAll().stream().map(q -> {
            var quote = new QuotesDisplayViewModel(q.getId(), q.getQuote(), q.getPerson().getName());
            return quote;
        }).collect(Collectors.toList());
        return result;
    }

    public void AddQuote(AddQuoteViewModel vm) {
        var person = PersonDao.GetById(vm.getPersonId());
        if (person.isPresent()) {
            QuoteDao.Insert(new Quote(vm.getQuote(), person.get()));
        }
    }
}