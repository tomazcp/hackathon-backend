package org.academiadecodigo.hackathon.persistence.dao;

/**
 * Created by codecadet on 13/12/2018.
 */
public interface Dao<T extends Model> {

    T findById(Integer id);

    T saveOrUpdate(T modelObject);

    void delete(Integer id);
}
