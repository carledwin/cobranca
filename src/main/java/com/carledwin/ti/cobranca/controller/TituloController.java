package com.carledwin.ti.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.carledwin.ti.cobranca.model.StatusTitulo;
import com.carledwin.ti.cobranca.model.Titulo;
import com.carledwin.ti.cobranca.repository.Titulos;

@Controller
@RequestMapping(TituloController.URL_TITULOS)
public class TituloController {
	
	private static final String CADASTRO_TITULO_VIEW = "CadastroTitulo";
	private static final String MSG_TITULO_SALVO_COM_SUCESSO = "Título salvo com sucesso!";
	private static final String MSG_TITULO_EXCLUIDO_COM_SUCESSO = "Título excluido com sucesso!";
	private static final String PESQUISA_TITULOS_VIEW = "PesquisaTitulos";
	private static final String REDIRECT_TITULOS = "redirect:/titulos";
	private static final String REDIRECT_TITULOS_NOVO = "redirect:/titulos/novo";
	private static final String URL_NOVO = "/novo";
	public static final String URL_TITULOS = "/titulos";
	private static final String VAR_MENSAGEM = "mensagem";
	private static final String VAR_TITULOS = "titulos";
	@Autowired 
	private Titulos titulos;
	
	@RequestMapping
	public ModelAndView pesquisasr(){
		ModelAndView mv = new ModelAndView(PESQUISA_TITULOS_VIEW);
		mv.addObject(VAR_TITULOS, titulos.findAll());
		return mv;
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes){
		titulos.delete(codigo);
		attributes.addFlashAttribute(VAR_MENSAGEM, MSG_TITULO_EXCLUIDO_COM_SUCESSO);
		return REDIRECT_TITULOS;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Titulo titulo){
		ModelAndView mv = new ModelAndView(CADASTRO_TITULO_VIEW);
		mv.addObject(titulo);
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes){
		if(errors.hasErrors()){
			return PESQUISA_TITULOS_VIEW;
		}
		try{
			titulos.save(titulo);
			attributes.addFlashAttribute(VAR_MENSAGEM,MSG_TITULO_SALVO_COM_SUCESSO);
			return REDIRECT_TITULOS;
		}catch(DataIntegrityViolationException e){
			errors.reject("dataVencimento", null, "Formato de data inválido.");
			return CADASTRO_TITULO_VIEW;
		}
	}

	@RequestMapping(URL_NOVO)
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView(CADASTRO_TITULO_VIEW);
		mv.addObject(new Titulo());
		return mv;
	}
	
	@ModelAttribute
	public List<StatusTitulo> statusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
}
