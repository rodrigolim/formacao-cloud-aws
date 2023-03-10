package br.com.api.service.impl;

import br.com.api.entity.Usuario;
import br.com.api.service.TokenService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    private final String SECRET_KEY = "secreta";

    @Override
    public String gerarToken(Usuario usuario) {
        return JWT.create()
                .withIssuer("Produtos")
                .withSubject(usuario.getUsername())
                .withClaim("id", usuario.getId())
                .withExpiresAt(Date.from(LocalDateTime.now()
                        .plusMinutes(10)
                        .toInstant(ZoneOffset.of("-03:00")))
                ).sign(Algorithm.HMAC256(SECRET_KEY));
    }

    @Override
    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET_KEY))
                .withIssuer("Produtos")
                .build().verify(token).getSubject();
    }
}
