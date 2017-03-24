package com.carledwin.ti.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(LoginController.URL_LOGIN)
public class LoginController {
	
	private static final String LOGIN_VIEW = "login";
	public static final String URL_LOGIN = "/login";
	private static final String HOME_VIEW = "home";
	
	@RequestMapping
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView(LOGIN_VIEW);
		return mv;
	}
	
	@RequestMapping(value="/logar")
	public ModelAndView logar(){
		ModelAndView mv = new ModelAndView(HOME_VIEW);
		return mv;
	}
}
