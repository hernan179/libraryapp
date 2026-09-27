package com.library.app.service.impl;

import com.library.app.domain.DetalleReserva;
import com.library.app.domain.Reserva;
import com.library.app.dto.EstadosEnum;
import com.library.app.repo.IGenericRepo;
import com.library.app.repo.IReservaRepo;
import com.library.app.service.IDetalleReservaCustom;
import com.library.app.service.IReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl extends CRUDImpl<Reserva, Long> implements IReservaService {

    private final IReservaRepo repo;

    private final IDetalleReservaCustom iDetalleReservaCustom;

    @Override
    protected IGenericRepo<Reserva, Long> getRepo() {
        return repo;
    }

    public void guardar(Reserva reserva){
        List<DetalleReserva> detalleReserva = reserva.getDetalleReserva();
        System.out.println("looking for details..."+detalleReserva);
        detalleReserva.forEach(a -> {
                    try {
                        DetalleReserva dr = DetalleReserva.builder()
                                .reserva(reserva)
                                .detalle("Sin cambios")
                                .fechaEvento(LocalDateTime.now())
                                .build();
                        iDetalleReservaCustom.save(dr);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }
        );
    }

    public void actualizar(Reserva reserva){
        try {
            List<DetalleReserva> detalleReserva = iDetalleReservaCustom.findByReserva(reserva);
            detalleReserva.forEach(a -> {
                if(reserva.getEstado().getNombre().equals(EstadosEnum.DEVUELTO.toString())){
                    a.setFechaEntrega(LocalDateTime.now());
                }
                a.setActualizacion(LocalDateTime.now());
                a.setDetalle("Fue actualizaado");
                iDetalleReservaCustom.save(a);
            });
        } catch (RuntimeException e) {
            System.out.println("error: " + e.getMessage());
        }

    }


}
