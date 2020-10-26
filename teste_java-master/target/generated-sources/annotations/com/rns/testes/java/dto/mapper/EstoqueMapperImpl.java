package com.rns.testes.java.dto.mapper;

import com.rns.testes.java.dto.EstoqueDto;
import com.rns.testes.java.model.Estoque;
import com.rns.testes.java.model.Filial;
import com.rns.testes.java.model.Produto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-26T11:25:47-0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
@Component
public class EstoqueMapperImpl implements EstoqueMapper {

    @Override
    public Estoque dtoToEntity(EstoqueDto dto) {
        if ( dto == null ) {
            return null;
        }

        Estoque estoque = new Estoque();

        estoque.setVersao( dto.getVersao() );
        estoque.setDataUltAlteracao( dto.getDataUltAlteracao() );
        estoque.setId( dto.getId() );
        estoque.setQuantidade( dto.getQuantidade() );

        return estoque;
    }

    @Override
    public EstoqueDto entityToDto(Estoque entity) {
        if ( entity == null ) {
            return null;
        }

        EstoqueDto estoqueDto = new EstoqueDto();

        String nome = entityProdutoNome( entity );
        if ( nome != null ) {
            estoqueDto.setNome( nome );
        }
        String endereco = entityFilialEndereco( entity );
        if ( endereco != null ) {
            estoqueDto.setLocal( endereco );
        }
        estoqueDto.setVersao( entity.getVersao() );
        estoqueDto.setDataUltAlteracao( entity.getDataUltAlteracao() );
        estoqueDto.setId( entity.getId() );
        estoqueDto.setQuantidade( entity.getQuantidade() );

        return estoqueDto;
    }

    private String entityProdutoNome(Estoque estoque) {
        if ( estoque == null ) {
            return null;
        }
        Produto produto = estoque.getProduto();
        if ( produto == null ) {
            return null;
        }
        String nome = produto.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }

    private String entityFilialEndereco(Estoque estoque) {
        if ( estoque == null ) {
            return null;
        }
        Filial filial = estoque.getFilial();
        if ( filial == null ) {
            return null;
        }
        String endereco = filial.getEndereco();
        if ( endereco == null ) {
            return null;
        }
        return endereco;
    }
}
