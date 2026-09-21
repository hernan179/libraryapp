package com.library.app.service.impl;

import com.library.app.domain.Cliente;

import com.library.app.repo.IClienteRepo;
import com.library.app.repo.IGenericRepo;

import com.library.app.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl extends  CRUDImpl<Cliente,Long> implements IClienteService {

    private final IClienteRepo repo;

    @Override
    protected IGenericRepo<Cliente, Long> getRepo() {
        return repo;
    }

}
