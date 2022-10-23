package com.jeanlima.springrestapi.service;

import com.jeanlima.springrestapi.model.Estoque;
import com.jeanlima.springrestapi.rest.dto.AtualizacaoQuantidadeEstoqueDTO;

public interface EstoqueService {
    Estoque salvar( AtualizacaoQuantidadeEstoqueDTO dto );
    void atualizaQuantidade(Integer id, Integer quantidade);
}
