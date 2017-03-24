package com.carledwin.ti.cobranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.carledwin.ti.cobranca.repository.filter.TituloFilter;
import com.carledwin.ti.cobranca.service.AdministradorService;

@Controller
@RequestMapping(AdministradorController.URL_ADMINISTRADORES)
public class AdministradorController {
	
	private static final String PESQUISA_ADMINISTRADORES_VIEW = "PesquisaAdministradores";
	public static final String URL_ADMINISTRADORES = "/administradores";
	private static final String LIST_ADMINISTRADORES = "administradores";
	
	@Autowired
	private AdministradorService service;
	
	@RequestMapping
	public ModelAndView pesquisas(@ModelAttribute("filter") TituloFilter filter){
		ModelAndView mv = new ModelAndView(PESQUISA_ADMINISTRADORES_VIEW);
		
		mv.addObject(LIST_ADMINISTRADORES, service.findAll());
		return mv;
	}
}
