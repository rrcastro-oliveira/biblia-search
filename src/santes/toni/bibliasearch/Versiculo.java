package santes.toni.bibliasearch;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="biblia")
public class Versiculo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2192722846657594719L;

	@Id
	@Column(name="liv")
	private int livro;
	
	@Id
	@Column(name="cap")
	private int cap;
	
	@Id
	@Column(name="nver")
	private int nvers;
	
	@Column(name="text")
	private String texto;
	
	@Id
	@Column(name="versao")
	private String versao;
	
	public Versiculo() {
		// TODO Auto-generated constructor stub
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
