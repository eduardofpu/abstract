package com.org.api;

import com.org.modelo.Cidade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cidades")
public interface CidadeApi {

    @PostMapping(path = "/salvarNomeCidade")
    Cidade saveCidade(@RequestBody Cidade cidade);
}
