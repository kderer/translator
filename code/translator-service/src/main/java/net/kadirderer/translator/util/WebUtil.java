package net.kadirderer.translator.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public final class WebUtil {
	
	public static String encodeTextUTF_8(String text) {		
		try {
			return URLEncoder.encode(text, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

}
