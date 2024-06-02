package com.database.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Donnees {
	private Connection connexion;
	
	public List<Auteur> recupererAuteurs(){
		List<Auteur> auteurs = new ArrayList<Auteur>();
		Statement statement = null;
		ResulSet resultat = null;
		connexion();
		
		try {
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT nom, prenom FROM Auteur;");
			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				
				Auteur auteur = new Auteur();
				auteur.setNom(nom);
				auteur.setPrenom(prenom);
				auteurs.add(auteur);
			}
		}catch (SQLException e) {
			
		}finally {
			try {
				if (resultat != null)
					resultat.close();
				if (statement != null)
					resultat.close();
				if (connexion != null)
					connexion.close();
			}catch (SQLException ignore) {
				
			}
		}
		return auteurs;
		
	}
	private void connexion(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {}
		
		try {
			connexion = DriverManager.getConnection("jdbc:mysql:" + "//localhost:3306/JEE", "root", "93017539");
		}catch(SQLException e) {e.printStackTrace();}
		
	}
	
}
