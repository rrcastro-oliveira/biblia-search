package santes.toni.bibliasearch;


public enum Livro {
	
	GENESIS(1, "gn", "gen", "genesis", "gênesis"),
	EXODO(2, "ex", "exo", "exodo", "êxodo"),
	LEVITICO(3, "lv", "lev", "levitico", "levítico"),
	NUMEROS(4, "nm", "num", "numeros", "números"),
	DEUTERONOMIO(5, "dt", "deuteronomio", "deuteronômio"),
	JOSUE(6, "js", "jos", "josue", "josué"),
	JUIZES(7, "jz", "jui", "juizes"),
	RUTE(8, "rt", "rut", "rute"),
	I_SAMUEL(9, "1sm", "1sam", "1samuel"), 
	II_SAMUEL(10, "2sm", "2sam", "2samuel"),
	I_REIS(11, "1rs", "1re", "1reis"),
	II_REIS(12,"2rs", "2re", "2reis"), 
	I_CRONICAS(13, "1cr", "1cro", "1cronicas"),
	II_CRONICAS(14, "2cr", "2cro", "2cronicas"),
	ESDRAS(15, "es", "esd", "esdras"),
	NEEMIAS(16, "ne", "neem", "neemias"),
	ESTER(17, "et", "est", "ester"),
	JO(18, "jó"),
	SALMOS(19, "sl", "salm", "salmos"),
	PROVERBIOS(20, "pv", "pro", "prov", "proverbios"),
	ECLESIASTES(21,"ec", "ecles", "eclesiastes"),
	CANTARES(22, "ct", "cant", "cantares"),
	ISAIAS(23, "is", "isa", "isaias"),
	JEREMIAS(24, "jr", "jer", "jerem", "jeremias"),
	LAMENTACOES(25, "lm", "lam", "lamentacoes", "lamentações"),
	EZEQUIEL(26, "ez", "eze", "ezeq", "ezequiel"),
	DANIEL(27, "dn", "dan", "daniel"),
	OSEIAS(28, "os", "ose", "oseias", "oséias"),
	JOEL(29, "jl", "joe", "joel"),
	AMOS(30, "am", "amos", "amós"),
	OBADIAS(31, "ob", "oba", "obad", "obadias"),
	JONAS(32, "jn", "jon", "jonas"),
	MIQUEIAS(33, "mq", "miq", "miqueias", "miquéias"),
	NAUM(34, "na", "naum"),
	HABACUQUE(35, "hc", "hab", "habac", "habacuque"),
	SOFONIAS(36, "sf", "sof", "sofonias"),
	AGEU(37, "ag", "age", "ageu"),
	ZACARIAS(38, "zc", "zac", "zacar", "zacarias"),
	MALAQUIAS(39, "ml", "mal", "malaq", "malaquias"), 
	MATEUS(40, "mt", "mat", "mateus"),
	MARCOS(41, "mc", "mar", "marcos"),
	LUCAS(42, "lc", "luc", "lucas"),
    JOAO(43, "jo", "joao", "joão"),
	ATOS(44, "at", "ato", "atos"),
	ROMANOS(45, "rm", "rom", "roman", "romanos"),
	I_CORINTIOS(46, "1co", "1cor", "1corintios"),
	II_CORINTIOS(47,"2co", "2cor", "2corintios"), 
	GALATAS(48, "gl", "gal", "galat", "galatas"),
	EFESIOS(49, "ef", "efe", "efes", "efesios", "efésios"),
	FILIPENSES(50, "fp", "fil", "filip", "filipenses", "filipênses"),
	COLOSSENSES(51, "cl", "col", "colos", "colossenses", "colossênses"),
	I_TESSALONICENSES(52, "1ts", "1tes", "1tess", "1tessalonicenses"),
	II_TESSALONICENSES(53, "2ts", "2tes", "2tess", "2tessalonicenses"),
	I_TIMOTEO(54, "1tm", "1tim", "1timoteo", "1timóteo"),
	II_TIMOTEO(55, "2tm", "2tim", "2timoteo", "2timóteo"),
	TITO(56, "tt", "tit", "tito"),
	FILEMON(57, "fl", "filem", "filemon"),
	HEBREUS(58, "hb", "heb", "hebreus"),
	TIAGO(59, "tg", "tia", "tiago"),
	I_PEDRO(60, "1pe", "1ped", "1pedro"),
	II_PEDRO(61, "2pe", "2ped", "2pedro"),
	I_JOAO(62, "1jo", "1joao"),
	II_JOAO(63, "2jo", "2joao"),
	III_JOAO(64, "3jo", "3joao"),
	JUDAS(65, "jd", "jud", "judas"),
	APOCALIPSE(66, "ap", "apo", "apocal", "apocalipse", "apocalípse");
	
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
