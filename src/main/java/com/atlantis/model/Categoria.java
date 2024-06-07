package com.atlantis.model;

public class Categoria {
	
	private int id;
	private String nome;
	private String urlImmagine;
	private String colore;
	
	

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
	
	public String getUrlImmagine() {
		return urlImmagine;
	}
	
	public void setUrlImmagine(String urlImmagine) {
		this.urlImmagine = urlImmagine;
	}
	
	public String getColore() {
		return colore;
	}
	
	public void setColore(String colore) {
		this.colore = colore;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", urlImmagine=" + urlImmagine + ", colore=" + colore + "]";
	} 
	

	
	
	
}
