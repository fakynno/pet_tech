package br.com.fiap.pet_tech.pet_tech.service.impl;

import java.util.Collection;
import java.util.UUID;

import org.springframework.stereotype.Service;

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
    public Collection<ProdutoEntity> findAll() {
        var produtos = produtoRepository.findAll();
        return produtos;        
    }

    @Override
    public ProdutoEntity findById(UUID id) {
        var produto = produtoRepository.findById(id).orElseThrow(
            () -> new ControllerNotFoundException("Produto não encontrado"));
        return produto;      
    }

    @Override
    public ProdutoEntity save(ProdutoEntity produto) {
        produto = produtoRepository.save(produto);
        return produto;
    }

    @Override
    public ProdutoEntity update(UUID id, ProdutoEntity produto) {           

           ProdutoEntity existingProduto = produtoRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Produto não encontrado"));
           
            existingProduto.setNome(produto.getNome());
            existingProduto.setDescricao(produto.getDescricao());
            existingProduto.setPreco(produto.getPreco());
            existingProduto.setUrlDaImagem(produto.getUrlDaImagem());            
    
            return produtoRepository.save(existingProduto);        
        
    }

    @Override
    public void delete(UUID id) {
        produtoRepository.deleteById(id);
    }

}
