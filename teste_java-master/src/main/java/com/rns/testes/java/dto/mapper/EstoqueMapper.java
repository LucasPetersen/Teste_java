package com.rns.testes.java.dto.mapper;

import com.rns.testes.java.dto.EstoqueDto;
import com.rns.testes.java.model.Estoque;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * Interface respons?vel por implementar MapperStruct no mapeamento entre Estoque e EstoqueDto.
 */
@Mapper(componentModel = "spring")
public interface EstoqueMapper extends GenericMapper<Estoque, EstoqueDto> {

    EstoqueMapper INSTANCE = Mappers.getMapper(EstoqueMapper.class);


    @Mapping(target="nome", source="entity.produto.nome")
    @Mapping(target="local", source="entity.filial.endereco")
    @Override
    EstoqueDto entityToDto(Estoque entity);
}
