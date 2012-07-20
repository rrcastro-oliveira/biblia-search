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
}
