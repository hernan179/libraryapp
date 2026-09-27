package com.library.app.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.library.app.domain.Reserva;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetalleReservaDTO {


    private Long idDetalleReserva;

    @NotNull
    @JsonBackReference
    private ReservaDTO reserva;

    @NotNull
    private LocalDateTime fechaEvento;

    private LocalDateTime fechaEntrega;

    private LocalDateTime actualizacion;

    private String detalle;

}
