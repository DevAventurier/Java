package com.bongo.registration.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bongo.registration.model.Auteur;

public class AuteurBdd {
    public int registerAuteur(Auteur auteur) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO auteur" + 
            " (nom, prenom, username, motdepasse) VALUES" + 
            " (?, ?, ?, ?);";

        int result = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jeee", "root", "93017539");

                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

            preparedStatement.setString(1, auteur.getNom()); // Utiliser l'index 1 pour le premier paramètre
            preparedStatement.setString(2, auteur.getPrenom());
            preparedStatement.setString(3, auteur.getUsername());
            preparedStatement.setString(4, auteur.getMotdepasse());

            System.out.println(preparedStatement);

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
