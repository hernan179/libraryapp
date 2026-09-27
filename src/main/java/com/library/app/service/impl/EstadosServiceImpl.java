package com.library.app.service.impl;

import com.library.app.domain.Estado;
import com.library.app.repo.IEstadosRepo;
import com.library.app.repo.IGenericRepo;
import com.library.app.service.IEstadosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstadosServiceImpl extends  CRUDImpl<Estado,Long> implements IEstadosService {
    private final IEstadosRepo repo;
    @Override
    protected IGenericRepo<Estado, Long> getRepo() {
        return repo;
    }
}
