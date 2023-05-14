package com.octest.beans;

public class Utilisateur {
	private static final int DIX = 10;
	private static final String MESSAGE_EXCEPTION_NOM_SUP_10_CHAR = "Le nom est trop grand ! (10 caracrtères maximum)";
	private String nom;
	private String prenom;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) throws BeanException {
		if(nom.length() > DIX) {
			throw new BeanException(MESSAGE_EXCEPTION_NOM_SUP_10_CHAR);
		}
		else {
			this.nom = nom;
		}
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
