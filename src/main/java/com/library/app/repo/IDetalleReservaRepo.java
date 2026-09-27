package com.library.app.repo;

import com.library.app.domain.DetalleReserva;
import com.library.app.domain.Reserva;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleReservaRepo extends IGenericRepo<DetalleReserva, Long> {
}
