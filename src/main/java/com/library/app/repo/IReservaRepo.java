package com.library.app.repo;

import com.library.app.domain.DetalleReserva;
import com.library.app.domain.Reserva;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservaRepo extends IGenericRepo<Reserva, Long> {



}
