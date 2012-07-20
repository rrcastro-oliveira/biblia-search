package santes.toni.bibliasearch.lucene;

import java.io.IOException;

public class Indexador {
	public static final String PASTA_INDEX = ".bibliaindex";
	
	public static final String CONTENT = "content";
	public static final String NVER = "nver";
	public static final String CAP = "cap";
	public static final String LIVRO = "livro";
	public static final String VERSAO = "versao";
	
	public static void main(String[] args) throws IOException {
		IndexadorACF.indexar();
		IndexadorARA.indexar();
	}
}
