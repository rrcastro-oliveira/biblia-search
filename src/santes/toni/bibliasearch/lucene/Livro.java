package santes.toni.bibliasearch.lucene;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="livros")
public class Livro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2192722846657594719L;

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Id
	@Column(name="abrev")
	private String abrev;
	
	@Column(name="caps")
	private int caps;
	
	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAbrev() {
		return abrev;
	}

	public void setAbrev(String abrev) {
		this.abrev = abrev;
	}

	public int getCaps() {
		return caps;
	}

	public void setCaps(int caps) {
		this.caps = caps;
	}
	
	
	
}
