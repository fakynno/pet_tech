package br.com.fiap.pet_tech.pet_tech.service;

import java.util.Collection;
import java.util.UUID;

import br.com.fiap.pet_tech.pet_tech.dto.ProdutoDto;

public interface ProdutoService {

    Collection<ProdutoDto> findAll();
    
    ProdutoDto findById(UUID id);

    ProdutoDto save(ProdutoDto dto);
 
    ProdutoDto update(UUID id, ProdutoDto dto);

    void delete(UUID id);
}
