package santes.toni.bibliasearch;

public enum Versao {
	
	ACF("acf"),
	GRE("gre");
	
	private final String srt;

	private Versao(String srt) {
		this.srt = srt;
	}
	
	public String getSrt() {
		return srt;
	}
	
	public static Versao get(String str) {
		for (Versao v : values()) {
			if (v.srt.equalsIgnoreCase(str))
				return v;
		}
		return null;
	}
	
}
