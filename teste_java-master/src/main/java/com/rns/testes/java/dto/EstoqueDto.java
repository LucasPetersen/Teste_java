package com.rns.testes.java.dto;

import com.rns.testes.java.enums.EnumTipoFilial;
import com.rns.testes.java.model.GenericEntity;
import com.rns.testes.java.model.Filial;
import com.rns.testes.java.model.Produto;
import lombok.Data;

@Data
public class EstoqueDto extends GenericEntity<Long> {

    private Long id;
    private String nome;
    private String local;
    private int quantidade;


}
