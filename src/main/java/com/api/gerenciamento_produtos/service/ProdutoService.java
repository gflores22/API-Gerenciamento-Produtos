package com.api.gerenciamento_produtos.service;

import com.api.gerenciamento_produtos.dto.ProdutoRequestDTO;
import com.api.gerenciamento_produtos.mapper.ProdutoMapper;
import com.api.gerenciamento_produtos.model.Produto;
import com.api.gerenciamento_produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoService(ProdutoRepository repository, ProdutoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Produto salvarProduto(ProdutoRequestDTO requestDTO) {
        Produto produto = mapper.toEntity(requestDTO);
        return repository.save(produto);
    }

    public void deletarProduto(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado com id " + id);
        }
        repository.deleteById(id);
    }

    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    public Produto buscarProdutoPorId(UUID id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Produto não encontrado com id " + id)
        );
    }

    public Produto atualizarProduto(UUID id, ProdutoRequestDTO requestDTO) {
        Produto produto = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Produto não encontrado com id " + id)
        );
        return repository.save(mapper.updateEntity(produto, requestDTO));
    }
}
