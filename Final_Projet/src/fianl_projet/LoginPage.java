package fianl_projet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPage extends JFrame{
	
	private JTextField usernameField;
    private JPasswordField passwordField;

    public void LoginPage() {
    	JFrame frame = new JFrame();
    	
        frame.setTitle("Login Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        JPanel panel = new JPanel();
     

        JLabel usernameLabel = new JLabel("Username :");
        usernameField = new JTextField(20);
        usernameLabel.setFont(new Font("Algerian", Font.ITALIC, 18));
        JLabel passwordLabel = new JLabel("Password :");
        passwordField = new JPasswordField(20);
        passwordLabel.setFont(new Font("Algerian", Font.ITALIC, 18));
        JButton loginButton = new JButton("Log In");
        loginButton.setFont(new Font("Algerian", Font.ITALIC, 18));
        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Algerian", Font.ITALIC, 18));
        

        Container container = getContentPane();

        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Ajout des composants au conteneur principal
        gbc.gridx = 0; // username cote gauche
        gbc.gridy = 4; //username bord haut
        container.add(usernameLabel, gbc);

        gbc.gridx = 1;//link entre titre et champs
        container.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        container.add(passwordLabel, gbc);

        gbc.gridx = 1;
        container.add(passwordField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        container.add(loginButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        container.add(quitButton, gbc);
        panel.add(container);
        container.setBackground(Color.pink);
        panel.setBackground(Color.pink);
       
       //.............................................................................. 
        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("YERIMA") && password.equals("YERIMA")) {
                    JOptionPane.showMessageDialog(null, "Welcome dear User....Here is your schedule!");
                    Utilisateur utilisateur = new Utilisateur ();
            		utilisateur.Utilisateur();
                } 
                
                else if (username.equals("BATANA") && password.equals("JAVA")) {
                    JOptionPane.showMessageDialog(null, "....... Welcome back Mr BATANA ...... ");
                    MaPage maPage = new MaPage();
                    maPage.Graphiques();

                } else {
                    JOptionPane.showMessageDialog(null, "OUPS ! Something went wrong..Try again");
                }
            }
        });
        
        
        //...............................................................................
        
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermeture de la fenêtre
            	frame.setVisible(false);
            }
        });

        frame.add(panel);
        frame.setBackground(Color.pink);
		frame.setVisible(true);
        frame.setSize(400,250); //pour regler le soucis des dimmensions et espace impossible avec le haut
        frame.setResizable(false); // pour empecher la redimenssion de la page
    }

	/*private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}*/

	
}
