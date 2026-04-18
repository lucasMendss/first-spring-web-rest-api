package br.com.lucas.spring_boot_essentials.service;

import br.com.lucas.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.lucas.spring_boot_essentials.dto.ProdutoDto;
import br.com.lucas.spring_boot_essentials.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>();

    static {
        PRODUTOS.add(ProdutoEntity.builder()
                .id(1)
                .nome("Fone QCY")
                .preco(new BigDecimal(249))
                .quantidade(43)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(2)
                .nome("iPad Pro")
                .preco(new BigDecimal(6499))
                .quantidade(12)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(3)
                .nome("Samsung Book X40")
                .preco(new BigDecimal(3199))
                .quantidade(30)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(4)
                .nome("Mouse Gamer Logitech G203")
                .preco(new BigDecimal(189))
                .quantidade(58)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(5)
                .nome("Teclado Mecanico Redragon Kumara")
                .preco(new BigDecimal(279))
                .quantidade(41)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(6)
                .nome("Monitor LG UltraWide 29")
                .preco(new BigDecimal(1299))
                .quantidade(19)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(7)
                .nome("SSD NVMe Kingston 1TB")
                .preco(new BigDecimal(439))
                .quantidade(67)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(8)
                .nome("Webcam Full HD Logitech C920")
                .preco(new BigDecimal(359))
                .quantidade(26)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(9)
                .nome("Nintendo Switch OLED")
                .preco(new BigDecimal(2199))
                .quantidade(14)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(10)
                .nome("Controle Sem Fio Xbox")
                .preco(new BigDecimal(479))
                .quantidade(33)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(11)
                .nome("Headset HyperX Cloud Stinger")
                .preco(new BigDecimal(329))
                .quantidade(37)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(12)
                .nome("Hub USB-C Anker 7 em 1")
                .preco(new BigDecimal(249))
                .quantidade(24)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(13)
                .nome("Carregador Portatil 20000mAh")
                .preco(new BigDecimal(199))
                .quantidade(46)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(14)
                .nome("Jogo Elden Ring PS5")
                .preco(new BigDecimal(299))
                .quantidade(29)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(15)
                .nome("Jogo Mario Kart 8 Deluxe")
                .preco(new BigDecimal(349))
                .quantidade(21)
                .build());
    }

    public List<ProdutoEntity> getProducts() {
        return PRODUTOS;
    }

    public ProdutoEntity getProduct(Integer id) throws NotFoundException {
        return findProductByIdOrThrow(id);
    }

    public ProdutoEntity createProduct(ProdutoDto produtoDto) {
        Integer id = PRODUTOS.stream()
                .mapToInt(ProdutoEntity::getId)
                .max()
                .orElse(0) + 1;

        ProdutoEntity novoProduto = ProdutoEntity.builder()
                .id(id)
                .nome(produtoDto.getNome())
                .preco(produtoDto.getPreco())
                .quantidade(produtoDto.getQuantidade())
                .build();

        PRODUTOS.add(novoProduto);
        return novoProduto;
    }

    public ProdutoEntity updateProduct(ProdutoDto produtoDto, Integer id) throws NotFoundException {
        ProdutoEntity produto = findProductByIdOrThrow(id);

        produto.setNome(produtoDto.getNome());
        produto.setPreco(produtoDto.getPreco());
        produto.setQuantidade(produtoDto.getQuantidade());
        return produto;
    }

    public void deleteProduct(Integer id) {
        PRODUTOS.removeIf(p -> p.getId().equals(id));
    }

    private ProdutoEntity findProductByIdOrThrow(Integer id) throws NotFoundException {
        return PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }
}
