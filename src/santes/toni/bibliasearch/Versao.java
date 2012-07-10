package santes.toni.bibliasearch;

public enum Versao {
	
	ACF("acf");
	
	private final String srt;

	private Versao(String srt) {
		this.srt = srt;
	}
	
	public String getSrt() {
		return srt;
	}
	
}
