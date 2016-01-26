package net.kadirderer.translator.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.kadirderer.translator.web.util.Languages;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {		
		return "index";
	}
	
	@ModelAttribute("languages")
	public Languages[] languages() {
		return Languages.values();
	}
	

}
