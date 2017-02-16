package com.carledwin.ti.cobranca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carledwin.ti.cobranca.model.Titulo;

public interface Titulos extends JpaRepository<Titulo, Long> {

	public List<Titulo> findByDescricaoContainingIgnoreCaseOrderByDescricaoAsc(String descricao);
}
