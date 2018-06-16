package com.org.integrate;

import com.org.Application;
import com.org.modelo.Pessoa;
import com.org.repository.PessoaRepository;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class PessoaIntegrate {

    @Autowired
    PessoaRepository pessoaRepository;

    @Rule// dizer quais as ecessões irão acontecer no método
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void findAllPessoa(){

        Assertions.assertThat(this.pessoaRepository.findAll()).isNotNull();
    }

    @Test
    public void createPessoa(){
        Pessoa pessoa = new Pessoa(null,"Ludimila");
        this.pessoaRepository.save(pessoa);
        Assertions.assertThat(pessoa.getId()).isNotNull();
        Assertions.assertThat(pessoa.getNome()).isEqualTo("Ludimila");
    }
}



