package com.api.gerenciamento_produtos.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoResponseDTO(
    UUID id,
    String nome,
    String descricao,
    BigDecimal preco,
    Integer quantidade
) {}
