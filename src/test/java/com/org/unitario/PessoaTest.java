package com.org.unitario;

import com.org.Application;
import com.org.modelo.Pessoa;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class PessoaTest {

    @Test
    public void testSavePessoaNot(){

        Pessoa pessoa = Pessoa.builder()
                .id(1L)
                .nome("Teste 1")
                .build();

        Assertions.assertThat(pessoa.getId()).isEqualTo(1L);
        Assertions.assertThat(pessoa.getNome()).isEqualTo("Teste 1");

    }

    @Test
    public void testSavePessoaNotNull(){

        Pessoa pessoa = Pessoa.builder()
                .id(1L)
                .nome("Teste 1")
                .build();

        Assertions.assertThat(pessoa.getId()).isNotNull();
        Assertions.assertThat(pessoa.getNome()).isNotNull();

    }
}
