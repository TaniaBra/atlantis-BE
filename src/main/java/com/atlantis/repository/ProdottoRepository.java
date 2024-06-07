package com.atlantis.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atlantis.model.Database;
import com.atlantis.model.Prodotto;
import com.atlantis.service.ProdottoService;

@Repository
public class ProdottoRepository {

	@Autowired
	Database db;

	// metodo per leggere i prodotti
	public List<Prodotto> getProdottiAll() throws SQLException {

		List<Prodotto> prodotti = null;

		String query = "select * from prodotti";
		try (PreparedStatement ps = db.getConnection().prepareStatement(query); ResultSet rs = ps.executeQuery();) {

			prodotti = mapProdotti(rs);

		}
		return prodotti;
	}

	// metodo per mappare 1 solo prodotto
	private Prodotto mapProdotto(ResultSet rs) throws SQLException {

		Prodotto prodotto = null;

		if (rs.next()) {
			prodotto = new Prodotto();
			prodotto.setId(rs.getInt(1));
			prodotto.setNome(rs.getString(2));
			prodotto.setDescrizioneBreve(rs.getString(3));
			prodotto.setDescrizioneLunga(rs.getNString(4));
			prodotto.setDisponibilita(rs.getInt(5));
			prodotto.setPrezzo(rs.getDouble(6));
			prodotto.setIdCategoria(rs.getInt(7));
			prodotto.setUrlImmagine(rs.getString(8));

		}
		return prodotto;
	}

	// metodo per mappare tutti i prodotti
	private List<Prodotto> mapProdotti(ResultSet rs) throws SQLException {

		List<Prodotto> prodotti = new ArrayList<>();

		while (rs.next()) {
			Prodotto prodotto = new Prodotto();

			prodotto.setId(rs.getInt(1));
			prodotto.setNome(rs.getString(2));
			prodotto.setDescrizioneBreve(rs.getString(3));
			prodotto.setDescrizioneLunga(rs.getNString(4));
			prodotto.setDisponibilita(rs.getInt(5));
			prodotto.setPrezzo(rs.getDouble(6));
			prodotto.setIdCategoria(rs.getInt(7));
			prodotto.setUrlImmagine(rs.getString(8));

			prodotti.add(prodotto);
		}

		return prodotti;

	}

	// GET PER CATEGORIA
	public List<Prodotto> getProdottiByIdCategoria(int idCategoria) throws SQLException {

		List<Prodotto> prodotti = null;

		String query = "select * from prodotti where id_categoria = ?";
		try (PreparedStatement ps = db.getConnection().prepareStatement(query)) {

			ps.setInt(1, idCategoria);
			ResultSet rs = ps.executeQuery();

			prodotti = mapProdotti(rs);

			rs.close();

		}
		return prodotti;

	}

	// GET PER ID DEL PRODOTTO
	public Prodotto getProdottoById(int id) throws SQLException {

		Prodotto prodotto = null;

		String query = "select * from prodotti where id = ?";
		try (PreparedStatement ps = db.getConnection().prepareStatement(query)) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			prodotto = mapProdotto(rs);

			rs.close();

		}
		return prodotto;
	}

	// DELETE PRODOTTO
	public void deleteProdottoById(int id) throws SQLException {

		String query = "delete from prodotti where id = ? ";
		try (PreparedStatement ps = db.getConnection().prepareStatement(query)) {

			ps.setInt(1, id);
			ps.executeUpdate();

		}

	}

	// UPDATE PRODOTTO
	public void updateProdottoById(Prodotto prodotto) throws SQLException {

		String query = "update prodotti set nome = (?), descrizione_breve = ?, descrizione_lunga = ?, disponibilita = ?, prezzo = ?, id_categoria = ?, url_immagine = ? where id = ?";
		try (PreparedStatement ps = db.getConnection().prepareStatement(query)) {

			ps.setString(1, prodotto.getNome());
			ps.setString(2, prodotto.getDescrizioneBreve());
			ps.setString(3, prodotto.getDescrizioneLunga());
			ps.setInt(4, prodotto.getDisponibilita());
			ps.setDouble(5, prodotto.getPrezzo());
			ps.setInt(6, prodotto.getIdCategoria());
			ps.setString(7, prodotto.getUrlImmagine());
			ps.setInt(8, prodotto.getId());

			ps.executeUpdate();

		}

	}

	// INSERT PRODOTTO
	public Prodotto insertProdotto(Prodotto prodotto) throws SQLException {
		String query = "insert into prodotti(nome, descrizione_breve, descrizione_lunga, disponibilita, prezzo, id_categoria, url_immagine) values (?,?,?,?,?,?,?)";
		try (PreparedStatement ps = db.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, prodotto.getNome());
			ps.setString(2, prodotto.getDescrizioneBreve());
			ps.setString(3, prodotto.getDescrizioneLunga());
			ps.setInt(4, prodotto.getDisponibilita());
			ps.setDouble(5, prodotto.getPrezzo());
			ps.setInt(6, prodotto.getIdCategoria());
			ps.setString(7, prodotto.getUrlImmagine());

			ps.executeUpdate();

			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {

					int generatedId = rs.getInt(1);
					prodotto.setId(generatedId);
				}
			}
		}
		return prodotto;
	}

}
