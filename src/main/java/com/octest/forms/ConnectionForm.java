package com.octest.forms;

import javax.servlet.http.HttpServletRequest;

public class ConnectionForm {
	public final static String LOGIN = "login";
	public final static String PASSWORD = "pass";
	public final static String UN_DEUX_TROIS = "123";
	public final static String CONNECTE = "Vous êtes bien connecté.";
	public final static String NON_CONNECTE = "Identifiants incorrects !";
	
	private String resultat;
	
	public void verifierIdentifiants( HttpServletRequest request) {
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);
		
		if(password.equals(login + UN_DEUX_TROIS)) {
			resultat = CONNECTE;
		}
		else {
			resultat = NON_CONNECTE;
		}
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

}
