package net.kadirderer.translator.web.dto;

public class TranslateRequest {
	
	private String fl;
	private String tl;
	private String text;
	
	public String getFl() {
		return fl;
	}
	
	public void setFl(String fl) {
		this.fl = fl;
	}
	
	public String getTl() {
		return tl;
	}
	
	public void setTl(String tl) {
		this.tl = tl;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}	

}
