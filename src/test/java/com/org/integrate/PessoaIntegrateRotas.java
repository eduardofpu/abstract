package com.org.integrate;

import com.org.Application;
import com.org.modelo.Pessoa;
import com.org.repository.PessoaRepository;
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

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@AutoConfigureMockMvc
public class PessoaIntegrateRotas {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private PessoaRepository pessoaRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void listPessoa(){
        Pessoa pessoa1 = Pessoa.builder().id(1L).nome("Goku").build();
        Pessoa pessoa2 = Pessoa.builder().id(2L).nome("Kuririn").build();
        Pessoa pessoa3 = Pessoa.builder().id(3L).nome("Mestre Kame").build();

        List<Pessoa> pessoas = Arrays.asList(pessoa1, pessoa2, pessoa3);

        BDDMockito.when(pessoaRepository.findAll()).thenReturn(pessoas);
        ResponseEntity<String> response = testRestTemplate.getForEntity("/buscar",String.class);
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);



    }







}
