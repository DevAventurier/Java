package fianl_projet;

import java.awt.Color;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.*;

public class MatiereRecherche extends JFrame{
	
	private JTextField intituleField;
    private JTextField codesField;
    private JTextArea resultatArea;

    private Connection connection;
	
	public void MatiereRecherche() {
		JFrame frame = new JFrame();
		JPanel panelPrincipale = new JPanel ();
		 // Configuration de la fenêtre
        frame.setTitle("Verification Matieres");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.pink);
        
        // Création des composants
        JPanel panelChamps = new JPanel();
        panelChamps.setBackground(Color.pink);
        JLabel intituleLabel = new JLabel("Intitule:");
        intituleLabel.setFont(new Font("Cooper Black", Font.ITALIC, 18));
        JLabel codesLabel = new JLabel("Code:");
        codesLabel.setFont(new Font("Cooper Black", Font.ITALIC, 18));
        
        
        intituleField = new JTextField(20);
        codesField = new JTextField(20);
        JButton rechercherButton = new JButton("Rechercher");
        JButton quitButton = new JButton("Quitter");
        resultatArea = new JTextArea(5, 60);
        JScrollPane scrollPane = new JScrollPane(resultatArea);

        // Configuration du conteneur principal
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Ajout des composants au conteneur principal
        gbc.gridx = 1;
        gbc.gridy = 0;
        container.add(intituleLabel, gbc);

        gbc.gridx = 2;
        container.add(intituleField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        container.add(codesLabel, gbc);

        gbc.gridx = 2;
        container.add(codesField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        container.add(rechercherButton, gbc);
        
        
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        container.add(quitButton, gbc);
        
        panelPrincipale.add(container);
        
        rechercherButton.setFont(new Font("Cooper Black", Font.ITALIC, 15));
        quitButton.setFont(new Font("Cooper Black", Font.ITALIC, 15));
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 4;
        container.add(scrollPane, gbc);
        container.setBackground(Color.pink);

        // Gestionnaire d'événements pour le bouton de recherche
        rechercherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String intitule= intituleField.getText();
                String codes = codesField.getText();

                rechercherEtudiant(intitule, codes);
            }
        });

        
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermeture de la fenêtre
            	frame.setVisible(false);
            }
        });
        
        

        // Établissement de la connexion à la base de données
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploidutemps", "root", "93017539");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        frame.add(panelPrincipale);
        panelPrincipale.setBackground(Color.pink);
		frame.setBackground(Color.pink);
		frame.setVisible(true);
        frame.setSize(800,300);
        frame.setResizable(false);
		
	}
	
	 private void rechercherEtudiant(String intitule, String codes) {
	        try {
	            Statement statement = connection.createStatement();
	            String query = "SELECT * FROM matiere WHERE intitule = '" + intitule + "' AND codes = '" + codes + "'";
	            ResultSet resultSet = statement.executeQuery(query);

	            StringBuilder resultatBuilder = new StringBuilder();
	            while (resultSet.next()) {
	                String intituleMatiere = resultSet.getString("intitule"); 
	                String codesMatiere = resultSet.getString("codes");
	                resultatBuilder.append("Cette UE est bel et bien presente dans la librairie");
	            }

	            if (resultatBuilder.length() == 0) {
	                resultatBuilder.append("Aucune UE ne correspond a cette description");
	            }

	            resultatArea.setText(resultatBuilder.toString());

	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

}
