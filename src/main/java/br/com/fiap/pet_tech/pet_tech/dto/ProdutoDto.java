package br.com.fiap.pet_tech.pet_tech.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoDto(
    UUID id,
    String nome,
    String descricao,
    BigDecimal preco,
    String urlDaImagem
) {   
    
}
