package com.accenture.desafio.fornecedores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.desafio.fornecedores.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {
    List<Fornecedor> findByNomeContains(String nome);
}
