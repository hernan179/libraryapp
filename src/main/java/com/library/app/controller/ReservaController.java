package com.library.app.controller;

import com.library.app.domain.Cliente;
import com.library.app.domain.Reserva;
import com.library.app.dto.ReservaDTO;
import com.library.app.service.IDetalleReservaService;
import com.library.app.service.ILibroService;
import com.library.app.service.IReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/reserva")
public class ReservaController {

    private final IReservaService service;

    private final IDetalleReservaService iDetalleReservaService;
    private final ILibroService libroService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> findAll() throws Exception {
        List<ReservaDTO> reservas = service.findAll().stream().map(this::convertToDTO).toList();
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(convertToDTO(service.findById(id)));
    }

    @GetMapping("/seachr/{cliente}")
    public ResponseEntity<List<ReservaDTO>> findByCliente(@PathVariable Long cliente) throws Exception {

        Cliente clienteDb = Cliente.builder().idCliente(cliente).build();

        List<Reserva> lstReserva = service.reservadelcliente(clienteDb);

        List<ReservaDTO> lstDTO  = new ArrayList<>();

        for (Reserva rs : lstReserva) {
            ReservaDTO rsDTO = convertToDTO(rs);
            lstDTO.add(rsDTO);
        }
        return ResponseEntity.ok(lstDTO);
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> save(@Valid @RequestBody ReservaDTO dto) throws Exception {

        Reserva rsv = convertToEntity(dto);
        Reserva reserva = service.save(rsv);

        service.guardar(reserva);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(reserva.getIdReserva())
                .toUri();
        return ResponseEntity.created(location).body(convertToDTO(reserva));
    }

    @PutMapping("/{id}")
    //@Transactional
    public ResponseEntity<ReservaDTO> update(@PathVariable Long id, @RequestBody ReservaDTO dto)
            throws Exception {

        Reserva rsv = convertToEntity(dto);
        Reserva reserva = service.update(id, rsv);

        service.actualizar(reserva);

        return ResponseEntity.ok(convertToDTO(reserva));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Reserva convertToEntity(ReservaDTO dto) {
        Reserva reserva = modelMapper.map(dto, Reserva.class);
        return reserva;
    }

    private ReservaDTO convertToDTO(Reserva reserva) {
        return modelMapper.map(reserva, ReservaDTO.class);
    }
}
