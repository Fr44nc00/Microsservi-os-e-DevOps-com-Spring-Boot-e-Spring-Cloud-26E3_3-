package com.francobbs.compraservice.interfaces;

import com.francobbs.compraservice.application.CompraService;
import com.francobbs.compraservice.domain.Compra;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
@CrossOrigin("*")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping
    public List<Compra> listar() {
        return compraService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> buscarPorId(@PathVariable Long id) {

        Compra compra = compraService.buscarPorId(id);

        return compra != null
                ? ResponseEntity.ok(compra)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Compra cadastrar(@RequestBody Compra compra) {
        return compraService.cadastrar(compra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> atualizar(
            @PathVariable Long id,
            @RequestBody Compra compra) {

        return ResponseEntity.ok(
                compraService.atualizar(id, compra)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        return compraService.deletar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}