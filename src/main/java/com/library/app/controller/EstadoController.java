package com.library.app.controller;


import com.library.app.domain.Estado;
import com.library.app.dto.EstadoDTO;
import com.library.app.service.IEstadosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/estados")
public class EstadoController {

    private final IEstadosService service;

    //@Qualifier("categoriaMapper")
    //  private final ModelMapper categoriaMapper;

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> findAll() throws Exception{

        List<EstadoDTO> list = service.findAll().stream().map(this::convertToDTO).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> findById(@PathVariable Long id) throws Exception{
        EstadoDTO obj = convertToDTO(service.findById(id));

        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<EstadoDTO> save(@Valid @RequestBody EstadoDTO dto) throws  Exception{
        System.out.println("saving...");
        Estado estados = convertToEntity(dto);

        Estado estadosDb = service.save(estados);
        EstadoDTO estDTO = convertToDTO(estadosDb);

        return new ResponseEntity<>(estDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoDTO> update(@PathVariable Long id, @Valid @RequestBody EstadoDTO dto ) throws  Exception{

        Estado estados = service.update(id,convertToEntity(dto));

        return ResponseEntity.ok(convertToDTO(estados));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    private Estado convertToEntity(EstadoDTO dto){

        return  new ModelMapper().map(dto, Estado.class);
    }

    private EstadoDTO convertToDTO(Estado obj){
        return  new ModelMapper().map(obj, EstadoDTO.class);
    }
}
