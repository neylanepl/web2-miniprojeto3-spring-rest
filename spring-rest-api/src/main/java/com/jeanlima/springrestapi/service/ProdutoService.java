package com.jeanlima.springrestapi.service;

import java.math.BigDecimal;

import com.jeanlima.springrestapi.model.Produto;
import com.jeanlima.springrestapi.rest.dto.AtualizacaoDescricaoPrecoProdutoDTO;

public interface ProdutoService {
    Produto salvar( AtualizacaoDescricaoPrecoProdutoDTO dto );
    void atualizaDescricaoPreco(Integer id, String descricao, BigDecimal preco);
    
}
