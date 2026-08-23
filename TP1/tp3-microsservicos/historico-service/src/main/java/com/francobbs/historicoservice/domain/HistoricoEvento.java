package com.francobbs.historicoservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "historico")
public class HistoricoEvento {

    @Id
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
            String id,
            Long compraId,
            Long usuarioId,
            List<Long> jogosIds,
            Double valorTotal,
            LocalDateTime dataHora,
            TipoEvento evento) {

        this.id = id;
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

    public TipoEvento getTipoEvento() {
        return evento;
    }

    public void setTipoEvento(TipoEvento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "HistoricoEvento{" +
                "id='" + id + '\'' +
                ", compraId=" + compraId +
                ", usuarioId=" + usuarioId +
                ", jogosIds=" + jogosIds +
                ", valorTotal=" + valorTotal +
                ", dataHora=" + dataHora +
                ", evento=" + evento +
                '}';
    }
}