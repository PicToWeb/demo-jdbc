package fr.diginamic.jdbc.entites;

import java.util.List;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc2;

public class TestDaoJdbc2 {

	public static void main(String[] args) {
		FournisseurDaoJdbc2 fournisseurDaoJdbc = new FournisseurDaoJdbc2();
		
		List<Fournisseur> fournisseurs = fournisseurDaoJdbc.extraire();
		
		fournisseurs.forEach(System.out::println);
		
		System.out.println("----------");
		
		//fournisseurDaoJdbc.update2("jon","hgng");

	}

}
