package santes.toni.bibliasearch;

import java.io.Serializable;

public class Versiculo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2192722846657594719L;

	private int livro;
	
	private int cap;
	
	private int nvers;
	
	private String texto;
	
	private String versao;
	
	public Versiculo() {
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}
	
	public int getLivro() {
		return livro;
	}

	public void setLivro(int livro) {
		this.livro = livro;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public int getNvers() {
		return nvers;
	}

	public void setNvers(int nvers) {
		this.nvers = nvers;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getVersao() {
		return versao;
	}
	
}
