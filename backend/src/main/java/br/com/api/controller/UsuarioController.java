package br.com.api.controller;

import br.com.api.entity.Usuario;
import br.com.api.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
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
