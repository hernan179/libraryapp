package com.library.app.service.impl;

import com.library.app.domain.Categoria;
import com.library.app.domain.DetalleReserva;
import com.library.app.domain.Reserva;
import com.library.app.repo.IDetalleReservaRepo;
import com.library.app.repo.IGenericRepo;
import com.library.app.repo.IReservaRepo;
import com.library.app.service.IDetalleReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleReservaServiceImpl extends CRUDImpl<DetalleReserva, Long> implements IDetalleReservaService {

    private final IDetalleReservaRepo repo;

    @Override
    protected IGenericRepo<DetalleReserva, Long> getRepo() {
        return repo;
    }

}
