package InterfaceApplication;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import personnel.Employe;
import personnel.GestionPersonnel;

public class EditRoot {
 
private GestionPersonnel gestionPersonnel;
private JTextField nom;
private JTextField prenom;
private JTextField email;
private JTextField pass;

	public EditRoot(GestionPersonnel gestionPersonnel) {
		  this.gestionPersonnel = gestionPersonnel;
	}
	
	public JFrame frame()
	{
		JFrame root = new JFrame();
		root.getContentPane().setBackground(Color.decode("#cbc0d3"));
		root.setTitle("Editer le root");
		root.setLayout(new GridBagLayout());
		root.setPreferredSize(new Dimension(700,700));
		root.setLocationRelativeTo(null);
		root.setJMenuBar(menuBar());
		root.add(panelContainer());
		root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		root.pack();
		return root;
	}
	private JMenuBar menuBar()
	 {
		 JMenuBar menubar = new JMenuBar();
		 menubar.setPreferredSize(new Dimension(50,50));
		 menubar.setBackground(Color.decode("#540b0e"));
		 JMenu menu = new JMenu("Compte root");
		 menu.setAlignmentX(SwingConstants.WEST);
		 menu.setFont(new Font("Serif", Font.BOLD, 20));
		 menu.setForeground(Color.decode("#fafafa"));
		 menu.setSize(80,80);
		 menubar.add(menu);
		return menubar;
	 }
	
	private JPanel panelContainer()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.add(labelAndInput());
		return panel;
	}
	
	private JPanel labelAndInput()
	{
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(350,350));
		GridLayout layout = new GridLayout(0,2);
		layout.setVgap(30);
		panel.setLayout(layout);
		panel.add(nom());
		panel.add(nomInput());
		panel.add(prenom());
		panel.add(prenomInput());
		panel.add(email());
		panel.add(emailInput());
		panel.add(pass());
		panel.add(passInput());
		panel.add(save());
		panel.add(cancel());
		return panel;
	}
	
    private JLabel nom()
    {
    	JLabel label = new JLabel("Nom :");
    	return label;
    }
    
    private JLabel prenom()
    {
    	JLabel label = new JLabel("Prénom :");
    	return label;
    }
    
    private JLabel email()
    {
    	JLabel label = new JLabel("Email :");
    	return label;
    }
    
    private JLabel pass()
    {
    	JLabel label = new JLabel("Password :");
    	return label;
    }
    
    private JTextField nomInput()
    {
    	nom = new JTextField();
    	nom.setText(gestionPersonnel.getRoot().getNom());
    	return nom;
    }
    
    private JTextField prenomInput()
    {
    	prenom = new JTextField();
    	prenom.setText(gestionPersonnel.getRoot().getPrenom());
    	return prenom;
    }
    
    private JTextField emailInput()
    {
    	email = new JTextField();
    	email.setText(gestionPersonnel.getRoot().getMail());
    	return email;
    }
    
    private JTextField passInput()
    {
    	pass = new JTextField();
    	pass.setText(gestionPersonnel.getRoot().getPassword());
    	return pass;
    }
    private JButton save()
    {
    	JButton btn = new JButton("Enregistrer");
    	btn.setBackground(Color.decode("#540b0e"));
		btn.setForeground(Color.decode("#fafafa"));
		btn.setFont(new Font("Serif", Font.PLAIN, 20));
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 gestionPersonnel.getRoot().setNom(nom.getText());
				 gestionPersonnel.getRoot().setPrenom(prenom.getText());
				 gestionPersonnel.getRoot().setMail(email.getText());
				 gestionPersonnel.getRoot().setPassword(pass.getText());
				 frame().setVisible(false);
				 frame().dispose();
				 HomePage home  = new HomePage(gestionPersonnel, gestionPersonnel.getRoot());
				 home.frame().setVisible(true);
				
			}
		});
    	return btn;
    }
    private JButton cancel()
    {
    	JButton btn = new JButton("Annuler");
    	btn.setBackground(Color.decode("#540b0e"));
		btn.setForeground(Color.decode("#fafafa"));
		btn.setFont(new Font("Serif", Font.PLAIN, 20));
    	return btn;
    }
}
