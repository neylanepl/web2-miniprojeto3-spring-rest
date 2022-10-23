package com.jeanlima.springrestapi.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AtualizacaoQuantidadeEstoqueDTO {
    private Integer quantidade;
}
