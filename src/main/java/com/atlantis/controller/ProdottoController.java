package com.atlantis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atlantis.model.Prodotto;
import com.atlantis.service.ProdottoService;

@RestController
public class ProdottoController {

	ProdottoService prodottoService;

	@Autowired
	public ProdottoController(ProdottoService prodottoService) {
		this.prodottoService = prodottoService;
	}

	@GetMapping(value = "categoria/{idCategoria}/prodotti")
	@CrossOrigin
	@ResponseBody
	public List<Prodotto> getProdottiByIdCategoria(@PathVariable String idCategoria) {

		List<Prodotto> prodotti = null;

		try {
			prodotti = prodottoService.getProdottiByIdCategoria(idCategoria);
			System.out.println(prodotti);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return prodotti;
	}

	@GetMapping(value = "categoria/{idCategoria}/prodotti/{idProdotto}")
	@CrossOrigin
	@ResponseBody
	public Prodotto getProdottoById(@PathVariable String idCategoria, @PathVariable String idProdotto) {

		Prodotto prodotto = null;

		try {
			prodotto = prodottoService.getProdottoById(idProdotto);
			System.out.println(prodotto);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return prodotto;
	}

	@DeleteMapping(value = "prodotti/delete")
	@CrossOrigin
	@ResponseBody
	public void deleteProdottoById(@RequestParam String id) {
		try {
			prodottoService.deleteProdottoById(id);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

	@PutMapping(value = "prodotti/update")
	@CrossOrigin
	@ResponseBody
	public void updateProdottoById(@RequestBody Prodotto prodotto) {

		try {
			prodottoService.updateProdottoById(prodotto);
			System.out.println(prodotto);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	@PostMapping(value = "prodotti/insert")
	@CrossOrigin
	@ResponseBody
	public Prodotto insertProdotto(@RequestBody Prodotto prodotto) {
		
		try {
			prodotto = prodottoService.insertProdotto(prodotto);
			System.out.println(prodotto);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		return prodotto;
		
	}
}
