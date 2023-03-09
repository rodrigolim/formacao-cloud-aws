package br.com.api.controller;

import br.com.api.entity.Produto;
import br.com.api.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos(){
        return ResponseEntity.ok(produtoService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto){
        var novoProduto = produtoService.salvar(produto);
        ResponseEntity responseEntity = new ResponseEntity(produto, HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> escluir(@PathVariable Long id){
        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
