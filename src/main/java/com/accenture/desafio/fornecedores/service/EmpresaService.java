package com.accenture.desafio.fornecedores.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.desafio.fornecedores.model.Empresa;
import com.accenture.desafio.fornecedores.repository.EmpresaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> getAll() {
        return empresaRepository.findAll();
    }

    public void save(Empresa empresa) {
        empresaRepository.save(empresa);
    }

    public Empresa getEmpresa(String cnpj) {
        return empresaRepository.findById(cnpj).get();
    }

    public void delete(String cnpj) {
        empresaRepository.deleteById(cnpj);
    }
}
