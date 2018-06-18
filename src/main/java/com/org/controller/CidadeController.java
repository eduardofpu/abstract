package com.org.controller;

import com.org.api.CidadeApi;
import com.org.modelo.Cidade;
import com.org.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CidadeController implements CidadeApi {

    private CidadeService cidadeService;

    @Autowired
    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @Override
    public Cidade saveCidade(@RequestBody Cidade cidade) {

        return cidadeService.create(cidade);
    }
}
