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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atlantis.model.Categoria;
import com.atlantis.service.CategoriaService;

@RestController
public class CategoriaController {

	CategoriaService categoriaService;

	@Autowired
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	
	
	@GetMapping(value = "categorie")
	@CrossOrigin
	@ResponseBody
	public List<Categoria> getCategorieAll() {

		List<Categoria> categorie = null;

		try {
			categorie = categoriaService.getCategorieAll();
			System.out.println(categorie);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return categorie;
	}
	
	@GetMapping(value = "categoria/{idCategoria}")
	@ResponseBody
	@CrossOrigin
	public Categoria getCategoriaById(@PathVariable String idCategoria) {

		Categoria categoria = null;

		try {
			categoria = categoriaService.getCategoriaById(idCategoria);
			System.out.println(categoria);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return categoria;
	}
	
	@DeleteMapping(value = "categoria/delete")
	@ResponseBody
	@CrossOrigin
	public void deleteCategoriaById(@RequestParam String id) {
		try {
			categoriaService.deleteCategoriaById(id);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}
	
	@PutMapping(value = "categoria/update")
	@ResponseBody
	@CrossOrigin
	public void updateCategoriaById(@RequestBody Categoria categoria) {

	
		try {
			categoriaService.updateCategoriaById(categoria);
			System.out.println(categoria);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@PostMapping(value = "categoria/insert")
	@ResponseBody
	@CrossOrigin
	public Categoria insertCategoria(@RequestBody Categoria categoria) {
	
		
		try {
			categoria = categoriaService.insertCategoria(categoria);
			System.out.println(categoria);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		return categoria;
		
	}

}
