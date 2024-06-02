package fianl_projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class CreationCours extends JFrame{
	private JComboBox<String> enseignantComboBox;
	private JComboBox<String> matiereComboBox;
	private JComboBox<String> classeComboBox;
	private JComboBox<String> anneescolaireComboBox;
	private JTextArea coursTextArea;
	private Connection connection;
	
	public void CreationCours() {
		JFrame frame = new JFrame ();
		
		frame.setTitle("Initialisation Cours");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel mainPanel = new JPanel();
	    
	    JLabel enseignantLabel = new JLabel("Enseignant :");
	    mainPanel.add(enseignantLabel);
	    enseignantComboBox = new JComboBox<>();
	    enseignantComboBox.setPreferredSize(new Dimension(145, 25));
	    mainPanel.add(enseignantComboBox);
	    enseignantLabel.setFont(new Font("Cooper Black", Font.ITALIC, 20));
	   
	    JLabel matiereLabel = new JLabel("Matière :");
	    mainPanel.add(matiereLabel);
	    matiereComboBox = new JComboBox<>();
	    matiereComboBox.setPreferredSize(new Dimension(145, 25));
	    mainPanel.add(matiereComboBox);
	    matiereLabel.setFont(new Font("Cooper Black", Font.ITALIC, 20));
	    
	    JLabel classeLabel = new JLabel("Classe :");
	    mainPanel.add(classeLabel);
	    classeComboBox = new JComboBox<>();
	    classeComboBox.setPreferredSize(new Dimension(145, 20));
	    mainPanel.add(classeComboBox);
	    classeLabel.setFont(new Font("Cooper Black", Font.ITALIC, 20));
	    
	    JLabel anneescolaireLabel = new JLabel("Année :");
	    mainPanel.add(anneescolaireLabel);
	    anneescolaireComboBox = new JComboBox<>();
	    anneescolaireComboBox.setPreferredSize(new Dimension(200, 20));
	    mainPanel.add(anneescolaireComboBox);
	    anneescolaireLabel.setFont(new Font("Cooper Black", Font.ITALIC, 20));
	    
	    JButton genererButton = new JButton("Créer un Cours");
	    //genererButton.addActionListener(new GenererEmploiDuTempsListener());
	    mainPanel.add(genererButton);
	    
	    JButton quitButton = new JButton("Quitter");
	    mainPanel.add(quitButton);
	    
	    genererButton.setFont(new Font("Cooper Black", Font.ITALIC, 20));
	    quitButton.setFont(new Font("Cooper Black", Font.ITALIC, 20));
	    
	    coursTextArea = new JTextArea(10, 30);
	    coursTextArea.setEditable(false);
	    
	    JScrollPane scrollPane = new JScrollPane(coursTextArea);
	    add(scrollPane, BorderLayout.CENTER);
	    frame.add(mainPanel);
	    mainPanel.setBackground(Color.pink);
	    
        
	    chargerEnseignants();
        chargerMatiere();
        chargerClasse();
        chargerAnneescolaire();
        
        genererButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String matiere = (String) matiereComboBox.getSelectedItem();
                String enseignant = (String) enseignantComboBox.getSelectedItem();
                String classe = (String) classeComboBox.getSelectedItem();
                String anneescolaire = (String) anneescolaireComboBox.getSelectedItem();
          
                
                saveToDatabase(matiere, enseignant,classe,anneescolaire);

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
		frame.setSize(1800,200);
		frame.setVisible(true);
		frame.setResizable(false);
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
	
	 private void chargerMatiere() {
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
	                String matiere = resultSet.getString("intitule");
	                matiereComboBox.addItem(matiere);
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 private void chargerClasse() {
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
	                String classe = resultSet.getString("intitule");
	                classeComboBox.addItem(classe);
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 private void chargerAnneescolaire() {
	        // Connexion à la base de données
	        String url = "jdbc:mysql://localhost:3306/emploidutemps";
	        String username = "root";
	        String password = "93017539";

	        try {
	            Connection connection = DriverManager.getConnection(url, username, password);
	            Statement statement = connection.createStatement();

	            // Requête pour récupérer les noms des cours
	            String query = "SELECT codes FROM anneescolaire";
	            ResultSet resultSet = statement.executeQuery(query);

	            while (resultSet.next()) {
	                String annee = resultSet.getString("codes");
	                anneescolaireComboBox.addItem(annee);
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 private void saveToDatabase(String matiere, String enseignant, String classe, String anneescolaire) {
	        String url = "jdbc:mysql://localhost:3306/emploidutemps";
	        String username = "root";
	        String password = "93017539";

	        String sql = "INSERT INTO cours (matiere, enseignant,classe,anneescolaire) VALUES (?, ?,?,?)";
	        
	        try {
	        	//Class.forName("com.mysql.jdbc.Driver2");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploidutemps", "root", "93017539");
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setString(1, matiere);
	            statement.setString(2, enseignant);
	            statement.setString(3, classe);
	            statement.setString(4, anneescolaire);
	          

	            int rowsAffected = statement.executeUpdate();
	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(this, "Le Cours a été enregistré avec succès !");
	            }

	            statement.close();
	            connection.close();
	        } catch (SQLException ex) {
	        	JOptionPane.showMessageDialog(this, "pas enregistré !");
	            ex.printStackTrace();
	        }
	    }
}
