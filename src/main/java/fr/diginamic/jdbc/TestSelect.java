package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect {

	public static void main(String[] args) {
		ResourceBundle config = ResourceBundle.getBundle("fichier");
		String url = config.getString("database.url");
		String user = config.getString("database.user");
		String pass = config.getString("database.pass");
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection connection = DriverManager.getConnection(url,user,pass);
			
			Statement stat = connection.createStatement();
			ArrayList<Fournisseur> listeFounisseurs = new ArrayList<>();
			ResultSet resultat = stat.executeQuery("SELECT * FROM FOURNISSEUR");
			
			while(resultat.next()) {
				Fournisseur f = new Fournisseur(resultat.getInt("id"),resultat.getString("nom"));
				listeFounisseurs.add(f);
			}
			
			listeFounisseurs.forEach(f->System.out.println(f.toString()));
		
			
			resultat.close();
			
			stat.close();
			
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
