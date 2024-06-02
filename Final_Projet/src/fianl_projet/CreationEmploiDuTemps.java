package fianl_projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreationEmploiDuTemps extends JFrame{
	 private Connection connection;
	 private JComboBox<String> enseignantComboBox;
	 private JComboBox<String> coursComboBox;
	 private JComboBox<String> salleComboBox;
	 private JTextArea emploiDuTempsTextArea;
	 private JTextField heuredebutField;
	 private JTextField heurefinField;
	 private JTextArea resultatArea;
	 
	public void CreationEmploiDuTemps() {
		JFrame frame = new JFrame ();
		
		frame.setTitle("Initialisation Emplois du temps");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new FlowLayout());
	    JPanel mainPanel = new JPanel();
	    /*mainPanel.setLayout(new GridLayout(4, 2, 10, 10));
	    mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    add(mainPanel);*/
	    
	   
	    JLabel enseignantLabel = new JLabel("Enseignant :");
	    mainPanel.add(enseignantLabel);
	    enseignantComboBox = new JComboBox<>();
	    enseignantComboBox.setPreferredSize(new Dimension(200, 30));
	    mainPanel.add(enseignantComboBox);
	    enseignantLabel.setFont(new Font("Cooper Black", Font.ITALIC, 15));
	   
	    JLabel coursLabel = new JLabel("Cours :");
	    mainPanel.add(coursLabel);
	    coursComboBox = new JComboBox<>();
	    coursComboBox.setPreferredSize(new Dimension(200, 30));
	    mainPanel.add(coursComboBox);
	    coursLabel.setFont(new Font("Cooper Black", Font.ITALIC, 20));
	    
	    JLabel heuredebutLabel = new JLabel("Heure Début :");
	    mainPanel.add(heuredebutLabel);
	    heuredebutField = new JTextField(20);
	    mainPanel.add(heuredebutField);
	    heuredebutLabel.setFont(new Font("Cooper Black", Font.ITALIC, 20));
	    
	    JLabel heurefinLabel = new JLabel("Heure Début :");
	    mainPanel.add(heurefinLabel);
	    heurefinField = new JTextField(20);
	    mainPanel.add(heurefinField);
	    heurefinLabel.setFont(new Font("Cooper Black", Font.ITALIC, 20));
	    
	    JLabel salleLabel = new JLabel("Salle :");
	    mainPanel.add(salleLabel);
	    salleComboBox = new JComboBox<>();
	    salleComboBox.setPreferredSize(new Dimension(200, 30));
	    mainPanel.add(salleComboBox);
	    salleLabel.setFont(new Font("Cooper Black", Font.ITALIC, 20));
	   
	    JButton genererButton = new JButton("Créer un Emploi du Temps");
	    mainPanel.add(genererButton);
	    genererButton.setFont(new Font("Cooper Black", Font.ITALIC, 20));
	    
	    JButton quitButton = new JButton("Quitter");
	    mainPanel.add(quitButton);
	   
	    quitButton.setFont(new Font("Cooper Black", Font.ITALIC, 20));
	   

	        
	    
	        mainPanel.setBackground(Color.pink);
	        
	      
		    resultatArea = new JTextArea(10, 30);
		    JScrollPane scrollPane = new JScrollPane(resultatArea);
		   
		    mainPanel.add(scrollPane);
		    mainPanel.add(resultatArea);
		    mainPanel.setBackground(Color.pink);
		    
	        
		    
	    chargerEnseignants();
        chargerCours();
        chargerSalle();
        
        frame.add(mainPanel);
	   
        
        genererButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermeture de la fenêtre
            	
            	String enseignant = (String) enseignantComboBox.getSelectedItem();
            	String cours = (String) coursComboBox.getSelectedItem();
            	String salle = (String) salleComboBox.getSelectedItem();
            	String heuredebut = heuredebutField.getText();
                String heurefin = heurefinField.getText();
                saveToDatabase(enseignant, cours, heuredebut, heurefin, salle);
                
            	
            }
        });
        
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermeture de la fenêtre
            	frame.setVisible(false);
            }
        });

		frame.setBackground(Color.pink);
		frame.setSize(1800,300);
		frame.setVisible(true);
        
	}
	
	 private void chargerEnseignants() {
	        // Connexion à la base de données
	        String url = "jdbc:mysql://localhost:3306/emploidutemps";
	        String username = "root";
	        String password = "93017539";

	        try {
	            Connection connection = DriverManager.getConnection(url, username, password);
	            Statement statement = connection.createStatement();

	            // Requête pour récupérer les noms des enseignants
	            String query = "SELECT name FROM enseignants";
	            ResultSet resultSet = statement.executeQuery(query);

	            while (resultSet.next()) {
	                String enseignant = resultSet.getString("name");
	                enseignantComboBox.addItem(enseignant);
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 private void chargerCours() {
	        // Connexion à la base de données
	        String url = "jdbc:mysql://localhost:3306/emploidutemps";
	        String username = "root";
	        String password = "93017539";

	        try {
	            Connection connection = DriverManager.getConnection(url, username, password);
	            Statement statement = connection.createStatement();

	            // Requête pour récupérer les noms des cours
	            String query = "SELECT intitule FROM matiere";
	            ResultSet resultSet = statement.executeQuery(query);

	            while (resultSet.next()) {
	                String intitule = resultSet.getString("intitule");
	                coursComboBox.addItem(intitule);
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 private void chargerSalle() {
	        // Connexion à la base de données
	        String url = "jdbc:mysql://localhost:3306/emploidutemps";
	        String username = "root";
	        String password = "93017539";

	        try {
	            Connection connection = DriverManager.getConnection(url, username, password);
	            Statement statement = connection.createStatement();

	            // Requête pour récupérer les noms des cours
	            String query = "SELECT intitule FROM classe";
	            ResultSet resultSet = statement.executeQuery(query);

	            while (resultSet.next()) {
	                String intitule = resultSet.getString("intitule");
	                salleComboBox.addItem(intitule);
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 
	 private void saveToDatabase( String enseignant, String cours, String heuredebut, String heurefin, String salle) {
	        String url = "jdbc:mysql://localhost:3306/emploidutemps";
	        String username = "root";
	        String password = "93017539";

	        String sql = "INSERT INTO emploidutemps (enseignant,cours, heuredebut, heurefin, salle) VALUES (?, ?,?,?,?)";
	        
	        try {
	        	//Class.forName("com.mysql.jdbc.Driver2");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploidutemps", "root", "93017539");
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setString(1, enseignant);
	            statement.setString(2, cours);
	            statement.setString(3, heuredebut);
	            statement.setString(4, heurefin);
	            statement.setString(5, salle);
	          

	            int rowsAffected = statement.executeUpdate();
	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(this, "Emploie du temps créer !");
	            }

	            statement.close();
	            connection.close();
	        } catch (SQLException ex) {
	        	JOptionPane.showMessageDialog(this, "pas enregistré !");
	            ex.printStackTrace();
	        }
	        
	        try {
		          connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploidutemps", "root", "93017539");
		          Statement statement = connection.createStatement();
		          String query = "SELECT * FROM emploidutemps WHERE enseignant = '" + enseignant + "' AND cours = '" + cours + "' AND heuredebut = '" + heuredebut + "' AND heurefin = '" + heurefin + "' AND salle = '" + salle + "'";
		            ResultSet resultSet = statement.executeQuery(query);

		            StringBuilder resultatBuilder = new StringBuilder();
		            while (resultSet.next()) {
		                String nameEnseignant = resultSet.getString("enseignant"); 
		                String cour = resultSet.getString("cours");
		                String heuredebuts = resultSet.getString("heuredebut");
		                String heurefins = resultSet.getString("heurefin");
		                String salles = resultSet.getString("salle");
		                resultatBuilder.append("Name: ").append(nameEnseignant).append(", Cours: ").append(cour).append(", Heure Début: ").append(heuredebuts).append(", Heure Fin: ").append(heurefins).append("\n").append(", Salle: ").append(salles).append("\n");
		                }
		            
		            if (resultatBuilder.length() == 0) {
		                    resultatBuilder.append("Aucun Emploi du temps trouvé.");
		                }
		                
		                resultatArea.setText(resultatBuilder.toString());

		                resultSet.close();
		                statement.close();
		      } catch (SQLException e) {
		          e.printStackTrace();
		      }
	    }

}
