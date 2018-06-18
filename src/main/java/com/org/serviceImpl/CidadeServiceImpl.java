package com.org.serviceImpl;

import com.org.modelo.Cidade;
import com.org.repository.CidadeRepository;
import com.org.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeServiceImpl implements CidadeService{

    private CidadeRepository cidadeRepository;

    @Autowired
    public CidadeServiceImpl(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }
    @Override
    public Cidade create(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }
}
