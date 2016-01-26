package net.kadirderer.translator.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Configuration
public class AccessTokenConfig {
	
	@Value("${microsoft.translate.accesstoken.grant_type}")
	private String grant_type;
	
	@Value("${microsoft.translate.accesstoken.client_id}")
	private String client_id;
	
	@Value("${microsoft.translate.accesstoken.scope}")
	private String scope;
	
	private MultiValueMap<String, String> params;
	
	@PostConstruct
	public void init() {
		params = new LinkedMultiValueMap<String, String>();
		
		params.add("grant_type", grant_type);
		params.add("client_id", client_id);
		params.add("client_secret", System.getenv("MS_CLIENT_SECRET"));
		params.add("scope", scope);
	}
	
	public MultiValueMap<String, String> accessTokenParams() {
		return params; 
	}

}
