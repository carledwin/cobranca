package com.carledwin.ti.cobranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.carledwin.ti.cobranca.repository.filter.TituloFilter;
import com.carledwin.ti.cobranca.service.TituloService;

@Controller
@RequestMapping(UsuarioController.URL_USUARIOS)
public class UsuarioController {
	
	private static final String PESQUISA_USUARIOS_VIEW = "PesquisaUsuarios";
	public static final String URL_USUARIOS = "/usuarios";
	private static final String LIST_USUARIOS = "usuarios";
	
	@Autowired
	private TituloService cadastroTitulosService;
	
	@RequestMapping
	public ModelAndView pesquisas(@ModelAttribute("filter") TituloFilter filter){
		ModelAndView mv = new ModelAndView(PESQUISA_USUARIOS_VIEW);
		
		mv.addObject(LIST_USUARIOS, cadastroTitulosService.findByFilter(filter));
		return mv;
	}
}
