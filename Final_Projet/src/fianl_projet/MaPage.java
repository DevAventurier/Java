package fianl_projet;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;






public class MaPage extends JFrame{
	
	private List<Enseignants> enseignants;
	
	private JTextField enseignantNomField;
    private JTextField enseignantPrenomField;
    private JTextField enseignantTelField;
    private JTextField enseignantMatriculeField;
    private JTextField enseignantEmailField;
    
    private JTextField matiereIntitule;
    private JTextField matiereCode;
    
    
	public void Graphiques() {
		
		JFrame frame = new JFrame();

		//Titre de la fenetre
		frame.setTitle("Project Structure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Label de bienvenu dans l'application
        JPanel panellabel = new JPanel();
        
        JLabel label = new JLabel(" BIENVENUE DANS VOTRE GESTIONNAIRE ", JLabel.CENTER);
        panellabel.add(label);
        label.setFont(new Font("Cooper Black", Font.BOLD, 20));
        panellabel.setSize(250, 250);
        label.setForeground(Color.black);
        panellabel.setBackground(Color.pink);//haut
        //label.setOpaque(true);
        panellabel.setVisible(true);
        
        
        //Création et ajout des boutton 
        
        JPanel buttonPanel = new JPanel();
        
        
        JButton creerEnseignantButton = new JButton("Nouvel Enseignant");
        JButton creerMatiereButton = new JButton("Nouvelle Matière");
        JButton creerClasseButton = new JButton("Enregistrer une Classe");
        JButton creeranneeButton = new JButton("Recenser une Année");
        JButton creerCoursButton = new JButton("Ajout Cours");
        JButton creerEmploiDuTemps = new JButton("Création Emploi du Temps");
        JButton creerRechercheEnseignant = new JButton("Rechercher un Enseignant");
        JButton creerRechercherMatiere = new JButton("Rechercher une Matière");
        JButton quit = new JButton("Quitter");
        
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        
        JPanel panelAffichage = new JPanel();
        panelAffichage.setBackground(Color.pink); //Drwt bas
        
        frame.add(panellabel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.WEST);
        frame.add(panelAffichage, BorderLayout.CENTER);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 0, 0, 0); 
        
        buttonPanel.add(Box.createVerticalStrut(30));
        buttonPanel.add(creerEnseignantButton, gbc);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(creerMatiereButton, gbc);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(creerClasseButton, gbc);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(creeranneeButton, gbc);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(creerCoursButton, gbc);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(creerEmploiDuTemps, gbc);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(creerRechercheEnseignant, gbc);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(creerRechercherMatiere, gbc);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(quit, gbc);
        
        
    
        creerEnseignantButton.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        creerMatiereButton.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        creerClasseButton.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        creeranneeButton.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        creerCoursButton.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        creerEmploiDuTemps.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        creerRechercheEnseignant.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        creerRechercherMatiere.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        quit.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        //label.setForeground(Color.white);
        buttonPanel.setBackground(Color.pink);//gauche 
        //buttonPanel.setOpaque(true); 
        buttonPanel.setVisible(true);
        
       
        	creerEnseignantButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            	Enseignants enseignant = new Enseignants(null, null, null, null, null);
        		enseignant.AjouterEnseignant();
               
        		}
            
        });
        	
        	creerMatiereButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                	Matiere matiere = new Matiere ();
            		matiere.ajouterMatiere(); }
                
            });
        	
        	creerClasseButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                	Classe classe = new Classe (null, null);
            		classe.ajouterClasse(); }
                
            });
        	
        	creeranneeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                	Annee_scolaire annee = new Annee_scolaire (null, null, null);
            		annee.AjouterAnneeScolaire(); }
                
            });
        	
        	creerCoursButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                	CreationCours creationCours = new   CreationCours();
            		creationCours.CreationCours(); }
                
            });
        	
        	creerEmploiDuTemps.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                	CreationEmploiDuTemps emploi = new   CreationEmploiDuTemps();
            		emploi.CreationEmploiDuTemps(); }
                
            });
        	
        	
        	creerRechercheEnseignant.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	
                	EnseignantRecherche enseignantRecherche = new EnseignantRecherche();
            		enseignantRecherche.EnseignantRecherche();
        	        }
        	
 });
                

  
        	
        	creerRechercherMatiere.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                	MatiereRecherche  matiereRecherche = new MatiereRecherche();
            		matiereRecherche.MatiereRecherche(); }
                
            });
        	
        	quit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                	frame.setVisible(false); }
                
            });
        	
        	
        	
        	
        	
        //frame.setBackground(Color.blue);
        frame.setVisible(true);
        frame.setSize(800,500);
        frame.setResizable(false);
        
	}
}
