package br.com.fiap.pet_tech.pet_tech.service.impl;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.pet_tech.pet_tech.dto.ProdutoDto;
import br.com.fiap.pet_tech.pet_tech.entities.ProdutoEntity;
import br.com.fiap.pet_tech.pet_tech.exceptions.ControllerNotFoundException;
import br.com.fiap.pet_tech.pet_tech.repositories.ProdutoRepository;
import br.com.fiap.pet_tech.pet_tech.service.ProdutoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    
    private final ProdutoRepository produtoRepository;

    @Override
    public Collection<ProdutoDto> findAll() {
        var produtos = produtoRepository.findAll();
        return produtos
        .stream()
        .map(this::toProdutoDto)
        .collect(Collectors.toList());
    }

    @Override
    public ProdutoDto findById(UUID id) {
        var produto = produtoRepository.findById(id).orElseThrow(
            () -> new ControllerNotFoundException("Produto não encontrado"));
        return toProdutoDto(produto);      
    }

    @Override
    public ProdutoDto save(ProdutoDto dto) {
        ProdutoEntity produtoEntity = toProdutoEntity(dto);
        produtoEntity = produtoRepository.save(produtoEntity);
        return toProdutoDto(produtoEntity);
    }

    @Override
    public ProdutoDto update(UUID id, ProdutoDto dto) {

           ProdutoEntity existingProduto = produtoRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Produto não encontrado"));
           
            existingProduto.setNome(dto.nome());
            existingProduto.setDescricao(dto.descricao());
            existingProduto.setPreco(dto.preco());
            existingProduto.setUrlDaImagem(dto.urlDaImagem());
    
            produtoRepository.save(existingProduto);

            return toProdutoDto(existingProduto);
        
    }

    @Override
    public void delete(UUID id) {
        produtoRepository.deleteById(id);
    }

    private ProdutoDto toProdutoDto(ProdutoEntity produto) {

        return new ProdutoDto(
            produto.getId(), 
            produto.getNome(), 
            produto.getDescricao(), 
            produto.getPreco(), 
            produto.getUrlDaImagem());
    }

    private ProdutoEntity toProdutoEntity(ProdutoDto dto) {

        return new ProdutoEntity(
            dto.id(),
            dto.nome(),
            dto.descricao(),
            dto.preco(),            
            dto.urlDaImagem()
        );
    }

}
