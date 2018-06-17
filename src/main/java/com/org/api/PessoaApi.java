package com.org.api;

import com.org.modelo.Pessoa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequestMapping(value = "/")
public interface PessoaApi {

    @GetMapping(path = "buscar")
    ResponseEntity<?> findAll();

    @PostMapping(path = "salvar")
    ResponseEntity<?> create(@RequestBody Pessoa pessoa);
}
