package com.atlantis.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atlantis.model.Prodotto;
import com.atlantis.repository.ProdottoRepository;

@Service(value = "prodottoService")
public class ProdottoService {

	@Autowired
	ProdottoRepository prodottoRepository;

	// METODI GET

	// TUTTI I PRODOTTI DI TUTTE LE CATEGORIE
	public List<Prodotto> getProdottiAll() throws SQLException {

		return prodottoRepository.getProdottiAll();
	}

	// TUTTI I PRODOTTI DI UNA SOLA CATEGORIA
	public List<Prodotto> getProdottiByIdCategoria(String idCategoria) throws SQLException {

		return prodottoRepository.getProdottiByIdCategoria(Integer.parseInt(idCategoria));
	}

	// UN SOLO PRODOTTO
	public Prodotto getProdottoById(String id) throws SQLException {

		return prodottoRepository.getProdottoById(Integer.parseInt(id));
	}

	// DELETE UN SOLO PRODOTTO
	public void deleteProdottoById(String id) throws NumberFormatException, SQLException {
		prodottoRepository.deleteProdottoById(Integer.parseInt(id));

	}

	// UPDATE PRODOTTO
	public void updateProdottoById(Prodotto prodotto) throws NumberFormatException, SQLException {

		prodottoRepository.updateProdottoById(prodotto);

	}

	// INSERT PRODOTTO
	public Prodotto insertProdotto(Prodotto prodotto) throws SQLException {

		return prodottoRepository.insertProdotto(prodotto);
	}

}
