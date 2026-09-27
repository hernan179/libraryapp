package com.library.app.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.library.app.domain.Categoria;
import com.library.app.domain.Reserva;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LibroDTO {

    @NotNull
    private Long idLibro;

    @NotNull
    private String titulo;

    @NotNull
    private String autor;

    @NotNull
    private String isbn;

    @NotNull
    private Boolean disponible = true;

    @NotNull
    private CategoriaDTO categoria;


    @JsonBackReference
    private List<ReservaDTO> reserva;

}
