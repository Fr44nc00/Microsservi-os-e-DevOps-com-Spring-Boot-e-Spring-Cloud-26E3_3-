package com.francobbs.historicoservice.interfaces;

import com.francobbs.historicoservice.application.HistoricoService;
import com.francobbs.historicoservice.domain.HistoricoEvento;
import com.francobbs.historicoservice.domain.TipoEvento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historico")
@CrossOrigin("*")
public class HistoricoController {

    private final HistoricoService historicoService;

    public HistoricoController(
            HistoricoService historicoService) {

        this.historicoService = historicoService;
    }

    @GetMapping
    public List<HistoricoEvento> listar() {
        return historicoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoEvento> buscarPorId(
            @PathVariable String id) {

        HistoricoEvento evento =
                historicoService.buscarPorId(id);

        return evento != null
                ? ResponseEntity.ok(evento)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<HistoricoEvento> salvar(
            @RequestBody HistoricoEvento historicoEvento) {

        HistoricoEvento salvo =
                historicoService.salvar(historicoEvento);

        return ResponseEntity.ok(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable String id) {

        boolean removido =
                historicoService.deletar(id);

        return removido
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<HistoricoEvento> buscarPorUsuario(
            @PathVariable Long usuarioId) {

        return historicoService
                .buscarPorUsuario(usuarioId);
    }

    @GetMapping("/compra/{compraId}")
    public List<HistoricoEvento> buscarPorCompra(
            @PathVariable Long compraId) {

        return historicoService
                .buscarPorCompra(compraId);
    }

    @GetMapping("/evento/{evento}")
    public List<HistoricoEvento> buscarPorEvento(
            @PathVariable TipoEvento evento) {

        return historicoService
                .buscarPorEvento(evento);
    }

}