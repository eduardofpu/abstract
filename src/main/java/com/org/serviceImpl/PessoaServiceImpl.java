package com.org.serviceImpl;

import com.org.modelo.Pessoa;
import com.org.repository.PessoaRepository;
import com.org.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository) {

        this.pessoaRepository = pessoaRepository;
    }


    @Override
    public ResponseEntity<?> findAll() {

        return new ResponseEntity<>(pessoaRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> create(Pessoa pessoa) {

        return new ResponseEntity<>(pessoaRepository.save(pessoa), HttpStatus.OK);
    }

}
