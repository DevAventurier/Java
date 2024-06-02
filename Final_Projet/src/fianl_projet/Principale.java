package fianl_projet;


import java.util.*;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;


public class Principale extends JFrame {
	
	private List<Enseignants> enseignants;
	
	private JTextField enseignantNomField;
    private JTextField enseignantPrenomField;
    private JTextField enseignantTelField;
    private JTextField enseignantMatriculeField;
    private JTextField enseignantEmailField;
    
    
	public Principale() {
		
		setTitle("Project Structure");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        
        
        
        JButton creerEnseignantButton = new JButton("Créer Enseignant");
        creerEnseignantButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = enseignantNomField.getText();
                String prenom = enseignantPrenomField.getText();
                String tel = enseignantTelField.getText();
                String matricule = enseignantMatriculeField.getText();
                String email = enseignantEmailField.getText();

                Enseignants enseignant = new Enseignants(nom, prenom, tel, matricule, email);
                enseignants.add(enseignant);

                // Réinitialiser les champs de saisie
                enseignantNomField.setText("");
                enseignantPrenomField.setText("");
                enseignantTelField.setText("");
                enseignantMatriculeField.setText("");
                enseignantEmailField.setText("");

                JOptionPane.showMessageDialog(Principale.this, "Enseignant créé avec succès.");
            }
        });
	}
	
	//JFrame frame = new JFrame();
	
	/*JPanel panel = new JPanel();
	JPanel sidebar = new JPanel();
	JPanel mainPanel = new JPanel(new BorderLayout());
	
	JButton enseignant = new JButton("Ajouter Enseignant");
	JButton matiere = new JButton("Créer Matière");
	JButton classe = new JButton("Créer Classe");
	JButton anneescolaire = new JButton("Ajouter Année-scolaire");
	JButton cours = new JButton("Ajouter Cours");
	JButton emploi = new JButton("Créer Emploi du Temps");*/
	
	/*JFrame frame = new JFrame("Hello World");
	
	 public void paintComponents(Graphics g) {
	        // Appeler la méthode paintComponents() de la superclasse pour dessiner les composants de base de la fenêtre
	        //super.paintComponents(g);

	        // Définir la couleur et l'épaisseur de la ligne
	        g.setColor(Color.BLACK);
	        //g.setStroke(new BasicStroke(10));

	        // Dessiner la ligne verticale
	        g.drawLine(50, 100, 50, 200);
	    }
	
	/*Principale (){
		
		
		/*enseignant.setBounds(50,100,150,30);
		matiere.setBounds(50,150,150,30);
		classe.setBounds(50,200,150,30);
		anneescolaire.setBounds(50,250,200,30);
		cours.setBounds(50,300,150,30);
		emploi.setBounds(50,350,200,30);*/
		
	    //frame.setBounds(50,50,150,150);  
	    //frame.setBackground(Color.green);
	    
	    /*frame.add(anneescolaire);
	    frame.add(classe);
	    frame.add(cours);
	    frame.add(emploi);
	    frame.add(enseignant);
	    frame.add(matiere);*/
	    /*frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setBackground(Color.BLUE);
		
		 // Créer un panneau principal pour contenir le panneau latéral
		mainPanel.add(sidebar, BorderLayout.EAST);
		sidebar.setBackground(Color.BLUE);
		/*frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);*/
		
		
		/*frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(3800, 800);
	    frame.setVisible(true);
		
	    
		/*panel.add(frame);
		panel.setBackground(Color.black);
		frame.setBackground(Color.black);*/
	//}
	
	
	
	
	
	
	
	
	
}
