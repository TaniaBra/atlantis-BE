package com.atlantis.model;

public class Prodotto {

	private int id;
	private String nome;
	private String descrizioneBreve;
	private String descrizioneLunga;
	private int disponibilita;
	private double prezzo;
	private int idCategoria;
	private String urlImmagine;

	

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

	public String getDescrizioneBreve() {
		return descrizioneBreve;
	}

	public void setDescrizioneBreve(String descrizioneBreve) {
		this.descrizioneBreve = descrizioneBreve;
	}

	public String getDescrizioneLunga() {
		return descrizioneLunga;
	}

	public void setDescrizioneLunga(String descrizioneLunga) {
		this.descrizioneLunga = descrizioneLunga;
	}

	public int getDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getUrlImmagine() {
		return urlImmagine;
	}

	public void setUrlImmagine(String urlImmagine) {
		this.urlImmagine = urlImmagine;
	}
	
	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", descrizioneBreve=" + descrizioneBreve
				+ ", descrizioneLunga=" + descrizioneLunga + ", disponibilita=" + disponibilita + ", prezzo=" + prezzo
				+ ", idCategoria=" + idCategoria + ", urlImmagine=" + urlImmagine + "]";
	}

}
