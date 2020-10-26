package com.rns.testes.java.controller;


import com.rns.testes.java.dto.EstoqueDto;
import com.rns.testes.java.dto.mapper.EstoqueMapper;
import com.rns.testes.java.model.Estoque;
import com.rns.testes.java.service.IEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin
@RestController
@RequestMapping
public class EstoqueController {

    private static final String BASE_URL = "estoque/";

    @Autowired
    IEstoqueService service;

    @GetMapping(value = BASE_URL + "find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<EstoqueDto>> findAll() { return  ResponseEntity.ok( toCollectionDto(service.findAll()) );
    }

    @PutMapping(value = BASE_URL + "update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Estoque> update(@RequestBody EstoqueDto dto) {
        return ResponseEntity.ok(service.update(EstoqueMapper.INSTANCE.dtoToEntity(dto)));
    }

    private List<EstoqueDto> toCollectionDto(List<Estoque> estoques ) {
        return estoques.stream()
                .map( estoque -> EstoqueMapper.INSTANCE.entityToDto(estoque))
                .collect(Collectors.toList());
    }
}
