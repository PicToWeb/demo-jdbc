package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestDaoJdbc {
	
	public static FournisseurDaoJdbc f1= new FournisseurDaoJdbc();
		
		
	public static void main(String[] args) {
		
		Fournisseur fourni1 = new Fournisseur(4,"France de matériaux");
		
		f1.insert(fourni1);
		System.out.println(f1.extraire());
		f1.update("France de matériaux", "France matériaux");
		System.out.println(f1.extraire());
		f1.delete(fourni1);
		System.out.println(f1.extraire());
		

	}

}
