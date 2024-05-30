package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class TestConnexionJdbc {

	public static void main(String[] args) {
		
		ResourceBundle config = ResourceBundle.getBundle("fichier");
		String url = config.getString("database.url");
		String user = config.getString("database.user");
		String pass = config.getString("database.pass");
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection connection = DriverManager.getConnection(url,user,pass);
			System.out.println(connection);
			
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
