package com.accenture.desafio.fornecedores.model;

import java.util.Date;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "fornecedores")
@Entity(name = "fornecedores")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "cpf")
public class Fornecedor {
    @Id
    @Column(unique = true)
    private String cpf;
    private String nome;
    private String email;
    private String cep;
    @Nullable
    private String rg;
    @Nullable
    private Date dataNascimento;

}
