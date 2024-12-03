package com.alura.forumhub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    // Getters e Setters padrão
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Implementação dos métodos exigidos por UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Se você não está usando permissões (roles), retorne uma lista vazia
        return java.util.Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return senha; // Retorna a senha do usuário
    }

    @Override
    public String getUsername() {
        return email; // O email será usado como o "username"
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Retorna true se a conta não estiver expirada
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Retorna true se a conta não estiver bloqueada
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Retorna true se as credenciais não estiverem expiradas
    }

    @Override
    public boolean isEnabled() {
        return true; // Retorna true se a conta estiver ativa
    }
}
