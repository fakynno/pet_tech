package br.com.fiap.pet_tech.pet_tech.service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import br.com.fiap.pet_tech.pet_tech.entities.ProdutoEntity;

public interface ProdutoService {

    Collection<ProdutoEntity> findAll();
    
    ProdutoEntity findById(UUID id);

    ProdutoEntity save(ProdutoEntity produto);
 
    ProdutoEntity update(UUID id, ProdutoEntity produto);

    void delete(UUID id);
}
