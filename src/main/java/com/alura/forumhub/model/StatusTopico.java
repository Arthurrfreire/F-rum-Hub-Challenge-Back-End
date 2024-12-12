package com.alura.forumhub.model;

/**
 * Enum que representa os possíveis estados de um tópico no fórum.
 */
public enum StatusTopico {
    /**
     * O tópico foi criado, mas ainda não recebeu respostas.
     */
    NAO_RESPONDIDO,

    /**
     * O tópico recebeu respostas, mas a questão ainda não foi solucionada.
     */
    NAO_SOLUCIONADO,

    /**
     * O tópico foi solucionado, mas ainda está aberto para novas interações.
     */
    SOLUCIONADO,

    /**
     * O tópico foi encerrado e não pode mais receber interações.
     */
    FECHADO
}
