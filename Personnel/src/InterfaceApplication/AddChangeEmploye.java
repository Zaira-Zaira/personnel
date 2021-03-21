package InterfaceApplication;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import personnel.SauvegardeImpossible;



public class AddChangeEmploye {
	
	
	public static  void AddEmploye() {
		
		JFrame employeAdd = new JFrame();
		employeAdd.setVisible(true);
		employeAdd.setTitle("Ajouter un employé");
		//employeAdd.getContentPane().setLayout(new BoxLayout());
		
		BoxLayout emp = new BoxLayout(employeAdd, BoxLayout.Y_AXIS);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		TextField nom = new TextField();
		TextField prenom = new TextField();
		TextField mail = new TextField();
		TextField password = new TextField();
		TextField dateArrivee= new TextField();
		TextField dateDepart = new TextField();
		JButton addbtn = new JButton("Ajouter");
		JButton cancelbtn = new JButton("Annuler");
		JTextArea text = new JTextArea("Ajouter un employe");
		JTextArea back = new JTextArea("Quitter");
		panel.add(new JLabel("Nom :"));
		panel.add(nom);
		panel.add(new JLabel("Prenom :"));
		panel.add(prenom);
		panel.add(new JLabel("Email :"));
		panel.add(mail);
		panel.add(new JLabel("Password :"));
		panel.add(password);
		panel.add(new JLabel("Date d'arrivée :"));
		panel.add(dateArrivee);
		panel.add(new JLabel("Date de départ :"));
		panel.add(dateDepart);
		panel.add(addbtn);
		panel.add(cancelbtn);
	    
		employeAdd.add(back, BorderLayout.LINE_START);
		employeAdd.add(text, BorderLayout.NORTH);
		employeAdd.add(panel, BorderLayout.CENTER);
		employeAdd.getContentPane().add(panel);
		employeAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employeAdd.pack();
		
	}

	
	 public static void main(String[] args)  throws SauvegardeImpossible
	 {
		 AddEmploye();
	  }
}
