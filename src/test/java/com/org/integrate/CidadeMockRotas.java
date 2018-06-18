package com.org.integrate;

import com.org.Application;
import com.org.modelo.Cidade;
import com.org.service.CidadeService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@AutoConfigureMockMvc
public class CidadeMockRotas {

    private final String PHAT = "/cidades/salvarNomeCidade";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private CidadeService cidadeService;

     @Autowired
     MockMvc mockMvc;

    @Test
    public void SalvarCidadeTestRota(){

        Cidade cidade = Cidade.builder()
                .id(1L)
                .nomeCidade("Itumbiara")
                .build();
        cidadeService.create(cidade);

        BDDMockito.when(cidadeService.create(cidade)).thenReturn(cidade);
        ResponseEntity<Cidade> response = testRestTemplate.postForEntity(PHAT,cidade,Cidade.class);
        Assertions.assertThat(cidade.getId()).isEqualTo(1L);
        Assertions.assertThat(cidade.getNomeCidade()).isEqualTo("Itumbiara");
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);

    }
}