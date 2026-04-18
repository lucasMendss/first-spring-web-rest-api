package br.com.lucas.spring_boot_essentials.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
/*
DTO significa Data Transfer Object. Nesse caso, é útil para criar um objeto de produto sem o Id, já que o Id
será gerenciado automaticamente pela aplicação, ou seja, o usuário nunca irá definir qual Id o produto terá
*/
public class ProdutoDto {

    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}
