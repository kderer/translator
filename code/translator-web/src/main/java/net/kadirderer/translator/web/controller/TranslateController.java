package net.kadirderer.translator.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.kadirderer.translator.service.PinyinService;
import net.kadirderer.translator.service.TranslateService;
import net.kadirderer.translator.web.dto.TranslateRequest;
import net.kadirderer.translator.web.dto.TranslateResult;

@RestController
@RequestMapping("/translate")
public class TranslateController {

	@Autowired
	private TranslateService translateService;
	
	@Autowired
	private PinyinService pinyinService;
	
	@RequestMapping(method = RequestMethod.POST)	
	public TranslateResult translate(TranslateRequest request) {
		TranslateResult result = new TranslateResult(request);
		
		result.setText(translateService.translate(request.getFl(), 
				request.getTl(), request.getText()));
		
		if ("zh".equals(request.getFl())) {
			result.setRequestPinyin(pinyinService.getPinyin(request.getText()));
		}
		
		if ("zh".equals(request.getTl())) {
			result.setResultPinyin(pinyinService.getPinyin(result.getText()));
		}
		
		return result;		
	}
}
