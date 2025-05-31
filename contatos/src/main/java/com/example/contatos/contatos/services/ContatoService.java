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
     Optional<Contato> contato = contatoRepository.findById(id);
        if(contato.isPresent()) {
            return contato.get();
        }
            throw new IllegalArgumentException("Contato não encontrado.");
    }

    public List<Contato> findAll(Integer contatoId) {
        return contatoRepository.findAll();
    }

    public Contato save(Integer idCon, ContatoDTO contatoDTO) {
       Contato contato;

       if(idCon != null && idCon != 0) {

           contato = findById(idCon);
           contato.setNome(contatoDTO.getNome());
           contato.setEmail(contatoDTO.getEmail());
           contato.setCpf(contatoDTO.getCpf());

       }else{

           contato = new Contato();
           contato.setNome(contatoDTO.getNome());
           contato.setEmail(contatoDTO.getEmail());
           contato.setCpf(contatoDTO.getCpf());
       }

       return contatoRepository.save(contato);
    }

    public Contato update(Integer idCon, ContatoDTO contatoDTO) {
        Contato existingContato = findById(idCon);

        existingContato.setNome(contatoDTO.getNome());
        existingContato.setEmail(contatoDTO.getEmail());
        existingContato.setCpf(contatoDTO.getCpf());

        return contatoRepository.save(existingContato);

    }

    public void delete(Integer id) {
        findById(id);
        contatoRepository.deleteById(id);
    }
}
