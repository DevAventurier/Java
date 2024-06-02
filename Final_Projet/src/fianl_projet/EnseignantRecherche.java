package fianl_projet;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class EnseignantRecherche extends JFrame{
	
	private JTextField nomField;
    private JTextField prenomField;
    private JTextField telField;
    private JTextArea resultatArea;

    private Connection connection;
	
	public void EnseignantRecherche() {
		JFrame frame = new JFrame();
		
		JPanel panelPrincipale = new JPanel();
		
		frame.setTitle("Verification Enseignant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800,950);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.pink);
		
        JLabel label = new JLabel ("RECHERCHE DES ENSEIGANTS");
        label.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        label.setForeground(Color.black);
        label.setBackground(Color.pink);
        
        panelPrincipale.add(label);
        
        // Création des composants
        JPanel panelChamps = new JPanel();
        panelChamps.setBackground(Color.pink);
        JLabel nomLabel = new JLabel("Nom:");
        nomLabel.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        JLabel prenomLabel = new JLabel("Prénom:");
        prenomLabel.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        JLabel telLabel = new JLabel("Téléphone:");
        telLabel.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        
        nomField = new JTextField(20);
        prenomField = new JTextField(20);
        telField = new JTextField(20);
        JButton rechercherButton = new JButton("Rechercher");
        JButton quitButton = new JButton("Quitter");
        resultatArea = new JTextArea(10, 50);
        JScrollPane scrollPane = new JScrollPane(resultatArea);
        
     // Configuration du conteneur principal
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Ajout des composants au conteneur principal
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(label, gbc);

        gbc.gridx = 1;
        container.add(label, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        container.add(nomLabel, gbc);

        gbc.gridx = 1;
        container.add(nomField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        container.add(prenomLabel, gbc);

        gbc.gridx = 1;
        container.add(prenomField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        container.add(telLabel, gbc);

        gbc.gridx = 1;
        container.add(telField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        container.add(rechercherButton, gbc);
   
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        container.add(quitButton, gbc);
        
        rechercherButton.setFont(new Font("Cooper Black", Font.ITALIC, 20));
     
        quitButton.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 5;
        container.add(scrollPane, gbc);
        container.setBackground(Color.pink);

        
        panelPrincipale.add(container);
        
        
        
        
     // Gestionnaire d'événements pour le bouton de recherche
        rechercherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nomField.getText();
                String prenom = prenomField.getText();
                String tel = telField.getText();
                EnseignantRecherche(name, prenom, tel);
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
        frame.setSize(1800,500);
        frame.setResizable(false);
	}
	
	 private void EnseignantRecherche(String name, String prenom, String tel) {
	        try {
	            Statement statement = connection.createStatement();
	            String query = "SELECT * FROM enseignants WHERE name = '" + name + "' AND prenom = '" + prenom + "' AND tel = '" + tel + "'";
	            ResultSet resultSet = statement.executeQuery(query);

	            StringBuilder resultatBuilder = new StringBuilder();
	            while (resultSet.next()) {
	                String nameEnseignant = resultSet.getString("name"); 
	                String prenomEnseignant = resultSet.getString("prenom");
	                String telEnseignant = resultSet.getString("tel");
	                resultatBuilder.append("Name: ").append(nameEnseignant).append(", Prénom: ").append(prenomEnseignant).append(", Tel: ").append(telEnseignant).append("\n");
	            }

	            if (resultatBuilder.length() == 0) {
	                resultatBuilder.append("Aucun enseignant trouvé.");
	            }

	            resultatArea.setText(resultatBuilder.toString());

	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
