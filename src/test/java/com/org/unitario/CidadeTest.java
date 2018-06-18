package com.org.unitario;

import com.org.Application;
import com.org.modelo.Cidade;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class CidadeTest {


    @Test
    public void salvarCidade(){

        Cidade cidade = Cidade.builder()
                .id(1L)
                .nomeCidade("Uberlândia").build();

        Assertions.assertThat(cidade.getId()).isNotNull();
        Assertions.assertThat(cidade.getNomeCidade()).isNotNull();


    }
}
