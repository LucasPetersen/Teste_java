package com.rns.testes.java.model;

import lombok.Data;


import javax.persistence.*;

@Entity
@Table( name = "ESTOQUE")
@SequenceGenerator(name = "ESTOQUE_SEQ", sequenceName = "ESTOQUE_SEQ", allocationSize = 1)
@Data
public class Estoque extends GenericEntity<Long> {

    @Id
    @GeneratedValue(generator = "ESTOQUE_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name="filial_id")
    private Filial filial;

    @Column
    private int quantidade;

    @Override
    public Long getId() {
        return id;
    }
}
