package santes.toni.bibliasearch;

public interface BibliaSearcher {
	BibliaResults search(String params, Versao versao);
	BibliaResults search(String params);
	BibliaResults getLivro(Livro livro, Versao versao);
	BibliaResults getLivro(Livro livro);
	BibliaResults getCapitulo(Livro livro, int cap, Versao versao);
	BibliaResults getCapitulo(Livro livro, int cap);
	BibliaResults getVersiculo(Livro livro, int cap, int nver, Versao versao);
	BibliaResults getVersiculo(Livro livro, int cap, int nver);
}
