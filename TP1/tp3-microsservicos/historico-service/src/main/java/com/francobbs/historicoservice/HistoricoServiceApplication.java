package com.francobbs.historicoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HistoricoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                HistoricoServiceApplication.class,
                args
        );
    }

}