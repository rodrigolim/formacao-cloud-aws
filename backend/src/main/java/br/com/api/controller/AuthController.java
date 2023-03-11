package br.com.api.controller;

import br.com.api.dto.Login;
import br.com.api.entity.Usuario;
import br.com.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/api/login")
    public String login(@RequestBody Login login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(login.login(), login.password());

        Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        Usuario usuario = (Usuario) authenticate.getPrincipal();

        return tokenService.gerarToken(usuario);
    }

}


