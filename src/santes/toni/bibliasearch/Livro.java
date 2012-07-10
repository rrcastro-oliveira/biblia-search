package santes.toni.bibliasearch;

enum Livro {
	
	GENESIS(1, "gn", "gen", "genesis", "g�nesis"),
	EXODO(2, "ex", "exo", "exodo", "�xodo"),
	LEVITICO(3, "lv", "lev", "levitico", "lev�tico"),
	NUMEROS(4, "nm", "num", "numeros", "n�meros");
	
	private final int id;
	private final String[] strs;

	private Livro(int id, String... strs) {
		this.id = id;
		this.strs = strs;
	}

	public int getId() {
		return id;
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
	
}
