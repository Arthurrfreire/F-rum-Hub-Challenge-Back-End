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

    // Método para criar um novo tópico
    public TopicoResponse criarTopico(TopicoRequest request) {
        Topico topico = new Topico();
        topico.setTitulo(request.getTitulo());
        topico.setMensagem(request.getMensagem());
        topico.setCurso(request.getCurso());
        topico.setAutor(request.getAutor());

        Topico topicoSalvo = topicoRepository.save(topico);

        return new TopicoResponse(
                topicoSalvo.getId(),
                topicoSalvo.getTitulo(),
                topicoSalvo.getMensagem(),
                topicoSalvo.getDataCriacao(),
                topicoSalvo.getStatus(),
                topicoSalvo.getCurso(),
                topicoSalvo.getAutor()
        );
    }

    // Método para listar todos os tópicos
    public List<TopicoResponse> listarTopicos() {
        List<Topico> topicos = topicoRepository.findAll();

        return topicos.stream()
                .map(topico -> new TopicoResponse(
                        topico.getId(),
                        topico.getTitulo(),
                        topico.getMensagem(),
                        topico.getDataCriacao(),
                        topico.getStatus(),
                        topico.getCurso(),
                        topico.getAutor()
                ))
                .collect(Collectors.toList());
    }
}
