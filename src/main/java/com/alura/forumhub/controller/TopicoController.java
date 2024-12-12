package com.alura.forumhub.controller;

import com.alura.forumhub.model.Topico;
import com.alura.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    // Cadastro de Tópicos
    @PostMapping
    public ResponseEntity<Topico> criarTopico(@RequestBody @Valid Topico topico, UriComponentsBuilder uriBuilder) {
        if (topicoRepository.existsByTituloAndMensagem(topico.getTitulo(), topico.getMensagem())) {
            return ResponseEntity.badRequest().build();
        }

        Topico novoTopico = topicoRepository.save(topico);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(novoTopico.getId()).toUri();
        return ResponseEntity.created(uri).body(novoTopico);
    }

    // Listagem de Tópicos
    @GetMapping
    public Page<Topico> listarTopicos(@RequestParam(required = false) String curso, Pageable pageable) {
        if (curso == null) {
            return topicoRepository.findAll(pageable);
        }
        return topicoRepository.findByCurso_NomeContaining(curso, pageable);
    }

    // Detalhamento de Tópico
    @GetMapping("/{id}")
    public ResponseEntity<Topico> detalharTopico(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        return topico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualização de Tópico
    @PutMapping("/{id}")
    public ResponseEntity<Topico> atualizarTopico(@PathVariable Long id, @RequestBody @Valid Topico topicoAtualizado) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Topico topico = optionalTopico.get();
        topico.setTitulo(topicoAtualizado.getTitulo());
        topico.setMensagem(topicoAtualizado.getMensagem());
        topicoRepository.save(topico);
        return ResponseEntity.ok(topico);
    }

    // Exclusão de Tópico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTopico(@PathVariable Long id) {
        if (!topicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}