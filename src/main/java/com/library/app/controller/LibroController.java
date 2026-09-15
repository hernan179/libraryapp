package com.library.app.controller;

import com.library.app.domain.Categoria;
import com.library.app.domain.Libro;
import com.library.app.dto.LibroDTO;
import com.library.app.service.ICategoriaService;
import com.library.app.service.ILibroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/libros")
@RequiredArgsConstructor
public class LibroController {

    private final ILibroService service;
    private final ICategoriaService categoriaService;

    //@Qualifier("libroMapper")
    private final ModelMapper libroMapper;


    @GetMapping
    public ResponseEntity<List<LibroDTO>> findAll() throws Exception {
        List<LibroDTO> libros = service.findAll().stream().map(this::convertToDTO).toList();
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(convertToDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<LibroDTO> save(@Valid @RequestBody LibroDTO dto) throws Exception {

        System.out.println("GUARDANDO EL NUEVO LIBRO...METODO post: "+dto);

        Libro libroTransformed = convertToEntity(dto);

        System.out.println("GUARDANDO EL NUEVO LIBRO...METODO post_passed: "+libroTransformed);


        Libro libro = service.save(libroTransformed);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(libro.getIdLibro())
                .toUri();
        return ResponseEntity.created(location).body(convertToDTO(libro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroDTO> update(@PathVariable Long id, @Valid @RequestBody LibroDTO dto) throws Exception {

        Libro libro = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDTO(libro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Libro convertToEntity(LibroDTO dto) throws Exception {
        System.out.println("GUARDANDO EL NUEVO LIBRO.."+dto);


        Libro libro = libroMapper.map(dto, Libro.class);
        Categoria categoria =  Categoria.builder().idCategoria(dto.getCategoria().getId()).build();//categoriaService.findById(dto.getCategoria());
        libro.setCategoria(categoria);
        return libro;
    }

    private LibroDTO convertToDTO(Libro libro) {
        return libroMapper.map(libro, LibroDTO.class);
    }
}
