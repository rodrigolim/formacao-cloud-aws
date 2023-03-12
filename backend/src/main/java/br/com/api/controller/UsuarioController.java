package br.com.api.controller;

import br.com.api.entity.Usuario;
import br.com.api.service.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@SecurityRequirement(name="javainuseapi")
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService service;
    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioService service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        var novoUsuario = service.salvar(usuario);
        ResponseEntity responseEntity = new ResponseEntity(usuario, HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> escluir(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
