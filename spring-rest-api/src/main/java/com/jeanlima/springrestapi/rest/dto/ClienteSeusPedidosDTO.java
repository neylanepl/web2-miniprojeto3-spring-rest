package com.jeanlima.springrestapi.rest.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.jeanlima.springrestapi.model.Cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClienteDTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteSeusPedidosDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private List<PedidoDoClienteDTO> pedidos;

    public ClienteSeusPedidosDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.pedidos = cliente.getPedidos().stream().map(PedidoDoClienteDTO::new).collect(Collectors.toList());
    }

   
}