package com.library.app.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.library.app.domain.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LibroDTO {

    private Long idLibro;

    @NotBlank
    @Size(min = 1, max = 200)
    private String titulo;

    @NotBlank
    @Size(min = 1, max = 150)
    private String autor;

    @NotBlank
    @Size(min = 1, max = 20)
    private String isbn;

    @NotNull
    private Boolean disponible = true;

    @NotNull
    private CategoriaDTO categoria;
}
