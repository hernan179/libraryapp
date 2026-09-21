package com.library.app.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String nombre;

    private String descripcion;

    @NotNull
    private Boolean estado = true;
    @JsonBackReference
    private List<LibroDTO> libros;
}
