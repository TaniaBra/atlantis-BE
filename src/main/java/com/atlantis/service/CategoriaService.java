package com.atlantis.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atlantis.model.Categoria;
import com.atlantis.model.Prodotto;
import com.atlantis.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	
	//TUTTE LE CATEGORIE
	public List<Categoria> getCategorieAll() throws SQLException {
		
		return categoriaRepository.getCategorieAll();
	}
	
	
	//UNA SOLA CATEGORIA
	public Categoria getCategoriaById(String id) throws SQLException {
		
		return categoriaRepository.getCategoriaById(Integer.parseInt(id));
	}


	//DELETE CATEGORIA
	public void deleteCategoriaById(String id) throws NumberFormatException, SQLException {
		categoriaRepository.deleteCategoriaById(Integer.parseInt(id));
		
	}


	//UPDATE CATEGORIA
	public void updateCategoriaById(Categoria categoria) throws NumberFormatException, SQLException {
		categoriaRepository.updateCategoriaById(categoria);
	

}

	//INSERT CATEGORIA
	public Categoria insertCategoria(Categoria categoria) throws SQLException {
		return categoriaRepository.insertCategoria(categoria);
	}
}
