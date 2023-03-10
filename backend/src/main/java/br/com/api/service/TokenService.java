package br.com.api.service;

import br.com.api.entity.Usuario;

public interface TokenService {

    public String gerarToken(Usuario usuario);
}
