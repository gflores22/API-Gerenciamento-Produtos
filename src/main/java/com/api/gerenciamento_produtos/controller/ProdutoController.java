package com.api.gerenciamento_produtos.controller;

import com.api.gerenciamento_produtos.dto.ProdutoRequestDTO;
import com.api.gerenciamento_produtos.dto.ProdutoResponseDTO;
import com.api.gerenciamento_produtos.mapper.ProdutoMapper;
import com.api.gerenciamento_produtos.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService service;
    private final ProdutoMapper mapper;

    public ProdutoController(ProdutoService service, ProdutoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutos() {
        List<ProdutoResponseDTO> produtos = service.listarProdutos()
                .stream()
                .map(mapper::toDTO)
                .toList();
        if (produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarProdutoPorId(@PathVariable UUID id) {
        ProdutoResponseDTO produto = mapper.toDTO(service.buscarProdutoPorId(id));
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> salvarProduto(@RequestBody ProdutoRequestDTO requestDTO) {
        ProdutoResponseDTO produto = mapper.toDTO(service.salvarProduto(requestDTO));
        return ResponseEntity
                .created(URI.create("/api/produtos/" + produto.id()))
                .body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@PathVariable UUID id, @RequestBody ProdutoRequestDTO requestDTO) {
        ProdutoResponseDTO produtoAtualizado = mapper.toDTO(service.atualizarProduto(id, requestDTO));
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable UUID id) {
        service.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
