package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {

	public static void main(String[] args) {
		ResourceBundle config = ResourceBundle.getBundle("fichier");
		String url = config.getString("database.url");
		String user = config.getString("database.user");
		String pass = config.getString("database.pass");
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection connection = DriverManager.getConnection(url,user,pass);
			
			Statement stat = connection.createStatement();
			int nb = stat.executeUpdate("DELETE FROM FOURNISSEUR WHERE ID=4");

			System.out.println(nb);
			
			
			stat.close();
			
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
