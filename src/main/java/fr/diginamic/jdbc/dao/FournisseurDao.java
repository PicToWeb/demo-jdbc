package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public interface FournisseurDao {

	static final ResourceBundle config = ResourceBundle.getBundle("fichier");
	static final String URL = config.getString("database.url");
	static final String USER = config.getString("database.user");
	static final String PASS = config.getString("database.pass");
	
	List<Fournisseur> extraire(Connection connection);
	void insert(Connection connection,Fournisseur fournisseur);
	int update(Connection connection,String ancienNom,String nouveauNom);
	boolean delete(Connection connection,Fournisseur fournisseur);
}
