package com.library.app.controller;


import com.library.app.domain.Categoria;
import com.library.app.dto.CategoriaDTO;
import com.library.app.service.ICategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/categorias")
public class CategoriaController {

    private final ICategoriaService service;

    private final ModelMapper categoriaMapper;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() throws Exception{

     List<CategoriaDTO> list = service.findAll().stream().map(this::convertToDTO).toList();
     return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id) throws Exception{
        CategoriaDTO obj = convertToDTO(service.findById(id));

        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> save(@Valid @RequestBody CategoriaDTO dto) throws  Exception{
        System.out.println("saving...");
        Categoria categoria = convertToEntity(dto);

        Categoria categoriaDb = service.save(categoria);
        CategoriaDTO catDTO = convertToDTO(categoriaDb);

        return new ResponseEntity<>(catDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @Valid @RequestBody CategoriaDTO dto ) throws  Exception{

        Categoria catogira = service.update(id,convertToEntity(dto));

        return ResponseEntity.ok(convertToDTO(catogira));
    }
@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
    service.delete(id);

    return ResponseEntity.noContent().build();
    }

    private Categoria convertToEntity(CategoriaDTO dto){
      return categoriaMapper.map(dto,Categoria.class);
    }

    private CategoriaDTO convertToDTO(Categoria obj){
        return categoriaMapper.map(obj,CategoriaDTO.class);
    }
}
