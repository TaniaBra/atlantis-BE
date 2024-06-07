package com.atlantis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atlantis.model.Utente;
import com.atlantis.service.AuthService;

@RestController
public class AuthController {

	AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping(value = "utenti/ricerca")
	@CrossOrigin
	@ResponseBody
	public Utente ricercaUtente(@RequestBody Utente utente) {
	
		try {
			utente = authService.ricercaUtente(utente.getUsername(), utente.getPassword());
			System.out.println(utente);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return utente;

	}

	@PutMapping(value = "utenti/delete")
	@CrossOrigin
	@ResponseBody
	public void deleteUtenteById(@RequestParam String id) {
		try {
			authService.deleteUtenteById(id);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

	@PutMapping(value = "utenti/riactivated")
	@CrossOrigin
	@ResponseBody
	public void riactivatedUtenteById(@RequestParam String id) {
		try {
			authService.riactivatedUtenteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@PostMapping(value = "utenti/registrazione")
	@CrossOrigin
	@ResponseBody
	public Utente registraUtente(@RequestBody Utente utente) {

		try {
			authService.registraUtente(utente);
			System.out.println(utente);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return utente;
	}

	@PutMapping(value = "utenti/update")
	@CrossOrigin
	@ResponseBody
	public void updateUtenteById(@RequestBody Utente utente) {

		try {
			authService.updateUtenteById(utente);
			System.out.println(utente);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
