package santes.toni.bibliasearch;

import santes.toni.bibliasearch.lucene.BibliaSearcherLucene;


public class BibliaSearcherFactory {
	
	private static BibliaSearcher instance = null;
	
	private BibliaSearcherFactory(){}
	
	public static BibliaSearcher get() {
		if (instance == null) {
			instance = new BibliaSearcherLucene();
		}
		
		return instance;	
	}
	
	public static void main(String[] args) {
		long l1 = System.currentTimeMillis();
		BibliaResults results = BibliaSearcherFactory.get().getLivro(Livro.GENESIS);
		Versiculo v = results.next();
		while (v != null) {
			System.out.println(v.getTexto());
			v = results.next();
		}
		results.close();
			
		System.out.println("levou: " + (System.currentTimeMillis()-l1));
	}
}
