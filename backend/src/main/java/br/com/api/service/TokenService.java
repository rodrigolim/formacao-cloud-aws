package br.com.api.service;

import br.com.api.entity.Usuario;

public interface TokenService {

    String gerarToken(Usuario usuario);

    String getSubject(String token);
}
