package br.com.fiap.pet_tech.pet_tech.controller;

import java.util.Collection;
import java.util.UUID;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.pet_tech.pet_tech.dto.ProdutoDto;
import br.com.fiap.pet_tech.pet_tech.service.ProdutoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    @GetMapping
    public ResponseEntity<Collection<ProdutoDto>> findAll() {
        var produtos = service.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> findById(@PathVariable UUID id) {
        var produto = service.findById(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<ProdutoDto> save(@RequestBody ProdutoDto produto) {
        produto = service.save(produto);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> update(
        @PathVariable UUID id, 
        @RequestBody ProdutoDto produto) {
            produto = service.update(id, produto);
            return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
