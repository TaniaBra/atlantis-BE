package com.atlantis.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atlantis.model.Categoria;
import com.atlantis.model.Database;
import com.atlantis.model.Prodotto;

@Repository
public class CategoriaRepository {

	// mi richiamo il database così posso richimarne i metodi all'interno di questa
	// classe
	@Autowired
	Database db;

	// metodo per leggere tutte le categorie
	public List<Categoria> getCategorieAll() throws SQLException {

		List<Categoria> categorie = null;

		String query = "select * from categorie";
		try (PreparedStatement ps = db.getConnection().prepareStatement(query); ResultSet rs = ps.executeQuery();) {

			categorie = mapCategorie(rs);

		}
		return categorie;
	}

	// metodo per mappare 1 sola categoria
	// scope di visibilità - Tipo (ho la classe categoria, è il mio oggetto) - nome
	// del metodo - (come paramentro gli passo il resultset che incapsula il
	// risultato della query)
	private Categoria mapCategoria(ResultSet rs) throws SQLException {

		// me la istanzio a null così se mi esce null a console so che non è entrato nel
		// try (me lo tengo come controllo)
		Categoria categoria = null;

		if (rs.next()) {
			categoria = new Categoria();
			categoria.setId(rs.getInt(1));
			categoria.setNome(rs.getString(2));
			categoria.setUrlImmagine(rs.getString(3));
			categoria.setColore(rs.getString(4));

		}
		return categoria;
	}

	// metodo per mappare TUTTE le categorie
	// mi creo una lista di tipo categoria e la riempio con tutte le categorie che
	// ho
	private List<Categoria> mapCategorie(ResultSet rs) throws SQLException {

		List<Categoria> categorie = new ArrayList<>();

		while (rs.next()) {
			Categoria categoria = new Categoria();
			categoria.setId(rs.getInt(1));
			categoria.setNome(rs.getString(2));
			categoria.setUrlImmagine(rs.getString(3));
			categoria.setColore(rs.getString(4));

			categorie.add(categoria);

		}
		return categorie;
	}

	// GET PER ID DELLA CATEGORIA
	public Categoria getCategoriaById(int id) throws SQLException {

		Categoria categoria = null;

		String query = "select * from categorie where id = ?";
		try (PreparedStatement ps = db.getConnection().prepareStatement(query)) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			categoria = mapCategoria(rs);

			rs.close();

		}
		return categoria;
	}

	// DELETE CATEGORIA
	public void deleteCategoriaById(int id) throws SQLException {
		String query = "delete from categorie where id = ? ";
		try (PreparedStatement ps = db.getConnection().prepareStatement(query)) {

			ps.setInt(1, id);
			ps.executeUpdate();

		}

	}

	// UPDATE CATEGORIA
	public void updateCategoriaById(Categoria categoria) throws SQLException {

		String query = "update categorie set nome = ?, url_immagine = ?, colore = ? where id = ?";
		try (PreparedStatement ps = db.getConnection().prepareStatement(query)) {

			ps.setString(1, categoria.getNome());
			ps.setString(2, categoria.getUrlImmagine());
			ps.setString(3, categoria.getColore());
			ps.setInt(4, categoria.getId());

			ps.executeUpdate() ;

			

		}
		
	}

	// INSERT CATEGORIA
	public Categoria insertCategoria(Categoria categoria) throws SQLException {

		String query = "insert into categorie(nome, url_immagine, colore) values (?,?,?)";
		try (PreparedStatement ps = db.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS)) {

			ps.setString(1, categoria.getNome());
			ps.setString(2, categoria.getUrlImmagine());
			ps.setString(3, categoria.getColore());
			ps.executeUpdate();

			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {

					int generatedId = rs.getInt(1);
					categoria.setId(generatedId);
				}
			}

		}
		return categoria;
	}

}
