package com.accenture.desafio.fornecedores.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cep {
    String cep;
    String uf;
    String cidade;
    String bairro;
    String logradouro;
}
