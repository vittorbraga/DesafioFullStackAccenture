package com.accenture.desafio.fornecedores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.desafio.fornecedores.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {
}
