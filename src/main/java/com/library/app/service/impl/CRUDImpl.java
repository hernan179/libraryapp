package com.library.app.service.impl;

import com.library.app.exception.ModelNotFoundException;
import com.library.app.repo.IGenericRepo;
import com.library.app.service.ICRUD;

import java.lang.reflect.Method;
import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericRepo<T,ID> getRepo();

    @Override
    public T save(T entity) throws Exception {
        return getRepo().save(entity);
    }

    @Override
    public T update(ID id, T entiy) throws Exception {
        getRepo().findById(id).orElseThrow( ()-> new ModelNotFoundException("ID NOT FOUND: "+id));

        // implementar Java API refletion
        // set id to no include in the controller

        String className = entiy.getClass().getSimpleName();// name of any entity class (libro,categoria, etc...)
        String methodName = "setId"+ className;
        Method setIdMethod = entiy.getClass().getMethod(methodName,id.getClass());

       // Method setIdMethod = apiRegletion(id, entiy);
        setIdMethod.invoke(entiy,id);

        return getRepo().save(entiy);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("ID NOT FOUND: "+id));
    }

    @Override
    public void delete(ID id) throws Exception {
       getRepo().deleteById(id);
    }
}
