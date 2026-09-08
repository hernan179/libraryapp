package com.library.app.controller;


import com.library.app.domain.Categoria;
import com.library.app.dto.CategoriaDTO;
import com.library.app.service.ICategoriaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("v1/categorias")
public class CategoriaController {
    @Autowired
    private ICategoriaService service;
    @Autowired
    private final ModelMapper mapper;

    @GetMapping("/all")
    public ResponseEntity<List<CategoriaDTO>> findAll() throws Exception{

     List<CategoriaDTO> list = service.findAll().stream().map(this::convertDTO).toList();
     return ResponseEntity.ok(list);
    }
    private CategoriaDTO convertDTO(Categoria obj){
        return mapper.map(obj,CategoriaDTO.class);
    }
}
