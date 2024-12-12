package com.alura.forumhub.dto;

import com.alura.forumhub.model.Curso;
import com.alura.forumhub.model.Usuario;

public class TopicoRequest {

    private String titulo;
    private String mensagem;
    private Curso curso;
    private Usuario autor;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
}