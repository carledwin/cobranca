package com.carledwin.ti.cobranca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.carledwin.ti.cobranca.model.StatusTitulo;
import com.carledwin.ti.cobranca.model.Titulo;
import com.carledwin.ti.cobranca.repository.Titulos;

@Service
public class CadastroTituloService {

	@Autowired
	private Titulos titulos;

	public void save(Titulo titulo){
		try{
			titulos.save(titulo);
		}catch(DataIntegrityViolationException e){
			throw new IllegalArgumentException("Formato de data inválido.");
		}
	}
	
	public String receber(Long codigo){
		Titulo titulo = titulos.findOne(codigo);
		titulo.setStatus(StatusTitulo.RECEBIDO);
		titulos.save(titulo);
		return titulo.getStatus().getDescricao();
	}
	
	public void delete(Long codigo){
		titulos.delete(codigo);
	}
	
	public List<Titulo> findAll(){
		return titulos.findAll();
	}
	
	public Titulos getTitulos() {
		return titulos;
	}

	public void setTitulos(Titulos titulos) {
		this.titulos = titulos;
	}
	
	
}
