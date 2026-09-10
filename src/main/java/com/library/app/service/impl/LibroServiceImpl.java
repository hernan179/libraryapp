package com.library.app.service.impl;

import com.library.app.domain.Libro;
import com.library.app.repo.IGenericRepo;
import com.library.app.repo.ILibroRepo;
import com.library.app.service.ILibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibroServiceImpl extends CRUDImpl<Libro, Long> implements ILibroService {

    private final ILibroRepo repo;

    @Override
    protected IGenericRepo<Libro, Long> getRepo() {
        return repo;
    }
}
