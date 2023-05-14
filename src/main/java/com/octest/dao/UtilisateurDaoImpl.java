package com.octest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import com.octest.beans.BeanException;
import com.octest.beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {
	private DaoFactory daoFactory;
	private Connection connection = null;
	
	UtilisateurDaoImpl(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Utilisateur utilisateur) throws DaoException{
		PreparedStatement preparedStatement = null;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO noms(nom, prenom) VALUES(?,?);");	
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			
			// Exécution de la requête
			preparedStatement.executeUpdate();
			connection.commit();
			
		} catch(SQLException e) {
			try {
				if(connection != null) {
					connection.rollback();
				}
			} catch(SQLException e2) {
			}
			
			throw new DaoException("Impossible de communiquer avec la base de données.");
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch(SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données.");
			}
		}
		
	}

	@Override
	public List<Utilisateur> lister() throws BeanException{
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		
		Statement statement = null;
		ResultSet resultat = null;
		
		try {
			connection = daoFactory.getConnection();
			
			statement = connection.createStatement();
			
			// Exécution de la requête
			resultat = statement.executeQuery("SELECT nom, prenom FROM noms;");
			
			// Récupération des données
			while(resultat.next()) {
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);
				
				utilisateurs.add(utilisateur);
			}
		} catch(SQLException e) {
			System.err.println("Erreur d'SQL " + e);
		}
		
		return utilisateurs;
	}

}
