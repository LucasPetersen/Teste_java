package com.rns.testes.java.service.impl;

import com.rns.testes.java.dao.IEstoqueDao;
import com.rns.testes.java.model.Estoque;
import com.rns.testes.java.service.AbstractGenericServicePersistence;
import com.rns.testes.java.service.IEstoqueService;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService extends AbstractGenericServicePersistence<IEstoqueDao, Estoque, Long> implements IEstoqueService {
}
