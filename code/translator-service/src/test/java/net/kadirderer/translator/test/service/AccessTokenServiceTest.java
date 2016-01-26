package net.kadirderer.translator.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import net.kadirderer.translator.client.TranslatorServiceAccessToken;
import net.kadirderer.translator.service.AccessTokenService;
import net.kadirderer.translator.test.config.BaseTest;

public class AccessTokenServiceTest extends BaseTest {
	
	@Autowired
	private AccessTokenService accessTokenService;
	
	@Test
	public void testGetAccessToken() {
		TranslatorServiceAccessToken token = accessTokenService.getToken();
		
		Assert.assertNotNull(token);
	}

}
