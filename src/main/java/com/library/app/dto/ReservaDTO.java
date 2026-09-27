package com.library.app.dto;


import com.fasterxml.jackson.annotation.*;

import com.library.app.domain.Cliente;
import com.library.app.domain.DetalleReserva;
import com.library.app.domain.Estado;
import com.library.app.domain.Libro;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservaDTO {

    private Long idReserva;

    @NotNull
    private LocalDateTime fechaReserva;

    private LocalDateTime fechaDevolucion;

    @NotNull
    private ClienteDTO cliente;

    private List<DetalleReservaDTO> detalleReserva;

    @NotNull
    private EstadoDTO estado;
    @NotNull
    private LibroDTO libro;

}
