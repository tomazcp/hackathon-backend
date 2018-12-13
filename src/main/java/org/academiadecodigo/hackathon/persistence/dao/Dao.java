package org.academiadecodigo.hackathon.persistence.dao;

import org.academiadecodigo.hackathon.persistence.model.Model;

import java.util.List;

public interface Dao<T extends Model> {

    T findById(Integer id);

    T saveOrUpdate(T modelObject);

    void delete(Integer id);

    List<T> findAll();
}
