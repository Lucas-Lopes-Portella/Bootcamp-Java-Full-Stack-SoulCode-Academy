package com.SoulCode.Services.Models;

public enum StatusCalled {
    RECEBIDO( "Recebido"),
    ATRIBUIDO("Atribuido"),
    CONCLUIDO("Concluido"),
    ARQUIVADO("Arquivado");

    private String conteudo;

    StatusCalled(String conteudo) {
        this.conteudo=conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

}
