package com.carledwin.ti.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.carledwin.ti.cobranca.model.StatusTitulo;
import com.carledwin.ti.cobranca.model.Titulo;
import com.carledwin.ti.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired 
	private Titulos titulos;
	
	@RequestMapping
	public ModelAndView pesquisasr(){
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", titulos.findAll());
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo){
		titulos.save(titulo);
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem","Título salvo com sucesso!");
		return mv;
	}

	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		return mv;
	}
	
	@ModelAttribute
	public List<StatusTitulo> statusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
}
