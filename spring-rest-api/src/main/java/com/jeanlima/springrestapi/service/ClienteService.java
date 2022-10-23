package com.jeanlima.springrestapi.service;

import java.util.Map;

import com.jeanlima.springrestapi.model.Cliente;
import com.jeanlima.springrestapi.rest.dto.AtualizacaoNomeClienteDTO;

public interface ClienteService {
    Cliente salvar( AtualizacaoNomeClienteDTO dto );
    public Cliente getClienteById( Integer id );
    void atualizar(Cliente clienteExistente, Map<Object, Object> camposCliente);
}