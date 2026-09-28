package com.library.app.service;

import com.library.app.domain.Cliente;
import com.library.app.domain.Reserva;

import java.util.List;

public interface IReservaService extends ICRUD<Reserva, Long> {

    public void actualizar(Reserva reserva);

    public void guardar(Reserva reserva);


    public List<Reserva> reservadelcliente(Cliente cliente);
}
