package com.francobbs.compraservice.infrastructure;

import com.francobbs.compraservice.domain.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository
        extends JpaRepository<Compra, Long> {
}