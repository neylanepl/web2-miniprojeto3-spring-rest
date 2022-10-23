package com.jeanlima.springrestapi.service;

import java.util.Map;
import java.util.Optional;

import com.jeanlima.springrestapi.model.Cliente;
import com.jeanlima.springrestapi.rest.dto.ClienteSeusPedidosDTO;

public interface ClienteService {
    Cliente salvar( ClienteSeusPedidosDTO dto );
    public Cliente getClienteById( Integer id );
    void atualizar(Cliente clienteExistente, Map<Object, Object> camposCliente);
}