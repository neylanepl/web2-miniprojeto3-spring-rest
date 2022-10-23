package com.jeanlima.springrestapi.service.impl;

import java.lang.reflect.Field;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.server.ResponseStatusException;

import com.jeanlima.springrestapi.exception.RegraNegocioException;
import com.jeanlima.springrestapi.model.Cliente;
import com.jeanlima.springrestapi.repository.ClienteRepository;
import com.jeanlima.springrestapi.rest.dto.AtualizacaoNomeClienteDTO;
import com.jeanlima.springrestapi.service.ClienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService{
    private final ClienteRepository clientesRepository;
    
    @Override
    public Cliente salvar(AtualizacaoNomeClienteDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cliente getClienteById( Integer id ){
        return clientesRepository
                .findById(id)
                .orElseThrow(() -> //se nao achar lança o erro!
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado"));
    }

    @Override
    public void atualizar(Cliente clienteExistente, Map<Object, Object> camposCliente) {

        camposCliente.forEach((key, value) -> {
            Field campo = ReflectionUtils.findField(Cliente.class, (String) key);
            campo.setAccessible(true);
            ReflectionUtils.setField(campo, camposCliente, value);
        });
        clientesRepository.save(clienteExistente);


        // clientesRepository
        //     .findById(id)
        //     .map( cliente -> {
        //         cliente.setNome(nome);
        //         return clientesRepository.save(cliente);
        //     }).orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));
    }
}