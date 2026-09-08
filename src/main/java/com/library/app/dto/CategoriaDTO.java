package com.library.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {


    private Integer id;

    @NotNull
    @Size(min = 1, max = 100)
    private String nombre;

    private String descripcion;

    private Boolean estado = true;
}
