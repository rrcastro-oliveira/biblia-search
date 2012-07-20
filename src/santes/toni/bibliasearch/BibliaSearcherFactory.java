package santes.toni.bibliasearch;

import java.io.File;

import santes.toni.bibliasearch.lucene.BibliaSearcherLucene;


public class BibliaSearcherFactory {
	
	private BibliaSearcher instance = null;
	private File fileIndex;
	
	public BibliaSearcherFactory(File fileIndex){
		this.fileIndex = fileIndex;}
	
	public BibliaSearcher get() {
		if (instance == null) {
			instance = new BibliaSearcherLucene(fileIndex);
		}
		
		return instance;	
	}
	
//	public static void main(String[] args) {
//		long l1 = System.currentTimeMillis();
//		BibliaResults results = new BibliaSearcherFactory(new File("bibliaindex")).get().search("verbo", Versao.ARC);
//		Versiculo v = results.next();
//		while (v != null) {
//			System.out.println(v.getTexto());
//			v = results.next();
//		}
//		results.close();
//			
//		System.out.println("levou: " + (System.currentTimeMillis()-l1));
//	}
}
