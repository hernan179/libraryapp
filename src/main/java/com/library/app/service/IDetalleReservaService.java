package com.library.app.service;

import com.library.app.domain.Categoria;
import com.library.app.domain.DetalleReserva;
import com.library.app.domain.Reserva;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDetalleReservaService extends ICRUD<DetalleReserva, Long> {

}
