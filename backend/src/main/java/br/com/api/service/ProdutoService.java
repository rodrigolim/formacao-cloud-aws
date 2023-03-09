package br.com.api.service;

import br.com.api.entity.Produto;

import java.util.List;

public interface ProdutoService {
    List<Produto> buscarTodos();
    Produto salvar(Produto produto);
    void delete(Long id);
}
