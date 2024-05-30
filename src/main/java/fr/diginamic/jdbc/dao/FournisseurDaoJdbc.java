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

	static final ResourceBundle config = ResourceBundle.getBundle("fichier");
	static final String URL = config.getString("database.url");
	static final String USER = config.getString("database.user");
	static final String PASS = config.getString("database.pass");
	

	@Override
	public List<Fournisseur> extraire() {
		
		ArrayList<Fournisseur> listeFounisseurs = new ArrayList<>();
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection connection = DriverManager.getConnection(URL, USER, PASS);

			Statement stat = connection.createStatement();
			 
			ResultSet resultat = stat.executeQuery("SELECT * FROM FOURNISSEUR");

			while (resultat.next()) {
				Fournisseur f = new Fournisseur(resultat.getInt("id"), resultat.getString("nom"));
				listeFounisseurs.add(f);
			}

			resultat.close();

			stat.close();

			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return listeFounisseurs;

	}

	@Override
	public void insert(Fournisseur fournisseur) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection connection = DriverManager.getConnection(URL,USER,PASS);
			
			
			Statement stat = connection.createStatement();
			 stat.executeUpdate("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (" + fournisseur.getId()+ ",\""+ fournisseur.getNom()+ "\")");

			
			
			stat.close();
			
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		int nb=0;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection connection = DriverManager.getConnection(URL,USER,PASS);
			
			
			Statement stat = connection.createStatement();
			nb = stat.executeUpdate("UPDATE FOURNISSEUR SET NOM = \"" + nouveauNom + "\" WHERE NOM=\"" + ancienNom + "\"");
			
			
			stat.close();
			
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return nb;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		boolean verif=false;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection connection = DriverManager.getConnection(URL,USER,PASS);
			
			
			Statement stat = connection.createStatement();
			int nb = stat.executeUpdate("DELETE FROM FOURNISSEUR WHERE ID=" + fournisseur.getId() + "");
			
			if (nb==1) {
				verif=true;
			}
			
			stat.close();
			
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return verif;
	}

}
