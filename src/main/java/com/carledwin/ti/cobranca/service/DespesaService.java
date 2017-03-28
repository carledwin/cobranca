package com.carledwin.ti.cobranca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.carledwin.ti.cobranca.model.Despesa;
import com.carledwin.ti.cobranca.model.StatusDespesa;
import com.carledwin.ti.cobranca.repository.Despesas;
import com.carledwin.ti.cobranca.repository.filter.DespesaFilter;


@Service
public class DespesaService {

	@Autowired
	private Despesas repository;

	public void save(Despesa despesa){
		try{
			repository.save(despesa);
		}catch(DataIntegrityViolationException e){
			throw new IllegalArgumentException("Formato de data inválido.");
		}
	}
	
	public String pagar(Long id){
		Despesa despesa = repository.findOne(id);
		despesa.setStatus(StatusDespesa.PAGA);
		repository.save(despesa);
		return despesa.getStatus().getDescricao();
	}
	
	public String pagarComAtraso(Long id){
		Despesa despesa = repository.findOne(id);
		despesa.setStatus(StatusDespesa.PAGA_ATRASO);
		repository.save(despesa);
		return despesa.getStatus().getDescricao();
	}
	
	public void delete(Long id){
		repository.delete(id);
	}
	
	public List<Despesa> findByFilter(DespesaFilter filter){
		String descricao = filter.getDescricao() == null ? "%" : filter.getDescricao();
		return repository.findByDescricaoContainingIgnoreCaseOrderByDescricaoAsc(descricao);
	}

	public List<Despesa> findAll(){
		return repository.findAll();
	}
	
}
