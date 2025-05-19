package com.example.contatos.contatos.controllers;

import com.example.contatos.contatos.dtos.ContatoDTO;
import com.example.contatos.contatos.persistence.entities.Contato;
import com.example.contatos.contatos.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    ContatoService contatoService;

    @GetMapping
    public ResponseEntity<ContatoDTO> findById(@PathVariable Integer id) {
        Contato con = contatoService.findById(id);
        return ResponseEntity.ok().body(new ContatoDTO(con));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ContatoDTO>> findAll(@RequestParam(value = "contato", defaultValue = "0")
                                                    Integer contatoId) {
        List<Contato> list = contatoService.findAll(contatoId);
        return ResponseEntity.ok().body(list.stream().map(contato -> new ContatoDTO(contato)).collect(Collectors.toList()));

    }

    @PostMapping
    public ResponseEntity<ContatoDTO> save(@RequestParam(value = "contato", defaultValue = "0")Integer id_con,
                                           @RequestBody ContatoDTO contatoDTO) {
        Contato con = contatoService.save(id_con, contatoDTO);
        return ResponseEntity.ok().body(new ContatoDTO(con));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoDTO> update(@PathVariable Integer id,
                                             @RequestParam(value = "contato", defaultValue = "0") Integer id_con,
                                             @RequestBody ContatoDTO contatoDTO) {
        contatoDTO.setId(id);
        Contato con = contatoService.update(id_con, contatoDTO);
        return ResponseEntity.ok().body(new ContatoDTO(con));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        contatoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
