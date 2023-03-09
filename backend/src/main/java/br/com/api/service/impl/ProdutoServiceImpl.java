package br.com.api.service.impl;

import br.com.api.entity.Produto;
import br.com.api.repository.ProdutoRepository;
import br.com.api.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void delete(Long id) {
       try {
           produtoRepository.deleteById(id);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
}
