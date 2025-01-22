package com.example.forohub.controller;

import com.example.forohub.dto.TopicoDTO;
import com.example.forohub.entity.Topico;
import com.example.forohub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody @Valid TopicoDTO topicoDTO) {
        Topico nuevoTopico = topicoService.crearTopico(topicoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTopico);
    }
    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        List<Topico> topicos = topicoService.listarTopicos();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopicoPorId(@PathVariable Long id) {
        return topicoService.obtenerTopicoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(
            @PathVariable Long id,
            @RequestBody @Valid TopicoDTO topicoDTO) {

        return topicoService.actualizarTopico(id, topicoDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        if (topicoService.eliminarTopico(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
