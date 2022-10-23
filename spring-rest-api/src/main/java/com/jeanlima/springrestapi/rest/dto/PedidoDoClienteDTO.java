package com.jeanlima.springrestapi.rest.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.jeanlima.springrestapi.model.Pedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDoClienteDTO {
    private Integer clienteId;
    private BigDecimal total;
    private List<ItemPedidoDTO> items;

    public PedidoDoClienteDTO(Pedido pedido) {
        this.clienteId = pedido.getCliente().getId();
        this.total = pedido.getTotal();
        this.items = pedido.getItens().stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
    }
}
