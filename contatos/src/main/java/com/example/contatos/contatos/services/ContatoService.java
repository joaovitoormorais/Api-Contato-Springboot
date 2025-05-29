package com.example.contatos.contatos.services;

import com.example.contatos.contatos.dtos.ContatoDTO;
import com.example.contatos.contatos.persistence.entities.Contato;
import com.example.contatos.contatos.persistence.repositories.ContatoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    ContatoRepository contatoRepository;

    public Contato findById(Integer id) {
       return contatoRepository.findById(id)
               .orElseThrow(() -> new ObjectNotFoundException("Contato não encontrado"));
    }

    public List<Contato> findAll(Integer contatoId) {
        return contatoRepository.findAll();
    }

    public Contato save(Integer idCon, ContatoDTO contatoDTO) {
    }

    public Contato update(Integer idCon, ContatoDTO contatoDTO) {
    }

    public void delete(Integer id) {
        findById(id);
        contatoRepository.deleteById(id);
    }
}
