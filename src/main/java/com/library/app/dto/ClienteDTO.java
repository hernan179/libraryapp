package com.library.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.library.app.domain.Reserva;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDTO {

    private Long idCliente;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(nullable = false, unique = true, length = 30)
    private String cedula;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @JsonManagedReference
    private List<ReservaDTO> reservas;

}
