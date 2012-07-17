package santes.toni.bibliasearch.lucene;

import java.io.File;

import org.apache.lucene.analysis.br.BrazilianAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;

class SearchTeste {
	public static void main(String[] args) throws Exception {
		Directory index = new SimpleFSDirectory(new File(IndexadorBiblia.PASTA_INDEX));
		
		String s = "livro:1 AND content:diluvio"; 
		BrazilianAnalyzer analyzer = new BrazilianAnalyzer(Version.LUCENE_36, BrazilianAnalyzer.getDefaultStopSet());
		
		Query q = new QueryParser(Version.LUCENE_36, "",  analyzer).parse(s);
		
//		Query q = new MultiFieldQueryParser(Version.LUCENE_36, new String[]{"livro:1", "cap:1"}, analyzer).pa;
//	    Query q =  new WildcardQuery(new Term("content", "verbo")); //new QueryParser(Version.LUCENE_36, "title", analyzer).parse(querystr);
	    
		
	    // 3. search
	    int hitsPerPage = 10000;
	    IndexSearcher searcher = new IndexSearcher(index, true);
	    TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
	    searcher.search(q, collector);
	    ScoreDoc[] hits = collector.topDocs().scoreDocs;
	    
	    // 4. display results
	    System.out.println("Found " + hits.length + " hits.");
	    for(int i=0;i<hits.length;++i) {
	      int docId = hits[i].doc;
	      Document d = searcher.doc(docId);
	      System.out.println((i + 1) + ". " + d.get("content"));
	    }

	    // searcher can only be closed when there
	    // is no need to access the documents any more. 
	    searcher.close();
	}
}
