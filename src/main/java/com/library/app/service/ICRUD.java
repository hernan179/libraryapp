package com.library.app.service;

import java.lang.reflect.Method;
import java.util.List;
public interface ICRUD<T,ID> {
    T save(T entity) throws  Exception;

    T update(ID id,T entiy) throws  Exception;

    List<T> findAll() throws Exception;

    T findById(ID id) throws Exception;

    void delete(ID id) throws Exception;

}
