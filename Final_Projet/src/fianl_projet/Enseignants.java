package fianl_projet;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Enseignants extends JFrame{
	private String nom ;
	private String prenom ;
	private String tel ;
	private String numero_matricule ;
	private String email ;
	public Enseignants(String nom, String prenom, String tel, String numero_matricule, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.numero_matricule = numero_matricule;
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNumero_matricule() {
		return numero_matricule;
	}
	public void setNumero_matricule(String numero_matricule) {
		this.numero_matricule = numero_matricule;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	private JTextField enseignantNomField;
    private JTextField enseignantPrenomField;
    private JTextField enseignantTelField;
    private JTextField enseignantMatriculeField;
    private JTextField enseignantEmailField;
    
  
	
	public void AjouterEnseignant() {
		JFrame frame = new JFrame ();
		JPanel panelPrincipale = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel panellabel = new JPanel();
		
		frame.setTitle("Enregistrement Enseignant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel label = new JLabel ("Ajout des Enseignants");
        label.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        label.setForeground(Color.black);
        label.setBackground(Color.pink);
        //frame.setLocationRelativeTo(null);
        panellabel.add(label);
        
        
        panellabel.setBackground(Color.pink);
        
        
        JPanel panelChamps = new JPanel();
        //panelChamps.setLayout(new GridBagLayout());
        panelChamps.setBackground(Color.pink);
		JLabel labelNom = new JLabel("Nom : ");
		labelNom.setFont(new Font("Cooper Black", Font.ITALIC, 20));
		JLabel labelPrenom = new JLabel("Prénoms : ");
		labelPrenom.setFont(new Font("Cooper Black", Font.ITALIC, 20));
		JLabel labelTel = new JLabel("Téléphone : ");
		labelTel.setFont(new Font("Cooper Black", Font.ITALIC, 20));
		JLabel labelMatricule = new JLabel("N° Matricule : ");
		labelMatricule.setFont(new Font("Cooper Black", Font.ITALIC, 20));
		JLabel labelEmail = new JLabel("Email : ");
		labelEmail.setFont(new Font("Cooper Black", Font.ITALIC, 20));
		
		JTextField enseignantNomField = new JTextField();
		enseignantNomField.setColumns(20);
		JTextField enseignantPrenomField = new JTextField();
		enseignantPrenomField.setColumns(20);
		JTextField enseignantTelField = new JTextField();
		enseignantTelField.setColumns(20);
		JTextField enseignantMatriculeField = new JTextField();
		enseignantMatriculeField.setColumns(20);
		JTextField enseignantEmailField = new JTextField();
		enseignantEmailField.setColumns(20);
		
		
		
		Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        container.setBackground(Color.pink);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(label, gbc);
        
        gbc.gridx = 1;
        container.add(label, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        container.add(labelNom, gbc);
        
        gbc.gridx = 1;
        container.add(enseignantNomField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        container.add(labelPrenom, gbc);
        
        gbc.gridx = 1;
        container.add(enseignantPrenomField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        container.add(labelTel, gbc);
        
        gbc.gridx = 1;
        container.add(enseignantTelField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        container.add(labelEmail, gbc);
        
        gbc.gridx = 1;
        container.add(enseignantMatriculeField, gbc);

		JButton Enregistrer = new JButton("Enregistrer");
        JButton reset = new JButton("Quitter");
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        container.add(Enregistrer, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        container.add(reset, gbc);
        panelPrincipale.add(container);
        
        container.add(Box.createVerticalStrut(30));
        
        buttonPanel.setBackground(Color.pink);
        
        Enregistrer.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        reset.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        
        panelPrincipale.add(panellabel);
        panelPrincipale.add(panelChamps);
        panelPrincipale.add(buttonPanel);
        panelPrincipale.setBackground(Color.pink);
        
        frame.add(panelPrincipale);
		frame.setBackground(Color.pink);
		frame.setVisible(true);
        frame.setSize(600,300);
        frame.setResizable(false);
        
       
        
        Enregistrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String name = enseignantNomField.getText();
                String prenom = enseignantPrenomField.getText();
                String tel = enseignantTelField.getText();
                String email = enseignantEmailField.getText();
                saveToDatabase(name, prenom, tel, email);
                frame.setVisible(true);

            }
        });
        
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermeture de la fenêtre
            	frame.setVisible(false);
            }
        });
        
        
	}
	
	 private void saveToDatabase(String name, String prenom, String tel, String email) {
	        String url = "jdbc:mysql://localhost:3306/emploidutemps";
	        String username = "root";
	        String password = "93017539";

	        String sql = "INSERT INTO enseignants (name, prenom, tel, email) VALUES (?, ?,?,?)";
	        
	        try {
	        	//Class.forName("com.mysql.jdbc.Driver2");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploidutemps", "root", "93017539");
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setString(1, name);
	            statement.setString(2, prenom);
	            statement.setString(3, tel);
	            statement.setString(4, email);

	            int rowsAffected = statement.executeUpdate();
	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(this, "L'enseignant a été enregistré avec succès !");
	            }

	            statement.close();
	            connection.close();
	        } catch (SQLException ex) {
	        	JOptionPane.showMessageDialog(this, "OUPS! Erreur survenue lors de l'enregistrement!");
	            ex.printStackTrace();
	        }
	    }
	
	
	
}
