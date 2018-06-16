package com.org.controller;

import com.org.api.PessoaApi;
import com.org.modelo.Pessoa;
import com.org.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PessoaController implements PessoaApi{

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @Override
    public ResponseEntity<?> findAll() {

        return pessoaService.findAll();
    }

    @Override
    public ResponseEntity<?> create(@RequestBody Pessoa pessoa) {
        return pessoaService.create(pessoa);

    }
}

