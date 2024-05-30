package fr.diginamic.jdbc.entites;


public class Fournisseur {
	
	private int id;
	
	private String nom;

	/** Constructor
	 * @param id
	 * @param nom
	 */
	public Fournisseur(int id, String nom) {
		
		this.id = id;
		this.nom = nom;
	}
	

	@Override
	public String toString() {
		return "Fournisseur [id=" + getId() + ", nom=" + getNom() + "]";
	}


	/** Getter for id
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter for id
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter for nom
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter for nom
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
