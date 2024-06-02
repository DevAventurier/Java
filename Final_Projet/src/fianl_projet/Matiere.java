package fianl_projet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

public class Matiere extends JFrame{
	private JTextField IntituleField;
	

    public void ajouterMatiere() {
    	JFrame frame = new JFrame ();
    	
		JPanel panelPrincipale = new JPanel();
		
		
		
		frame.setTitle("Enregistrement Matière");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel panellabel = new JPanel();
        JLabel label = new JLabel ("Ajout de Matieres");
        label.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        label.setForeground(Color.black);
        label.setBackground(Color.pink);
        //label.setOpaque(true);
        panellabel.add(label);
        panellabel.setBackground(Color.pink);
        
        JPanel panelChamps = new JPanel();
        
        //panelChamps.add(Box.createVerticalStrut(100));
        JLabel Intitulelabel = new JLabel("Intitulé : ");
		Intitulelabel.setFont(new Font("Cooper Black", Font.ITALIC, 20));
		//labelIntitule.add(Box.createVerticalStrut(20));
		JLabel Codelabel = new JLabel("Code : ");
		Codelabel.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        
		JTextField IntituleField = new JTextField();
		IntituleField.setColumns(20);
		JTextField CodeField = new JTextField();
		CodeField.setColumns(20);
		
		
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
        container.add(Intitulelabel, gbc);

        gbc.gridx = 1;
        container.add(IntituleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        container.add(Codelabel, gbc);

        gbc.gridx = 1;
        container.add(CodeField, gbc);
 
        container.setBackground(Color.pink);
        
        JPanel buttonPanel = new JPanel();
		
		JButton Enregistrer = new JButton("Enregistrer");
        JButton reset = new JButton("Reset");
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        container.add(Enregistrer, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        container.add(reset, gbc);
        
        

        Enregistrer.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        reset.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        buttonPanel.setBackground(Color.pink);
        
        
        Enregistrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String intitule = IntituleField.getText();
                String codes = CodeField.getText();
                saveToDatabase(intitule, codes);
                
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
        frame.setSize(600,250);
        frame.setResizable(false);
    }
    
    private void saveToDatabase(String intitule, String codes) {
        String url = "jdbc:mysql://localhost:3306/emploidutemps";
        String username = "root";
        String password = "93017539";

        String sql = "INSERT INTO matiere (intitule, codes) VALUES (?, ?)";
        
        try {
        	//Class.forName("com.mysql.jdbc.Driver2");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploidutemps", "root", "93017539");
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, intitule);
            statement.setString(2, codes);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "La matière a été enregistrée avec succès !");
            }

            statement.close();
            connection.close();
        } catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null, "OUPS! La matière n'a pas été enregistrée !");
            ex.printStackTrace();
        }
    }
}
