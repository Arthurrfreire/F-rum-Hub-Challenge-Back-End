package com.alura.forumhub.model;

public enum StatusTopico {
    NAO_RESPONDIDO, // Indica que o tópico ainda não foi respondido
    NAO_SOLUCIONADO, // Indica que o tópico foi respondido mas ainda não resolvido
    SOLUCIONADO,     // Indica que o tópico foi solucionado
    FECHADO          // Indica que o tópico foi fechado sem solução
}
