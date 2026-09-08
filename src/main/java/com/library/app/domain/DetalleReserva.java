package com.library.app.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "detalle_reserva",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_detalle_reserva_libro",
            columnNames = {"reserva_id", "libro_id"}
        )
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;
}