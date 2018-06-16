package com.org.repository;

import com.org.modelo.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa,Long> {
}
