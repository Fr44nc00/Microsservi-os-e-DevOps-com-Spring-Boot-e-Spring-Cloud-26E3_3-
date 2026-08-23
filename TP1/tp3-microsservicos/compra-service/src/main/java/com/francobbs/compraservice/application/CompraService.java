package com.francobbs.compraservice.application;

import com.francobbs.compraservice.domain.*;
import com.francobbs.compraservice.infrastructure.CompraRepository;
import com.francobbs.compraservice.infrastructure.HistoricoClient;
import com.francobbs.compraservice.infrastructure.JogoClient;
import com.francobbs.compraservice.infrastructure.UsuarioClient;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompraService {

    private final CompraRepository compraRepository;
    private final UsuarioClient usuarioClient;
    private final JogoClient jogoClient;
    private final HistoricoClient historicoClient;

    public CompraService(
            CompraRepository compraRepository,
            UsuarioClient usuarioClient,
            JogoClient jogoClient,
            HistoricoClient historicoClient) {

        this.compraRepository = compraRepository;
        this.usuarioClient = usuarioClient;
        this.jogoClient = jogoClient;
        this.historicoClient = historicoClient;
    }

    @CircuitBreaker(
            name = "historicoService",
            fallbackMethod = "registrarEventoFallback"
    )
    public void registrarEvento(HistoricoEvento evento) {

        historicoClient.registrarEvento(evento);
    }

    public void registrarEventoFallback(
            HistoricoEvento evento,
            Exception ex) {

        System.out.println(
                "Historico-service indisponível. " +
                        "Compra registrada sem histórico."
        );
    }

    @Transactional
    public Compra cadastrar(Compra compra) {

        Usuario usuario =
                usuarioClient.buscarPorId(compra.getUsuarioId());

        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado");
        }

        List<Jogo> jogos = compra.getJogosIds()
                .stream()
                .map(jogoClient::buscarPorId)
                .toList();

        if (jogos.contains(null)) {
            throw new RuntimeException(
                    "Um ou mais jogos não foram encontrados"
            );
        }

        double valorTotal = jogos.stream()
                .mapToDouble(Jogo::getPreco)
                .sum();

        compra.setValorTotal(valorTotal);

        compra.setDataHora(LocalDateTime.now());

        Compra compraSalva =
                compraRepository.save(compra);

        HistoricoEvento evento =
                new HistoricoEvento(
                        compraSalva.getId(),
                        compraSalva.getUsuarioId(),
                        compraSalva.getJogosIds(),
                        compraSalva.getValorTotal(),
                        compraSalva.getDataHora(),
                        TipoEvento.COMPRA_REALIZADA
                );

        try {
            registrarEvento(evento);
        } catch (Exception ex) {
            System.out.println(
                    "Historico-service indisponível. Compra registrada sem histórico."
            );
        }

        compraSalva.setUsuario(usuario);

        compraSalva.setJogos(jogos);

        return compraSalva;
    }

    public List<Compra> listar() {
        return compraRepository.findAll();
    }

    public Compra buscarPorId(Long id) {
        return compraRepository.findById(id)
                .orElse(null);
    }

    @Transactional
    public Compra atualizar(Long id, Compra compra) {

        compra.setId(id);

        return cadastrar(compra);
    }

    @Transactional
    public boolean deletar(Long id) {

        if (compraRepository.existsById(id)) {

            compraRepository.deleteById(id);

            return true;
        }

        return false;
    }
}