package com.library.app.controller;

import com.library.app.domain.Cliente;
import com.library.app.dto.ClienteDTO;
import com.library.app.service.IClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1/clientes")
@RequiredArgsConstructor
@RestController
public class ClienteController{

    private final IClienteService service;

    private final ModelMapper clienteMapper;

     @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() throws Exception{
        List<Cliente> clientes = service.findAll();

        List<ClienteDTO> lstClientes = clientes.stream().map(this::convertToDTO).toList();

        return ResponseEntity.ok(lstClientes);
    }

    @GetMapping("/byid2/{id}")
    public ResponseEntity<Cliente> findById2(@PathVariable  Long id) throws Exception{
        //Cliente cliente = service.findById(id);
        return ResponseEntity.ok(service.findById(id));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable  Long id) throws Exception{
      Cliente cliente = service.findById(id);
        return ResponseEntity.ok(convertToDTO(cliente));
    }


  @PostMapping
  public ResponseEntity<ClienteDTO>  save(@Valid @RequestBody ClienteDTO dto) throws Exception{
    Cliente cliente = service.save(convertToEntity(dto));

    return ResponseEntity.ok(convertToDTO(cliente));

}

    @PutMapping
    public ResponseEntity<ClienteDTO>  update(@PathVariable Long id,@Valid @RequestBody ClienteDTO dto) throws Exception{
        Cliente cliente = service.update(id,convertToEntity(dto));

        return ResponseEntity.ok(convertToDTO(cliente));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteDTO> delete(@PathVariable  Long id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    private Cliente convertToEntity(ClienteDTO dto){

        return clienteMapper.map(dto,Cliente.class);
    }

    private ClienteDTO convertToDTO(Cliente obj){
        return clienteMapper.map(obj,ClienteDTO.class);
    }
}