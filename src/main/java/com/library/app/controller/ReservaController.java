package com.library.app.controller;

import com.library.app.domain.DetalleReserva;
import com.library.app.domain.Reserva;
import com.library.app.dto.EstadosEnum;
import com.library.app.dto.ReservaDTO;
import com.library.app.service.IDetalleReservaCustom;
import com.library.app.service.IDetalleReservaService;
import com.library.app.service.ILibroService;
import com.library.app.service.IReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
import java.time.LocalDateTime;
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
        Reserva  reserva = service.update(id, rsv);

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
