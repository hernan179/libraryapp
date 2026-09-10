package com.library.app.service;

import java.lang.reflect.Method;
import java.util.List;
public interface ICRUD<T,ID> {
    T save(T entity) throws  Exception;

    T update(ID id,T entiy) throws  Exception;

    List<T> findAll() throws Exception;

    T findById(ID id) throws Exception;

    void delete(ID id) throws Exception;

    /*default Method apiRegletion(ID id, T entiy) throws Exception {
        String className = entiy.getClass().getSimpleName();// name of any entity class (libro,categoria, etc...)
        String methodName = "setId"+ className;
        Method setIdMethod = entiy.getClass().getMethod(methodName,id.getClass());
        return setIdMethod;
    }*/
}
