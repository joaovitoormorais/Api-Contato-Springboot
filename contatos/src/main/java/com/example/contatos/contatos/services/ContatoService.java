package com.example.contatos.contatos.services;

import com.example.contatos.contatos.dtos.ContatoDTO;
import com.example.contatos.contatos.persistence.entities.Contato;
import com.example.contatos.contatos.persistence.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    ContatoRepository contatoRepository;

    public Contato findById(Integer id) {
    }

    public List<Contato> findAll(Integer contatoId) {
    }

    public Contato save(Integer idCon, ContatoDTO contatoDTO) {
    }

    public Contato update(Integer idCon, ContatoDTO contatoDTO) {
    }

    public void delete(Integer id) {
    }
}
