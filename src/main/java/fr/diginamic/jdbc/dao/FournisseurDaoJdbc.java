package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {

	public static void jdbcModif() {

	}

	@Override
	public List<Fournisseur> extraire(Connection connection) {

		ArrayList<Fournisseur> listeFounisseurs = new ArrayList<>();

		try {

			Statement stat = connection.createStatement();

			ResultSet resultat = stat.executeQuery("SELECT * FROM FOURNISSEUR");

			while (resultat.next()) {
				Fournisseur f = new Fournisseur(resultat.getInt("id"), resultat.getString("nom"));
				listeFounisseurs.add(f);
			}

			resultat.close();

			stat.close();

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return listeFounisseurs;

	}

	@Override
	public void insert(Connection connection, Fournisseur fournisseur) {
		try {

			Statement stat = connection.createStatement();
			stat.executeUpdate("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (" + fournisseur.getId() + ",\""
					+ fournisseur.getNom() + "\")");

			stat.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public int update(Connection connection, String ancienNom, String nouveauNom) {
		int nb = 0;
		try {

			Statement stat = connection.createStatement();
			nb = stat.executeUpdate(
					"UPDATE FOURNISSEUR SET NOM = \"" + nouveauNom + "\" WHERE NOM=\"" + ancienNom + "\"");

			stat.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return nb;
	}

	@Override
	public boolean delete(Connection connection, Fournisseur fournisseur) {
		boolean verif = false;
		try {

			Statement stat = connection.createStatement();
			int nb = stat.executeUpdate("DELETE FROM FOURNISSEUR WHERE ID=" + fournisseur.getId() + "");

			if (nb == 1) {
				verif = true;
			}

			stat.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return verif;
	}

}
