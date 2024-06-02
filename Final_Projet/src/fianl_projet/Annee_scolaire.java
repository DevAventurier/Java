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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Annee_scolaire extends JFrame{
	private String code ;
	private String date_debut;
	private String date_fin ;
	
	public Annee_scolaire(String code, String date_debut, String date_fin) {
		super();
		this.code = code;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	
	public void AjouterAnneeScolaire() {
		JFrame frame = new JFrame ();
		JPanel panelPrincipale = new JPanel();
		
		JPanel panellabel = new JPanel();
		
		frame.setTitle("Ajouter une Année Scolaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel label = new JLabel ("AJOUTER UNE ANNEE SCOLAIRE");
        label.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        label.setForeground(Color.black);
        label.setBackground(Color.pink);
        label.setOpaque(true);
        panellabel.add(label);
        
        
        panellabel.setBackground(Color.pink);
        
        
        JPanel panelChamps = new JPanel();
        panelChamps.setLayout(new GridBagLayout());
        panelChamps.setBackground(Color.pink);
		JLabel labelCode = new JLabel("Code : ");
		labelCode.setFont(new Font("Cooper Black", Font.ITALIC, 20));
		
		JLabel labelDatedebut = new JLabel("Date de Début : ");
		labelDatedebut.setFont(new Font("Cooper Black", Font.ITALIC, 20));
		JLabel labelDatefin = new JLabel("Date de Fin : ");
		labelDatefin.setFont(new Font("Cooper Black", Font.ITALIC, 20));
		
		JTextField codeField = new JTextField();
		codeField.setColumns(20);
		
		JTextField DatedebutField = new JTextField();
		DatedebutField.setColumns(20);
		
		JTextField DatefinField = new JTextField();
		DatefinField.setColumns(20);
		
		
		
		Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
		 

        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(label, gbc);
        
        gbc.gridx = 1;
        container.add(label, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        container.add(labelCode, gbc);

        gbc.gridx = 1;
        container.add(codeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        container.add(labelDatedebut, gbc);

        gbc.gridx = 1;
        container.add(DatedebutField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        container.add(labelDatefin, gbc);

        gbc.gridx = 1;
        container.add(DatefinField, gbc);
 
	    
        container.setBackground(Color.pink);
		JPanel buttonPanel = new JPanel();
		
		JButton Enregistrer = new JButton("Enregistrer");
        JButton reset = new JButton("Reset");
        

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        container.add(Enregistrer, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        container.add(reset, gbc);
        
        

        Enregistrer.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        reset.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        buttonPanel.setBackground(Color.pink);
        
        Enregistrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codes = codeField.getText();
                String datedebut = DatedebutField.getText();
                String datefin = DatefinField.getText();
                saveToDatabase(codes, datedebut, datefin);
                
            }
        });
        
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermeture de la fenêtre
            	frame.setVisible(false);
            }
        });
        
        
        panelPrincipale.add(container);
        panelPrincipale.setBackground(Color.pink);
        
        frame.add(panelPrincipale); 
        frame.setBackground(Color.pink);
		frame.setVisible(true);
        frame.setSize(800,300);
        frame.setResizable(false);
	}
	
	private void saveToDatabase(String codes, String datedebut, String datefin) {
        String url = "jdbc:mysql://localhost:3306/emploidutemps";
        String username = "root";
        String password = "93017539";

        String sql = "INSERT INTO anneescolaire (codes, datedebut, datefin) VALUES (?, ?, ?)";
        
        try {
        	//Class.forName("com.mysql.jdbc.Driver2");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploidutemps", "root", "93017539");
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, codes);
            statement.setString(2, datedebut);
            statement.setString(3, datefin);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Année Scolaire ajoutée avec succès !");
            }

            statement.close();
            connection.close();
        } catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null, "OUPS ! Il semblerait que nous encontrions un probleme !");
            ex.printStackTrace();
        }
    }
}
