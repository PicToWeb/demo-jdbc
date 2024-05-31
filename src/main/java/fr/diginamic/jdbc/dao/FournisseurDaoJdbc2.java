package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc2 implements GenericDao<Fournisseur> {

	private Connection connection;

	public FournisseurDaoJdbc2() {
		ResourceBundle databaseConfig = ResourceBundle.getBundle("fichier");

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			this.connection = DriverManager.getConnection(databaseConfig.getString("database.url"),
					databaseConfig.getString("database.user"), databaseConfig.getString("database.pass"));
		} catch (SQLException e) {
			e.printStackTrace();
			closeConnection();
		}
	}

	/**
	 * Constructor
	 * 
	 * @param connection
	 */
	public FournisseurDaoJdbc2(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Fournisseur> extraire() {

		try (Statement selectStatement = connection.createStatement();) {
			ResultSet resultSet = selectStatement.executeQuery("SELECT id,nom FROM FOURNISSEUR");

			List<Fournisseur> fournisseurs = new ArrayList<>();
			while (resultSet.next()) {
				fournisseurs.add(new Fournisseur(resultSet.getInt("id"), resultSet.getString("nom")));
			}
			selectStatement.close();
			return fournisseurs;
		} catch (Exception e) {
			e.printStackTrace();
			closeConnection();
		}
		return new ArrayList<>();
	}

	@Override
	public void insert(Fournisseur nvObjet) {
		try(PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (?,?)");){
			insertStatement.setInt(1,nvObjet.getId());
			insertStatement.setString(2,nvObjet.getNom());
			insertStatement.executeUpdate();
			
			insertStatement.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(int id, Fournisseur nvObjet) {
		// TODO Auto-generated method stub

	}
	@Override
	public void update2(String ancienNom, String nouveauNom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	private void closeConnection() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
