package com.urbana_pe.gereciadorCartao.infrastructure.entity;

import com.urbana_pe.gereciadorCartao.infrastructure.TipoCartaoEnuns;
import jakarta.persistence.*;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="numeroCartao")
    private Integer numeroCartao;
    @Column(name="nome")
    private String nome;
    @Column(name="statusAtivo")
    private Boolean statusAtivo;
    @Enumerated(EnumType.STRING)
    @Column(name="tipoCartao")
    private TipoCartaoEnuns tipoCartao;
    @Column(name="emailDoUsuario")
    private String emailDoUsuario;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public void setStatusAtivo(Boolean statusCartao) {
        this.statusAtivo = statusCartao;
    }

    public TipoCartaoEnuns getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(TipoCartaoEnuns tipoCartao) {
        this.tipoCartao = tipoCartao;
    }


    public String getEmailDoUsuario() {
        return emailDoUsuario;
    }

    public void setEmailDoUsuario(String emailDoUsuario) {
        this.emailDoUsuario = emailDoUsuario;
    }

    public Cartao(){

    }


    public Cartao(Integer numeroCartao, String nome, Boolean statusAtivo, TipoCartaoEnuns tipoCartao, String emailDoUsuario) {
        this.numeroCartao = numeroCartao;
        this.nome = nome;
        this.statusAtivo = statusAtivo;
        this.tipoCartao = tipoCartao;
    }
}
