package com.nagarro.quotes.service;

import java.util.List;

import com.nagarro.quotes.dao.IBaseDao;
import com.nagarro.quotes.model.Person;
import com.nagarro.quotes.viewModel.AddPersonViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PersonService
 */
@Service
public class PersonService {

    private IBaseDao<Person> PersonDao;

    @Autowired
    public PersonService(IBaseDao<Person> personDao) {
        this.PersonDao = personDao;
    }

    public List<Person> GetAll() {
        return PersonDao.GetAll();
    }

    public void Insert(AddPersonViewModel vm) {
        PersonDao.Insert(new Person(vm.getName()));
    }

}