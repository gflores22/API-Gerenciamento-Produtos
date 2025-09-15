package com.api.gerenciamento_produtos.mapper;

import com.api.gerenciamento_produtos.dto.ProdutoRequestDTO;
import com.api.gerenciamento_produtos.dto.ProdutoResponseDTO;
import com.api.gerenciamento_produtos.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toEntity(ProdutoRequestDTO dto) {
        return new Produto(
            null,
            dto.nome(),
            dto.descricao(),
            dto.preco(),
            dto.quantidade()
        );
    }

    public ProdutoResponseDTO toDTO(Produto produto) {
        return new ProdutoResponseDTO(
            produto.getId(),
            produto.getNome(),
            produto.getDescricao(),
            produto.getPreco(),
            produto.getQuantidade()
        );
    }

    public void updateEntity(Produto produto, ProdutoRequestDTO dto) {
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());
        produto.setQuantidade(dto.quantidade());
    }
}
