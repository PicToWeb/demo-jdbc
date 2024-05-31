package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {


	
	@Override
	public List<Fournisseur> extraireAll(Connection connection) {

		ArrayList<Fournisseur> listeFounisseurs = new ArrayList<>();
		PreparedStatement stat = null;

		try {
			connection.setAutoCommit(false);

			stat = connection.prepareStatement("SELECT * FROM FOURNISSEUR");
			
			ResultSet resultat = stat.executeQuery();
			while (resultat.next()) {
				Fournisseur f = new Fournisseur(resultat.getInt("id"), resultat.getString("nom"));
				listeFounisseurs.add(f);
			}

			connection.commit();
			resultat.close();

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				stat.close();
				connection.rollback();
			} catch (SQLException e) {

				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}

		return listeFounisseurs;

	}

	@Override
	public List<Fournisseur> extraire(Connection connection, int id) {

		ArrayList<Fournisseur> listeFounisseurs = new ArrayList<>();
		PreparedStatement stat = null;

		try {
			connection.setAutoCommit(false);

			stat = connection.prepareStatement("SELECT * FROM FOURNISSEUR WHERE ID=?");
			stat.setInt(1, id);
			ResultSet resultat = stat.executeQuery();
			while (resultat.next()) {
				Fournisseur f = new Fournisseur(resultat.getInt("id"), resultat.getString("nom"));
				listeFounisseurs.add(f);
			}

			connection.commit();
			resultat.close();

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				stat.close();
				connection.rollback();
			} catch (SQLException e) {

				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}

		return listeFounisseurs;

	}

	@Override
	public void insert(Connection connection, Fournisseur fournisseur) {
		PreparedStatement stat = null;
		try {

			connection.setAutoCommit(false);

			stat = connection.prepareStatement("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (?,?)");
			stat.setInt(1, fournisseur.getId());
			stat.setString(2, fournisseur.getNom());

			stat.executeUpdate();
			connection.commit();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				stat.close();
				connection.rollback();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public int update(Connection connection, String ancienNom, String nouveauNom) {
		int nb = 0;
		PreparedStatement stat = null;
		try {

			connection.setAutoCommit(false);
			stat = connection.prepareStatement("UPDATE FOURNISSEUR SET NOM =? WHERE NOM=?");
			stat.setString(1, nouveauNom);
			stat.setString(2, ancienNom);
			nb = stat.executeUpdate();
			connection.commit();
			stat.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				stat.close();
				connection.rollback();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return nb;
	}

	@Override
	public boolean delete(Connection connection, Fournisseur fournisseur) {
		boolean verif = false;
		PreparedStatement stat = null;
		try {

			
			connection.setAutoCommit(false);
			stat = connection.prepareStatement("DELETE FROM FOURNISSEUR WHERE ID=?");
			stat.setInt(1, fournisseur.getId());
			int nb = stat.executeUpdate();
			connection.commit();
			if (nb == 1) {
				verif = true;
			}

			stat.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				stat.close();
				connection.rollback();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return verif;
	}

}
