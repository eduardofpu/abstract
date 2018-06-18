package com.org.service;

import com.org.modelo.Cidade;
import org.springframework.stereotype.Service;

@Service
public interface CidadeService {
    Cidade create(Cidade cidade);
}
