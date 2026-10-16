package com.urbana_pe.gereciadorCartao.business.dtos;

import com.urbana_pe.gereciadorCartao.infrastructure.TipoCartaoEnuns;
import org.springframework.stereotype.Component;


public class CartaoDTO {

    private Long id;
    private Integer numeroCartao;
    private String nome;
    private Boolean statusAtivo;
    private TipoCartaoEnuns tipoCartao;
    private String emailDoUsuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Integer numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getStatusAtivo() {
        return statusAtivo;
    }

    public void setStatusAtivo(Boolean statusAtivo) {
        this.statusAtivo = statusAtivo;
    }

    public String getEmailDoUsuario() {
        return emailDoUsuario;
    }

    public void setEmailDoUsuario(String emailDoUsuario) {
        this.emailDoUsuario = emailDoUsuario;
    }

    public TipoCartaoEnuns getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(TipoCartaoEnuns tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public CartaoDTO() {
    }

    public CartaoDTO(Integer numeroCartao, String nome, TipoCartaoEnuns tipoCartao, Boolean statusAtivo, String emailDoUsuario) {
        this.numeroCartao = numeroCartao;
        this.nome = nome;
        this.tipoCartao = tipoCartao;
        this.statusAtivo = statusAtivo;
        this.emailDoUsuario = emailDoUsuario;
    }
}
