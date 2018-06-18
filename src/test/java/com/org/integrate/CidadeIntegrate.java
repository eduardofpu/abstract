package com.org.integrate;

import com.org.Application;
import com.org.modelo.Cidade;
import com.org.repository.CidadeRepository;
import com.org.service.CidadeService;
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
public class CidadeIntegrate {

    @Autowired
    private CidadeService cidadeService;

    @Rule// dizer quais as ecessões irão acontecer no método
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void salvarCidadeTestService(){
        Cidade cidade = Cidade.builder()
                        .nomeCidade("Uberlândia")
                        .build();

        cidadeService.create(cidade);

        Assertions.assertThat(cidade.getId()).isNotNull();
        Assertions.assertThat(cidade.getNomeCidade()).isEqualTo("Uberlândia");
    }
}
