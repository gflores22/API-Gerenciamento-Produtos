package com.api.gerenciamento_produtos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
        @NotBlank(message = "O nome do produto é obrigatório")
        String nome,

        @NotBlank(message = "A descrição do produto é obrigatória")
        String descricao,

        @Positive(message = "O preço do produto deve ser um valor positivo")
        BigDecimal preco,

        @PositiveOrZero(message = "A quantidade do produto não pode ser menor que zero")
        Integer quantidade
) {}
