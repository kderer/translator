package net.kadirderer.translator.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import net.kadirderer.translator.service.TranslateService;
import net.kadirderer.translator.test.config.BaseTest;

public class TranslateServiceTest extends BaseTest {

	@Autowired
	private TranslateService translateService;
	
	@Test
	public void testTranslate() {
		String result = translateService.translate("en", "tr", "hello world!");
		
		Assert.assertNotEquals(0, result.length());
	}
	
	
	@Test
	public void testGetLanguagesForTranslate() {
		List<String> result = translateService.getLanguagesForTranslate();
		
		Assert.assertNotEquals(0, result.size());
	}
	
}
