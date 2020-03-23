package com.nagarro.quotes.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.nagarro.quotes.model.BaseModel;

import org.springframework.stereotype.Repository;

/**
 * InMemoryDao
 */
@Repository("linkedList")
public class InMemoryLinkedListDao<E extends BaseModel> implements IBaseDao<E> {

    private List<E> DB = new LinkedList<>();

    @Override
    public List<E> GetAll() {
        return DB;
    }

    @Override
    public Optional<E> GetById(UUID id) {
        return DB.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    @Override
    public int Insert(E entity) {
        DB.add(entity);
        return DB.size() - 1;
    }

    @Override
    public boolean UpdateById(E newEntity) {

        UUID id = newEntity.getId();

        var entityMaybe = GetById(id);

        if (entityMaybe.isEmpty()) {
            return false;
        }

        return entityMaybe.map(e -> {
            var index = DB.indexOf(e);
            if (index > -1) {
                DB.set(index, newEntity);
                return true;
            }
            return false;
        }).orElse(false);

    }

    @Override
    public boolean DeleteById(UUID id) {

        var entityMaybe = GetById(id);

        if (entityMaybe.isEmpty()) {
            return false;
        }

        DB.remove(entityMaybe.get());
        return true;
    }

}