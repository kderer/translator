package net.kadirderer.translator.service;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.kadirderer.translator.client.TranslatorServiceClient;

@Service
public class PinyinService {
	
	@Autowired
	private TranslatorServiceClient pinyinServiceClient;
	
	private final static int START_INDEX = "annotation = '".length();
	private final static String SUFFIX_TO_DROP = "';update_annotation(";
	
	public String getPinyin(String text) {
		StringBuilder url = new StringBuilder(pinyinServiceClient.createUrl(""));
		url.append("?text=").append(text);
		
		try {
			String rawResult = pinyinServiceClient.getRestTemplate().getForObject(url.toString(), String.class);
			rawResult = rawResult.substring(START_INDEX, rawResult.lastIndexOf(SUFFIX_TO_DROP));
			
			return StringEscapeUtils.unescapeHtml4(rawResult);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

}
