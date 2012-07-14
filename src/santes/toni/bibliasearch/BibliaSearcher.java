package santes.toni.bibliasearch;


public class BibliaSearcher {
	
	private static BibliaSearcher instance = null;
	private static Versao VERSAO_PADRAO = Versao.ACF;
	
	private BibliaSearcher(){}
	
	public static BibliaSearcher get() {
		if (instance == null) {
			instance = new BibliaSearcher();
		}
		
		return instance;	
	}
	
	public BibliaResults search(String params, Versao versao) {
		return new BibliaResultsImpl(params, versao);
	}
	
	public BibliaResults search(String params) {
		return search(params, VERSAO_PADRAO);
	}
	
	public BibliaResults getLivro(Livro livro, Versao versao) {
		return new BibliaResultsImpl("@" + livro.getStrs()[0], versao);
	}
	
	public BibliaResults getLivro(Livro livro) {
		return getLivro(livro, VERSAO_PADRAO);
	}
	
	public BibliaResults getCapitulo(Livro livro, int cap, Versao versao) {
		return new BibliaResultsImpl("@" + livro.getStrs()[0] + " " + cap, versao);
	}
	
	public BibliaResults getCapitulo(Livro livro, int cap) {
		return new BibliaResultsImpl("@" + livro.getStrs()[0] + " " + cap, VERSAO_PADRAO);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		long l1 = System.currentTimeMillis();
		BibliaResults results = BibliaSearcher.get().getLivro(Livro.GENESIS);
		Versiculo v = results.next();
		while (v != null) {
			System.out.println(v.getTexto());
			v = results.next();
		}
		results.close();
			
		System.out.println("levou: " + (System.currentTimeMillis()-l1));
	}
}
