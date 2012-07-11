package santes.toni.bibliasearch;


public enum Livro {
	
	GENESIS(1, "gn", "gen", "genesis", "gênesis"),
	EXODO(2, "ex", "exo", "exodo", "êxodo"),
	LEVITICO(3, "lv", "lev", "levitico", "levítico"),
	NUMEROS(4, "nm", "num", "numeros", "números");
	
	private final int id;
	private final String[] strs;

	private Livro(int id, String... strs) {
		this.id = id;
		this.strs = strs;
	}

	public int getId() {
		return id;
	}
	
	public String[] getStrs() {
		return strs;
	}
	
	public static Livro get(String str) {
		for (Livro livro : values()) {
			for (String s : livro.strs) {
				if (s.equalsIgnoreCase(str))
					return livro;
			}
		}
		return null;
	}
	
	public static Livro get(int id) {
		for (Livro l : values()) {
			if (l.id == id)
				return l;
		}
		return null;
	}
	
}
