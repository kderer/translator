package net.kadirderer.translator.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import net.kadirderer.translator.service.PinyinService;
import net.kadirderer.translator.test.config.BaseTest;

public class PinyinServiceTest extends BaseTest {

	@Autowired
	private PinyinService pinyinService;
	
	@Test
	public void testGetPinyin() {
		String pinyin = pinyinService.getPinyin("成都");
		
		Assert.assertNotEquals(0, pinyin.length());				
	}
}
