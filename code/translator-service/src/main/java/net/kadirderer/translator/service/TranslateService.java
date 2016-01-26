package net.kadirderer.translator.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.XStream;

import net.kadirderer.translator.client.TranslatorServiceClient;

@Service
public class TranslateService {

	@Autowired
	private TranslatorServiceClient serviceClient;

	@Autowired
	private AccessTokenService accessTokenService;
	
	private static XStream xStream = new XStream();
	private static XStream xStreamArray = new XStream();
	
	@PostConstruct
	private void init() {
		xStreamArray.alias("ArrayOfstring", ArrayList.class);
	}

	public String translate(String fl, String tl, String text) {
		String result = "";
		
		StringBuilder url = new StringBuilder(serviceClient.createUrl("Translate?"));
		url.append("from=").append(fl);
		url.append("&to=").append(tl);
		url.append("&text=").append(text);

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Authorization", "Bearer " + accessTokenService.getToken().getAccess_token());

		HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);

		try {
			ResponseEntity<String> response = serviceClient.getRestTemplate().exchange(url.toString(), HttpMethod.GET,
					requestEntity, String.class);

			result = (String)xStream.fromXML(response.getBody());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public List<String> getLanguagesForTranslate() {
		List<String> languagesForTranslate = new ArrayList<String>();
		
		StringBuilder url = new StringBuilder(serviceClient.createUrl("GetLanguagesForTranslate"));		

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Authorization", "Bearer " + accessTokenService.getToken().getAccess_token());

		HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);
		
		try {
			ResponseEntity<String> response = serviceClient.getRestTemplate().exchange(url.toString(), HttpMethod.GET,
					requestEntity, String.class);			

			languagesForTranslate = (ArrayList<String>) xStreamArray.fromXML(response.getBody());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return languagesForTranslate;
	}
	
}
