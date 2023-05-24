package com.accenture.desafio.fornecedores.util;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.accenture.desafio.fornecedores.model.Cep;

public class CepAPI {
    public static ResponseEntity<Cep> GetCepAPI(String cep) {
        final String uRL = "http://cep.la/";

        // HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);

        // HttpEntity<String> entity = new HttpEntity<String>("", headers);
        // RestTemplate restTemplate = new RestTemplate();
        // restTemplate.put(uRL+cep, entity);

        // RestTemplate restTemplate = new RestTemplate();
        // RequestEntity<String> requestEntity = RequestEntity .post(new URL(u+cep).toURI()) .contentType(MediaType.APPLICATION_JSON) .body(""); 
        // return restTemplate.exchange(requestEntity, Cep.class);

        // HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        // HttpEntity<String> entity = new HttpEntity<String>(headers);
        // // HttpEntity<String> entity = new HttpEntity<String>(postBodyJson ,headers);

        // RestTemplate restTemplate = new RestTemplate();
        // return restTemplate.getForObject(URL+cep, Cep.class, entity);
        // return restTemplate.exchange(entity, Cep.class);
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> httpEntity = new HttpEntity<>("", headers);
            return restTemplate.exchange(uRL+cep, HttpMethod.POST, httpEntity, Cep.class);
        }catch(Exception e) {
            return new ResponseEntity<Cep>(null, null, 0);
        }
    }
}
