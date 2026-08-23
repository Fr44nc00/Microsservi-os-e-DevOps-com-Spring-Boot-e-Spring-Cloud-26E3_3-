package com.francobbs.historicoservice.infrastructure;

import com.francobbs.historicoservice.domain.HistoricoEvento;
import com.francobbs.historicoservice.domain.TipoEvento;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HistoricoRepository
        extends MongoRepository<HistoricoEvento, String> {

    List<HistoricoEvento> findByUsuarioId(Long usuarioId);

    List<HistoricoEvento> findByCompraId(Long compraId);

    List<HistoricoEvento> findByEvento(TipoEvento evento);

}