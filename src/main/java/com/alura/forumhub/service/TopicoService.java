package com.alura.forumhub.service;

import com.alura.forumhub.dto.TopicoRequest;
import com.alura.forumhub.dto.TopicoResponse;
import com.alura.forumhub.model.Topico;
import com.alura.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public List<TopicoResponse> listarTopicos() {
        return topicoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public TopicoResponse cadastrarTopico(TopicoRequest request) {
        Topico topico = new Topico();
        topico.setTitulo(request.getTitulo());
        topico.setMensagem(request.getMensagem());
        topicoRepository.save(topico);
        return toResponse(topico);
    }

    public TopicoResponse buscarTopicoPorId(Long id) {
        Topico topico = topicoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tópico não encontrado"));
        return toResponse(topico);
    }

    private TopicoResponse toResponse(Topico topico) {
        TopicoResponse response = new TopicoResponse();
        response.setId(topico.getId());
        response.setTitulo(topico.getTitulo());
        response.setMensagem(topico.getMensagem());
        response.setDataCriacao(topico.getDataCriacao());
        response.setNomeCurso(topico.getCurso() != null ? topico.getCurso().getNome() : null);
        response.setNomeAutor(topico.getAutor() != null ? topico.getAutor().getNome() : null);
        return response;
    }
}