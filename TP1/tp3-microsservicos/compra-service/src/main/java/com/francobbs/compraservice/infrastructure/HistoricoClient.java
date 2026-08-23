package com.francobbs.compraservice.infrastructure;

import com.francobbs.compraservice.domain.HistoricoEvento;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HistoricoClient {

    private final RestTemplate restTemplate;

    public HistoricoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public HistoricoEvento registrarEvento(
            HistoricoEvento evento) {

        return restTemplate.postForObject(
                "http://HISTORICO-SERVICE/historico",
                evento,
                HistoricoEvento.class
        );
    }
}