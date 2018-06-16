package com.org.service;

import com.org.modelo.Pessoa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface PessoaService {
   ResponseEntity<?> findAll();
   ResponseEntity<?> create(Pessoa pessoa);

}
