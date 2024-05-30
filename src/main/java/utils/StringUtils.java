package utils;

public final class StringUtils {

	/**
	 * Méthode qui concatène des informations de différentes natures (String,
	 * double, etc.) pour générer une String
	 * 
	 * @param objets informations à concaténer
	 * @return String
	 * @throws ConcatenationException  dans le cas ou le paramètre objet à une taille nulle
	 */
	public static String toString(String separateur, Object... objets) throws ConcatenationException {

		if (objets.length ==0) {
			throw new ConcatenationException("Vous devez concaténer au moins une information");
		}
		// Ici objets est un tableau
		// Il peut donc se parcourir avec boucle indexée ou non indexée (comme
		// ci-dessous) mais pas avec un Iterator.
		StringBuilder builder = new StringBuilder();
		for (Object obj : objets) {
			builder.append(obj).append(separateur);
		}
		return builder.toString();
	}

	/**
	 * Méthode qui transforme un nombre de type string en int et qui supprime les
	 * espaces.
	 * 
	 * @param chaine chaine à convertir en int
	 * @return int
	 */
	public static int parseInt(String chaine) {
		if (chaine.contains("")) {
			chaine = chaine.replaceAll(" ", "");
		}
		return Integer.parseInt(chaine);
	}

}
