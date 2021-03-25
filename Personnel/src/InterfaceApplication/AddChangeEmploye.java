package InterfaceApplication;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import personnel.SauvegardeImpossible;



public class AddChangeEmploye {
	
	
	public static  void AddEmploye() {
		
		JFrame employeAdd = new JFrame();
		employeAdd.setVisible(true);
		employeAdd.setTitle("Ajouter un employé");
		employeAdd.getContentPane().setLayout(new GridBagLayout());
			
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.ipady = gbc.anchor = GridBagConstraints.PAGE_START;
		
		GridBagConstraints panCont = new GridBagConstraints();
		panCont.ipady = panCont.anchor = GridBagConstraints.CENTER;
		
		gbc.weightx = 1;
		gbc.weighty = 2;
		gbc.insets = new Insets(2, 2, 2, 2);
		//employeAdd.add(back, gbc);
		//employeAdd.add(text, gbc);
		employeAdd.add(panelContainer(), panCont);
		employeAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employeAdd.pack();
		
	}

	
	private static JPanel panel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2, 25,25));
		panel.setPreferredSize(new Dimension(700,500));
		TextField nom = new TextField();
		TextField prenom = new TextField();
		TextField mail = new TextField();
		TextField password = new TextField();
		TextField dateArrivee= new TextField();
		TextField dateDepart = new TextField();
		JButton addbtn = new JButton("Ajouter");
		JButton cancelbtn = new JButton("Annuler");
		
		
		JLabel nomL = new JLabel("Nom :");
		nomL.setFont(new Font("Serif", Font.PLAIN, 22));
		JLabel prenomL = new JLabel("Prénom :");
		prenomL.setFont(new Font("Serif", Font.PLAIN, 22));
		JLabel emailL = new JLabel("Email :");
		emailL.setFont(new Font("Serif", Font.PLAIN, 22));
		JLabel passwordL = new JLabel("Password :");
		passwordL.setFont(new Font("Serif", Font.PLAIN, 22));
		JLabel dateArriveeL = new JLabel("Date d'arrivée :");
		dateArriveeL.setFont(new Font("Serif", Font.PLAIN, 22));
		JLabel dateDepartL = new JLabel("Date de départ :");
		dateDepartL.setFont(new Font("Serif", Font.PLAIN, 22));

		
		panel.add(nomL);
		panel.add(nom);
		panel.add(prenomL);
		panel.add(prenom);
		panel.add(emailL);
		panel.add(mail);
		panel.add(passwordL);
		panel.add(password);
		panel.add(dateArriveeL);
		panel.add(dateArrivee);
		panel.add(dateDepartL);
		panel.add(dateDepart);
		panel.add(addbtn);
		panel.add(cancelbtn);
		return panel;
	}
	private static JPanel panelContainer()
	{
		JPanel panelContainer = new JPanel();
		panelContainer.setLayout(new BorderLayout());
		panelContainer.add(panel(), BorderLayout.CENTER);
		panelContainer.setPreferredSize(new Dimension(750,550));
		JLabel text = new JLabel("Ajouter un employe");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		Border borderTitle = new EmptyBorder(25,25,25,25);
		text.setBorder(borderTitle);
		text.setFont(new Font("Serif", Font.BOLD, 30));
		JTextArea back = new JTextArea("Quitter");
		panelContainer.add(text, BorderLayout.NORTH);
		return panelContainer;
	}
	
	 public static void main(String[] args)  throws SauvegardeImpossible
	 {
		 AddEmploye();
	  }
}
