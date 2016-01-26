package net.kadirderer.translator.web.util;

public enum Languages {
	
	EN("label.languages.en", "en"),
	TR("label.languages.tr", "tr"),
	ZH("label.languages.zh", "zh"),;
	
	private String code;
	private String i18nKey;
	
	private Languages(String i18nKey, String code) {
		this.i18nKey = i18nKey;
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getI18nKey() {		
		return this.i18nKey;
	}

}
