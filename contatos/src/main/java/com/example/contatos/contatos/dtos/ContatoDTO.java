package com.example.contatos.contatos.dtos;

import com.example.contatos.contatos.persistence.entities.Contato;

public class ContatoDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private String email;

    public ContatoDTO() {

    }

    public ContatoDTO(Integer id, String nome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public ContatoDTO(Contato contato) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
