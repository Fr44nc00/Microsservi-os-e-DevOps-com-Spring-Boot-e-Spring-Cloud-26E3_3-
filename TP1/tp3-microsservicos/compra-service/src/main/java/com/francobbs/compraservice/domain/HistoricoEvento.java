package com.francobbs.compraservice.domain;

import java.time.LocalDateTime;
import java.util.List;

public class HistoricoEvento {

    private String id;

    private Long compraId;

    private Long usuarioId;

    private List<Long> jogosIds;

    private Double valorTotal;

    private LocalDateTime dataHora;

    private TipoEvento evento;

    public HistoricoEvento() {
    }

    public HistoricoEvento(
            Long compraId,
            Long usuarioId,
            List<Long> jogosIds,
            Double valorTotal,
            LocalDateTime dataHora,
            TipoEvento evento) {

        this.compraId = compraId;
        this.usuarioId = usuarioId;
        this.jogosIds = jogosIds;
        this.valorTotal = valorTotal;
        this.dataHora = dataHora;
        this.evento = evento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCompraId() {
        return compraId;
    }

    public void setCompraId(Long compraId) {
        this.compraId = compraId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Long> getJogosIds() {
        return jogosIds;
    }

    public void setJogosIds(List<Long> jogosIds) {
        this.jogosIds = jogosIds;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public TipoEvento getEvento() {
        return evento;
    }

    public void setEvento(TipoEvento evento) {
        this.evento = evento;
    }
}