package com.accenture.desafio.fornecedores.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.accenture.desafio.fornecedores.model.Cep;
import com.accenture.desafio.fornecedores.model.Fornecedor;
import com.accenture.desafio.fornecedores.repository.FornecedorRepository;
import com.accenture.desafio.fornecedores.util.CepAPI;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> getAll() {
        return fornecedorRepository.findAll();
    }

    public void save(Fornecedor fornecedor) {
        ResponseEntity<Cep> cep = CepAPI.GetCepAPI(fornecedor.getCep());
        if(cep.getBody() == null) {
            throw new IllegalArgumentException("CEP informado não encontrado.");
        }
        if(isPessoaFisica(fornecedor.getCpf())) {
            if(fornecedor.getRg() == null || fornecedor.getRg().isEmpty()) {
                throw new IllegalArgumentException("RG deve ser informado para fornecedor pessoa física.");
            }
            if(fornecedor.getDataNascimento() == null || fornecedor.getDataNascimento().after(new Date())) {
                throw new IllegalArgumentException("Data de Nascimento deve ser informado para fornecedor pessoa física.");
            }
            if(cep.getBody().getUf().equals("PR")) {
                // if(fornecedor.getDataNascimento().after(new Date()))) {
                //     1991-03-16 > 2005-05-23 - 18
                    throw new IllegalArgumentException("O fornecedor deve ser maior de idade para ser cadastrado."); 
                // }
            }
        }
        fornecedorRepository.save(fornecedor);
    }

    public Fornecedor getFornecedorByCpf(String cpf) {
        return fornecedorRepository.findById(cpf).get();
    }

    public List<Fornecedor> getFornecedorByNome(String nome) {
        return fornecedorRepository.findByNomeContains(nome);
    }

    public void delete(String cpf) {
        fornecedorRepository.deleteById(cpf);
    }

    private boolean isPessoaFisica(String cpf) {
        return (cpf.length() == 11);
    }
}
