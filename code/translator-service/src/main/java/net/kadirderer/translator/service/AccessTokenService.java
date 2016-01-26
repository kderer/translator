package net.kadirderer.translator.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import net.kadirderer.translator.client.TranslatorServiceAccessToken;
import net.kadirderer.translator.client.TranslatorServiceClient;

@Service
public class AccessTokenService {

	@Autowired
	private TranslatorServiceClient accessTokenClient;

	@Autowired
	private AccessTokenConfig accessTokenConfig;

	private long lastTokenTime;
	private TranslatorServiceAccessToken token;

	public TranslatorServiceAccessToken getToken() {
		String url = accessTokenClient.createUrl("");

		if (token == null || Calendar.getInstance().getTimeInMillis() - lastTokenTime > 5 * 60 * 1000) {
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(
					accessTokenConfig.accessTokenParams(), requestHeaders);

			ResponseEntity<TranslatorServiceAccessToken> response = accessTokenClient.getRestTemplate().exchange(url,
					HttpMethod.POST, requestEntity, TranslatorServiceAccessToken.class);
			try {
				token = response.getBody();
				lastTokenTime = Calendar.getInstance().getTimeInMillis();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return token;
	}

}
