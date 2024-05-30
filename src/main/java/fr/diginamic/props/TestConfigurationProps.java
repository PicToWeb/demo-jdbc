package fr.diginamic.props;

import java.util.Iterator;
import java.util.ResourceBundle;

import utils.ConcatenationException;
import utils.StringUtils;

public class TestConfigurationProps {

	public static void main(String[] args) throws ConcatenationException {
		ResourceBundle config = ResourceBundle.getBundle("fichier");
		String url = config.getString("database.url");
		
		System.out.println(url);
		
		
		Iterator<String> iterateur = config.getKeys().asIterator();
		while (iterateur.hasNext()){
		String key = iterateur.next();
		System.out.println(key + " "+ config.getString(key));
		System.out.println(StringUtils.toString(" ", key,config.getString(key))); 
		}

	}

}
