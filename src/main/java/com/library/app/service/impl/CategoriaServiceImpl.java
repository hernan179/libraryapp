package com.library.app.service.impl;

import com.library.app.domain.Categoria;
import com.library.app.repo.ICategoriaRepo;
import com.library.app.repo.IGenericRepo;
import com.library.app.service.ICategoriaService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl extends  CRUDImpl<Categoria,Long> implements ICategoriaService {
    private final ICategoriaRepo repo;
    @Override
    protected IGenericRepo<Categoria, Long> getRepo() {
        return repo;
    }
}
