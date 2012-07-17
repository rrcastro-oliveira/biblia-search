package santes.toni.bibliasearch.lucene;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;

import santes.toni.bibliasearch.BibliaResults;
import santes.toni.bibliasearch.Versiculo;

class BibliaResultsLucene implements BibliaResults {

	private ScoreDoc[] hits;
	private IndexSearcher searcher;
	private int count = 0;

	public BibliaResultsLucene(Query query, Directory index) throws Exception {
	    int hitsPerPage = 100000;
	    searcher = new IndexSearcher(index, true);
	    TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
	    searcher.search(query, collector);
	    hits = collector.topDocs().scoreDocs;
	}
	
	
	@Override
	public Versiculo next() {
		if (count >= hits.length)
    		return null;
    	
    	int docId = hits[count++].doc;
	    try {
			Document d = searcher.doc(docId);
			int livro = Integer.parseInt(d.get(IndexadorBiblia.LIVRO));
			int cap = Integer.parseInt(d.get(IndexadorBiblia.CAP));
			int nver = Integer.parseInt(d.get(IndexadorBiblia.NVER));
			String versao = d.get(IndexadorBiblia.VERSAO);
			String content = d.get(IndexadorBiblia.CONTENT);
			
			Versiculo versiculo = new Versiculo();
			versiculo.setLivro(livro);
			versiculo.setCap(cap);
			versiculo.setNvers(nver);
			versiculo.setVersao(versao);
			versiculo.setTexto(content);
			return versiculo;
			
		} catch (Exception e) {
			//FIXME Log
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void close() {
		try {
			searcher.close();
		} catch (IOException e) {
			//FIXME Log 
			e.printStackTrace();
		}
	}

}
