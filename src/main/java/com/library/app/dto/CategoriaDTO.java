package com.library.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoriaDTO {

    private Integer id;

    @NotNull
    @Size(min = 1, max = 100)
    private String nombre;

    private String descripcion;

    @NotNull
    private Boolean estado = true;

    private List<LibroDTO> libros;
}
