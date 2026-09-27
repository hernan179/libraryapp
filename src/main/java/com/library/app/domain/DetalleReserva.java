package com.library.app.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity


@Table(name = "detalle_reserva")
public class DetalleReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleReserva;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_reserva", nullable = false)
    //@JsonBackReference
    //@JsonManagedReference
    private Reserva reserva;

    @Column(name = "fecha_evento", nullable = false)
    private LocalDateTime fechaEvento;

    @Column(name = "fecha_entrega")
    private LocalDateTime fechaEntrega;

    @Column(name = "actualizacion")
    private LocalDateTime actualizacion;

    @Column(name = "detalle")
    private String detalle;

   // @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "id_estado",nullable = false)
   // private Estado estado;
}