package com.francobbs.historicoservice.application;

import com.francobbs.historicoservice.domain.HistoricoEvento;
import com.francobbs.historicoservice.domain.TipoEvento;
import com.francobbs.historicoservice.infrastructure.HistoricoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoService {

    private final HistoricoRepository historicoRepository;

    public HistoricoService(
            HistoricoRepository historicoRepository) {

        this.historicoRepository = historicoRepository;
    }

    public List<HistoricoEvento> listar() {
        return historicoRepository.findAll();
    }

    public HistoricoEvento buscarPorId(String id) {
        return historicoRepository
                .findById(id)
                .orElse(null);
    }

    public HistoricoEvento salvar(
            HistoricoEvento historicoEvento) {

        return historicoRepository.save(
                historicoEvento
        );
    }

    public List<HistoricoEvento> buscarPorUsuario(
            Long usuarioId) {

        return historicoRepository
                .findByUsuarioId(usuarioId);
    }

    public List<HistoricoEvento> buscarPorCompra(
            Long compraId) {

        return historicoRepository
                .findByCompraId(compraId);
    }

    public List<HistoricoEvento> buscarPorEvento(
            TipoEvento evento) {

        return historicoRepository
                .findByEvento(evento);
    }

    public boolean deletar(String id) {

        if (historicoRepository.existsById(id)) {

            historicoRepository.deleteById(id);

            return true;
        }

        return false;
    }
}