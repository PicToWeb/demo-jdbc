package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestDaoJdbc {
	
	public static FournisseurDaoJdbc f1= new FournisseurDaoJdbc();
		
		
	public static void main(String[] args) {
		
		Fournisseur fourni1 = new Fournisseur(4,"France de matériaux");
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection connection = DriverManager.getConnection(FournisseurDao.URL, FournisseurDao.USER, FournisseurDao.PASS);
			f1.insert(connection,fourni1);
			System.out.println(f1.extraire(connection));
			f1.update(connection,"France de matériaux", "France matériaux");
			System.out.println(f1.extraire(connection));
			f1.delete(connection,fourni1);
			System.out.println(f1.extraire(connection));
			
			connection.close();
		}catch (SQLException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		

	}

}
