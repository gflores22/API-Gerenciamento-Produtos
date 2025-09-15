package com.api.gerenciamento_produtos.repository;

import com.api.gerenciamento_produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
