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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Utilisateur extends JFrame {
	 private Connection connection;
	 private JTextArea resultatArea;
	 
	 JFrame frame = new JFrame();
	public void Utilisateur() {
		 frame = new JFrame("Emplois du temps");
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.setLayout(new BorderLayout());
	     
	    
	     resultatArea = new JTextArea(10, 30);
	     resultatArea.setEditable(false);
	     
	      frame.setBackground(Color.cyan);
	      //frame.setSize(1800,500);
	      frame.setVisible(true);
	      frame.setResizable(false);
	      
	      
	      
	      Affichage();
	}
	 
	private void Affichage() {
        try {
	          connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploidutemps", "root", "93017539");
	          Statement statement = connection.createStatement();
	          String query = "SELECT enseignant, cours, heuredebut, heurefin, salle FROM emploidutemps";
	          ResultSet resultSet = statement.executeQuery(query);
	          
	          ArrayList<Object[]> data = new ArrayList<>();
	          
	            StringBuilder resultatBuilder = new StringBuilder();
	            while (resultSet.next()) {
	                String nameEnseignant = resultSet.getString("enseignant"); 
	                String cour = resultSet.getString("cours");
	                String heuredebuts = resultSet.getString("heuredebut");
	                String heurefins = resultSet.getString("heurefin");
	                String salles = resultSet.getString("salle");
	                resultatBuilder.append("Name: ").append(nameEnseignant).append(", Cours: ").append(cour).append(", Heure Début: ").append(heuredebuts).append(", Heure Fin: ").append(heurefins).append("\n").append(", Salle: ").append(salles).append("\n");
	                
	                Object[] row = {nameEnseignant, cour, heuredebuts, heurefins, salles};
	                data.add(row);
	                
	            }
	         // Créer une DefaultTableModel avec les données de l'ArrayList
	            DefaultTableModel model = new DefaultTableModel();
	            model.setColumnIdentifiers(new Object[]{"Enseignant", "Cours", "Heure Début", "Heure Fin", "Salle"});
	            for (Object[] row : data) {
	                model.addRow(row);
	                
	            }
	            
	            
	            // Créer une JTable avec le modèle de données
	            JTable table = new JTable(model);
	            table.setBackground(Color.cyan);
	            table.setFont(new Font("Cooper Black", Font.ITALIC, 15));
	            
	            JScrollPane scrollPane = new JScrollPane(table);
	            scrollPane.setBackground(Color.cyan);
	            scrollPane.setFont(new Font("Cooper Black", Font.ITALIC, 15));
	            
	            frame.add(scrollPane);
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setBackground(Color.cyan);
	            frame.pack();
	            frame.setSize(1800,500);
	            frame.setVisible(true);
	            
	            
	      	      
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
