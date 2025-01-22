package com.example.forohub.service;

import com.example.forohub.dto.TopicoDTO;
import com.example.forohub.entity.Topico;
import com.example.forohub.repository.TopicoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }
    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> obtenerTopicoPorId(Long id) {
        return topicoRepository.findById(id);
    }

    public boolean eliminarTopico(Long id) {
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    public Optional<Topico> actualizarTopico(Long id, TopicoDTO topicoDTO) {
        return topicoRepository.findById(id).map(topico -> {
            topico.setTitulo(topicoDTO.getTitulo());
            topico.setMensaje(topicoDTO.getMensaje());
            topico.setAutor(topicoDTO.getAutor());
            topico.setCurso(topicoDTO.getCurso());
            topicoRepository.save(topico);
            return topico;
        });
    }



    public Topico crearTopico(TopicoDTO topicoDTO) {
        Topico topico = new Topico();
        topico.setTitulo(topicoDTO.getTitulo());
        topico.setMensaje(topicoDTO.getMensaje());
        topico.setAutor(topicoDTO.getAutor());
        topico.setCurso(topicoDTO.getCurso());
        topico.setFechaCreacion(LocalDateTime.now());
        topico.setStatus("ABIERTO");

        return topicoRepository.save(topico);
    }
}
