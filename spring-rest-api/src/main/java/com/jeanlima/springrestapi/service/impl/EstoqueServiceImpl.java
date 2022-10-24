package com.jeanlima.springrestapi.service.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.jeanlima.springrestapi.exception.RegraNegocioException;
import com.jeanlima.springrestapi.model.Estoque;
import com.jeanlima.springrestapi.repository.EstoqueRepository;
import com.jeanlima.springrestapi.rest.dto.AtualizacaoQuantidadeEstoqueDTO;
import com.jeanlima.springrestapi.service.EstoqueService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstoqueServiceImpl implements EstoqueService{
    private final EstoqueRepository estoqueRepository;
    
    @Override
    public Estoque salvar(AtualizacaoQuantidadeEstoqueDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void atualizaQuantidade(Integer id, Integer quantidade) {
        estoqueRepository
            .findById(id)
            .map( estoque -> {
                estoque.setQuantidade(quantidade);
                return estoqueRepository.save(estoque);
            }).orElseThrow(() -> new RegraNegocioException("Código do estoque inválido."));
    }

    public List<Estoque> filtrarEstoqueNomeProduto(String nome) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(nome, matcher);        
        return estoqueRepository.findAll(example);
    }
}
