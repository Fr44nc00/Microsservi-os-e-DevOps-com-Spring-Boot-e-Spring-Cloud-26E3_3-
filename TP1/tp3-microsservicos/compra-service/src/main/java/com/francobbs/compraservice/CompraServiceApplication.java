package com.francobbs.compraservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CompraServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompraServiceApplication.class, args);
    }

}
