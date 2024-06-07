package com.atlantis.model;

import java.sql.Date;

public class Utente {

	private int id;
	private String nome;
	private String cognome;
	private Date dateOfBirth;
	private String email;
	private boolean admin;
	private String username;
	private String password;
	private boolean disabilitato;

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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isDisabilitato() {
		return disabilitato;
	}

	public void setDisabilitato(boolean disabilitato) {
		this.disabilitato = disabilitato;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dateOfBirth=" + dateOfBirth
				+ ", email=" + email + ", admin=" + admin + ", username=" + username + ", password=" + password
				+ ", isdisabilitato=" + disabilitato + "]";
	}



}
