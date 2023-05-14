package com.octest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;

public class DaoFactory {

	private String url;
	private String username;
	private String password;
	
	private static final String URL = "jdbc:mysql://localhost:3306/javaee";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String CLASS_FOR_NAME = "com.mysql.jdbc.Driver";
	
	DaoFactory(String url, String username, String password){
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public static DaoFactory getInstance() {
		try {
			Class.forName(CLASS_FOR_NAME);		
		} catch (ClassNotFoundException ignore) {
			// TODO: handle exception
		}
		
		DaoFactory instance = new DaoFactory(URL, USER, PASSWORD);
		
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(url, username, password);
		
		connection.setAutoCommit(Boolean.FALSE);
		
		return connection;
	}
	
	//Récupération du Dao
	public UtilisateurDao getUtilisateurDao() {
		return new UtilisateurDaoImpl(this);
	}
	
}
