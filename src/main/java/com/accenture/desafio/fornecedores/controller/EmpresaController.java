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

import com.accenture.desafio.fornecedores.model.Empresa;
import com.accenture.desafio.fornecedores.service.EmpresaService;

@CrossOrigin
@RestController
@RequestMapping("api/empresa")
public class EmpresaController { 
    
    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> getAll() {
        return empresaService.getAll();
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<Empresa> get(@PathVariable String cnpj) {
        try {
            Empresa empresa = empresaService.getEmpresa(cnpj);
            return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Empresa>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void saveEmpresa(@RequestBody Empresa data) {
        empresaService.save(data);
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity<?> update(@RequestBody Empresa empresa, @PathVariable String cnpj) {
        try {
            Empresa existEmpresa = empresaService.getEmpresa(cnpj);
            empresa.setCnpj(cnpj);
            empresaService.save(empresa);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{cnpj}")
    public void delete(@PathVariable String cnpj) {
        empresaService.delete(cnpj);
    }
}
