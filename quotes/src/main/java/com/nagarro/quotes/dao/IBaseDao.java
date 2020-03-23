package com.nagarro.quotes.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.nagarro.quotes.model.BaseModel;

/**
 * IBaseDao
 */
public interface IBaseDao<T extends BaseModel> {

    List<T> GetAll();

    Optional<T> GetById(UUID id);

    int Insert(T entity);

    boolean UpdateById(T newEntity);

    boolean DeleteById(UUID id);
}