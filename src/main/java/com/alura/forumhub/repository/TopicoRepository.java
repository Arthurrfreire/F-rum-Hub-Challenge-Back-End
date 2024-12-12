package com.alura.forumhub.repository;

import com.alura.forumhub.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensagem(String titulo, String mensagem);
    Page<Topico> findByCurso_NomeContaining(String cursoNome, Pageable pageable);
}
