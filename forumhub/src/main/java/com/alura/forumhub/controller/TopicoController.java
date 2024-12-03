package com.alura.forumhub.controller;

import com.alura.forumhub.dto.TopicoRequest;
import com.alura.forumhub.dto.TopicoResponse;
import com.alura.forumhub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public ResponseEntity<List<TopicoResponse>> listar() {
        return ResponseEntity.ok(topicoService.listarTopicos());
    }

    @PostMapping
    public ResponseEntity<TopicoResponse> criar(@RequestBody @Valid TopicoRequest request) {
        return ResponseEntity.ok(topicoService.criarTopico(request));
    }
}
