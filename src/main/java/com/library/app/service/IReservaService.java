package com.library.app.service;

import com.library.app.domain.Reserva;

public interface IReservaService extends ICRUD<Reserva, Long> {

    public void actualizar(Reserva reserva);

    public void guardar(Reserva reserva);
}
