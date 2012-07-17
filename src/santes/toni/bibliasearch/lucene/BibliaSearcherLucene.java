package santes.toni.bibliasearch.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.br.BrazilianAnalyzer;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;

import santes.toni.bibliasearch.BibliaResults;
import santes.toni.bibliasearch.BibliaSearcher;
import santes.toni.bibliasearch.BibliaSearcherException;
import santes.toni.bibliasearch.Livro;
import santes.toni.bibliasearch.Versao;

public class BibliaSearcherLucene implements BibliaSearcher {

	private static Versao VERSAO_PADRAO = Versao.ACF;
	private BrazilianAnalyzer analyzer;
	private Directory index;

	public BibliaSearcherLucene() {
		try {
			index = new SimpleFSDirectory(new File("teste_index"));
		} catch (IOException e) {
			//FIXME Log
			throw new BibliaSearcherException(e);
		}
		analyzer = new BrazilianAnalyzer(Version.LUCENE_36, BrazilianAnalyzer.getDefaultStopSet());
	}
	
	@Override
	public BibliaResults search(String params, Versao versao) {
		try {
			String s = "versao:" + versao.getSrt() + " AND " + "content:" + params;
			Query q = new QueryParser(Version.LUCENE_36, "",  analyzer).parse(s);
			return new BibliaResultsLucene(q, index);
		} catch (Exception e) {
			//FIXME log
			throw new BibliaSearcherException(e);
		}
	}

	@Override
	public BibliaResults search(String params) {
		return search(params, VERSAO_PADRAO);
	}

	@Override
	public BibliaResults getLivro(Livro livro, Versao versao) {
		try {
			String s = "versao:" + versao.getSrt() + " AND " + "livro:" + livro.getId();
			Query q = new QueryParser(Version.LUCENE_36, "",  analyzer).parse(s);
			return new BibliaResultsLucene(q, index);
		} catch (Exception e) {
			//FIXME log
			throw new BibliaSearcherException(e);
		}
	}

	@Override
	public BibliaResults getLivro(Livro livro) {
		return getLivro(livro, VERSAO_PADRAO);
	}

	@Override
	public BibliaResults getCapitulo(Livro livro, int cap, Versao versao) {
		try {
			String s = "versao:" + versao.getSrt() + " AND " + "livro:" + livro.getId() + " AND cap:" + cap;
			Query q = new QueryParser(Version.LUCENE_36, "",  analyzer).parse(s);
			return new BibliaResultsLucene(q, index);
		} catch (Exception e) {
			//FIXME log
			throw new BibliaSearcherException(e);
		}
	}

	@Override
	public BibliaResults getCapitulo(Livro livro, int cap) {
		return getCapitulo(livro, cap, VERSAO_PADRAO);
	}

	@Override
	public BibliaResults getVersiculo(Livro livro, int cap, int nver,
			Versao versao) {
		try {
			String s = "versao:" + versao.getSrt() + " AND " + "livro:" + livro.getId() + " AND cap:" + cap + " AND nver:" + nver;
			Query q = new QueryParser(Version.LUCENE_36, "",  analyzer).parse(s);
			return new BibliaResultsLucene(q, index);
		} catch (Exception e) {
			//FIXME log
			throw new BibliaSearcherException(e);
		}
	}

	@Override
	public BibliaResults getVersiculo(Livro livro, int cap, int nver) {
		return getVersiculo(livro, cap, nver, VERSAO_PADRAO);
	}

}
