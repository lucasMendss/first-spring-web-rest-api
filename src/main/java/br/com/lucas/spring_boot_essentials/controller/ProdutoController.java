package br.com.lucas.spring_boot_essentials.controller;

import br.com.lucas.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.lucas.spring_boot_essentials.dto.ProdutoDto;
import br.com.lucas.spring_boot_essentials.exception.NotFoundException;
import br.com.lucas.spring_boot_essentials.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // adiciona todas as propriedades que são
// private final (como o objeto produtoService) ao construtor de Produto Controller
@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> getProdutos() {
        return produtoService.getProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoEntity getProduto(@PathVariable Integer id) throws NotFoundException {
        return produtoService.getProduct(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity createProduto(@RequestBody ProdutoDto produtoDto) {
        return produtoService.createProduct(produtoDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity updateProduto(@RequestBody ProdutoDto produtoDto, @PathVariable Integer id) throws NotFoundException {
        return produtoService.updateProduct(produtoDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduto(@PathVariable Integer id) {
        produtoService.deleteProduct(id);
    }
}
