package com.org.api;

import com.org.modelo.Pessoa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface PessoaApi {

    @RequestMapping(value = "/pessoas", method = RequestMethod.GET)
    ResponseEntity<?> findAll();

    @RequestMapping(value = "/pessoas", method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity<?> create(@RequestBody Pessoa pessoa);
}
