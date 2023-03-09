package br.com.api.service;


import br.com.api.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> buscarTodos();
    Usuario salvar(Usuario usuario);
    void delete(Long id);
}
