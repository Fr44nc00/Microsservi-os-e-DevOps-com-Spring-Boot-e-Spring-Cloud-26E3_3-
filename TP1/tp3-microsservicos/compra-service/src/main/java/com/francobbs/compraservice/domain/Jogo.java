package com.francobbs.compraservice.domain;

public class Jogo {

    private Long id;
    private String titulo;
    private Plataforma plataforma;
    private Double preco;

    public Jogo() {
    }

    public Jogo(Long id,
                String titulo,
                Plataforma plataforma,
                Double preco) {

        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}