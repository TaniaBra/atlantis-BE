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
import com.atlantis.model.Utente;

@Repository
public class AuthRepository {

	@Autowired
	Database db;

	// metodo per mappare 1 solo utente
	private Utente mapUtente(ResultSet rs) throws SQLException {

		Utente utente = null;

		if (rs.next()) {
			utente = new Utente();
			utente.setId(rs.getInt(1));
			utente.setNome(rs.getString(2));
			utente.setCognome(rs.getString(3));
			utente.setDateOfBirth(rs.getDate(4));
			utente.setEmail(rs.getNString(5));
			utente.setAdmin(rs.getBoolean(6));
			utente.setUsername(rs.getNString(7));
			utente.setPassword(rs.getNString(8));
			utente.setDisabilitato(rs.getBoolean(9));

		}
		return utente;
	}

	// metodo per mappare tutti gli utenti
	private List<Utente> mapUtenti(ResultSet rs) throws SQLException {

		List<Utente> utenti = new ArrayList<>();

		while (rs.next()) {
			Utente utente = new Utente();
			utente = new Utente();
			utente.setId(rs.getInt(1));
			utente.setNome(rs.getString(2));
			utente.setCognome(rs.getString(3));
			utente.setDateOfBirth(rs.getDate(4));
			utente.setEmail(rs.getNString(5));
			utente.setAdmin(rs.getBoolean(6));
			utente.setUsername(rs.getNString(7));
			utente.setPassword(rs.getNString(8));
			utente.setDisabilitato(rs.getBoolean(9));

			utenti.add(utente);
		}

		return utenti;

	}

	public void deleteUtenteById(int id) throws SQLException {

		String query = "update utenti set disabilitato = 1 where id = ?";
		try (PreparedStatement ps = db.getConnection().prepareStatement(query)) {

			ps.setInt(1, id);
			ps.executeUpdate();
		}

	}

	public Utente registraUtente(Utente utente) throws SQLException {
		String query = "insert into utenti(nome, cognome, date_of_birth, email, admin, username, password, disabilitato) values ( ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement ps = db.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

			ps.setString(1, utente.getNome());
			ps.setString(2, utente.getCognome());
			ps.setDate(3, utente.getDateOfBirth());
			ps.setString(4, utente.getEmail());
			ps.setBoolean(5, utente.isAdmin());
			ps.setString(6, utente.getUsername());
			ps.setString(7, utente.getPassword());
			ps.setBoolean(8, utente.isDisabilitato());
			ps.executeUpdate();

			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {

					int generatedId = rs.getInt(1);
					utente.setId(generatedId);
				}
			}

		}
		return utente;
	}

	public void updateUtenteById(Utente utente) throws SQLException {
		String query = "update utenti set nome = ?, cognome = ?, date_of_birth = ?, email = ?, admin = ?, username = ?, password = ?, disabilitato = ? where id = ?";
		try (PreparedStatement ps = db.getConnection().prepareStatement(query)) {

			ps.setString(1, utente.getNome());
			ps.setString(2, utente.getCognome());
			ps.setDate(3, utente.getDateOfBirth());
			ps.setString(4, utente.getEmail());
			ps.setBoolean(5, utente.isAdmin());
			ps.setString(6, utente.getUsername());
			ps.setString(7, utente.getPassword());
			ps.setBoolean(8, utente.isDisabilitato());
			ps.setInt(9, utente.getId());

			ps.executeUpdate();

		}
	}

	public Utente ricercaUtente(String username, String password) throws SQLException {

		Utente utente = null;
		String query = "select * from utenti where username = ? and password = ?";
		try (PreparedStatement ps = db.getConnection().prepareStatement(query)) {

			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			utente = mapUtente(rs);

			rs.close();

		}

		return utente;
	}

	public void riactivatedUtenteById(int id) throws SQLException {
		String query = "update utenti set disabilitato = 0 where id = ?";
		try (PreparedStatement ps = db.getConnection().prepareStatement(query)) {

			ps.setInt(1, id);
			ps.executeUpdate();
		}

	}

}
