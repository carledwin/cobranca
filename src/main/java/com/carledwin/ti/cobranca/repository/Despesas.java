package com.carledwin.ti.cobranca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carledwin.ti.cobranca.model.Despesa;

public interface Despesas extends JpaRepository<Despesa, Long> {

	public List<Despesa> findByDescricaoContainingIgnoreCaseOrderByDescricaoAsc(String descricao);
}
