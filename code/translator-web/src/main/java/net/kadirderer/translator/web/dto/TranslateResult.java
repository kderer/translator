package net.kadirderer.translator.web.dto;

public class TranslateResult {
	
	private TranslateRequest request;
	
	private String text;
	private String resultPinyin;
	private String requestPinyin;
	
	public TranslateResult(TranslateRequest request) {
		super();
		this.request = request;
	}

	public TranslateRequest getRequest() {
		return request;
	}
	
	public void setRequest(TranslateRequest request) {
		this.request = request;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String resultText) {
		this.text = resultText;
	}
	
	public String getResultPinyin() {
		return resultPinyin;
	}
	
	public void setResultPinyin(String resultPinyin) {
		this.resultPinyin = resultPinyin;
	}
	
	public String getRequestPinyin() {
		return requestPinyin;
	}
	
	public void setRequestPinyin(String requestPinyin) {
		this.requestPinyin = requestPinyin;
	}

}
