package br.com.lucas.spring_boot_essentials.database.model;

import java.math.BigDecimal;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoEntity {

    private Integer id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}
