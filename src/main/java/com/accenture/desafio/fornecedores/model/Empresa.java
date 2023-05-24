package com.accenture.desafio.fornecedores.model;

import jakarta.persistence.Column;

// import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "empresas")
@Entity(name = "empresas")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "cnpj")
public class Empresa {
    @Id
    @Column(unique = true)
    private String cnpj;
    private String nome;
    private String cep;
    // @OneToMany
    // Set<Fornecedor> fornecedores;
}
