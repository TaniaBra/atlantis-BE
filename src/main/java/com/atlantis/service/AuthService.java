package com.atlantis.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atlantis.model.Utente;
import com.atlantis.repository.AuthRepository;

@Service
public class AuthService {
	
	@Autowired
	AuthRepository authRepository;

	public void deleteUtenteById(String id) throws NumberFormatException, SQLException {
		authRepository.deleteUtenteById(Integer.parseInt(id));
		
	}

	public Utente registraUtente(Utente utente) throws SQLException {
		return authRepository.registraUtente(utente);
		
	}

	public void updateUtenteById(Utente utente) throws SQLException {
		authRepository.updateUtenteById(utente);
		
	}

	public Utente ricercaUtente(String username, String password) throws SQLException {
		return authRepository.ricercaUtente(username, password);
		
	}

	public void riactivatedUtenteById(String id) throws NumberFormatException, SQLException {
		authRepository.riactivatedUtenteById(Integer.parseInt(id));
		
	}

}
