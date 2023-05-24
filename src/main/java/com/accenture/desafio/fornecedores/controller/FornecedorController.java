package com.accenture.desafio.fornecedores.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.desafio.fornecedores.model.Fornecedor;
import com.accenture.desafio.fornecedores.service.FornecedorService;

@CrossOrigin
@RestController
@RequestMapping("api/fornecedor")
public class FornecedorController { 
    
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<Fornecedor> getAll() {
        return fornecedorService.getAll();
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Fornecedor> getByCpf(@PathVariable String cpf) {
        try {
            Fornecedor fornecedor = fornecedorService.getFornecedorByCpf(cpf);
            return new ResponseEntity<Fornecedor>(fornecedor, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Fornecedor>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Fornecedor>> getByName(@PathVariable String nome) {
        try {
            List<Fornecedor> fornecedor = fornecedorService.getFornecedorByNome(nome);
            return new ResponseEntity<List<Fornecedor>>(fornecedor, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<List<Fornecedor>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveFornecedor(@RequestBody Fornecedor data) {
        try {
            fornecedorService.save(data);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }    
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<?> update(@RequestBody Fornecedor fornecedor, @PathVariable String cpf) {
        try {
            Fornecedor existFornecedor = fornecedorService.getFornecedorByCpf(cpf);
            fornecedor.setCpf(cpf);
            fornecedorService.save(fornecedor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable String cpf) {
        fornecedorService.delete(cpf);
    }
}
