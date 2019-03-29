package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String parola;
	private boolean giusta;
	public RichWord(String parola, boolean giusta) {
		super();
		this.parola = parola;
		this.giusta = giusta;
	}
	
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public boolean isGiusta() {
		return giusta;
	}
	public void setGiusta(boolean giusta) {
		this.giusta = giusta;
	}

}
