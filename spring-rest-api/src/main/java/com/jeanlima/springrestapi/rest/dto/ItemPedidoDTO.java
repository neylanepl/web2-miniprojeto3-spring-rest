package com.jeanlima.springrestapi.rest.dto;

import com.jeanlima.springrestapi.model.ItemPedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO {
    private Integer produto;
    private Integer quantidade;

    public ItemPedidoDTO(ItemPedido produto) {
        this.produto = produto.getId();
    }
}
