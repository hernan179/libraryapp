package com.library.app.service;

import com.library.app.domain.Cliente;
import com.library.app.domain.DetalleReserva;
import com.library.app.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservaCustom extends JpaRepository<DetalleReserva,Long> {
    @Query("select dr from DetalleReserva dr where dr.reserva = :reserva")
    List<DetalleReserva> findByReserva(Reserva reserva);


    @Query("select r from Reserva r where r.cliente = :cliente")
    List<Reserva> findByCliente(Cliente cliente);

}
