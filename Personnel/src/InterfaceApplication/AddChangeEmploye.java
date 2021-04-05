package InterfaceApplication;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;



public class AddChangeEmploye {
	
	private static Ligue ligue;
	private static GestionPersonnel gestionPersonnel;
	private static HomePage ligues;
	
	 
	public AddChangeEmploye(GestionPersonnel gestionPersonnel, Ligue ligue, HomePage ligues) {
		    this.ligue = ligue;
		    this.gestionPersonnel = gestionPersonnel;
		    this.ligues = ligues;
	}
	
	public void AddEmploye() {
		
		JFrame employeAdd = new JFrame();
		employeAdd.setVisible(true);
		employeAdd.setTitle("Ajouter un employ�");
		employeAdd.getContentPane().setLayout(new GridBagLayout());
			
		GridBagConstraints panCont = new GridBagConstraints();
		panCont.ipady = panCont.anchor = GridBagConstraints.CENTER;
		employeAdd.setSize(750,700);
		employeAdd.setLocationRelativeTo(null);
		employeAdd.add(panelContainer(), panCont);
		employeAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employeAdd.pack();
	}

	
	private JPanel panel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2, 25,25));
		panel.setPreferredSize(new Dimension(700,500));
		JLabel nomL = new JLabel("Nom :");
		nomL.setFont(new Font("Serif", Font.PLAIN, 22));
		JLabel prenomL = new JLabel("Pr�nom :");
		prenomL.setFont(new Font("Serif", Font.PLAIN, 22));
		JLabel emailL = new JLabel("Email :");
		emailL.setFont(new Font("Serif", Font.PLAIN, 22));
		JLabel passwordL = new JLabel("Password :");
		passwordL.setFont(new Font("Serif", Font.PLAIN, 22));
		JLabel dateArriveeL = new JLabel("Date d'arriv�e :");
		dateArriveeL.setFont(new Font("Serif", Font.PLAIN, 22));
		JLabel dateDepartL = new JLabel("Date de d�part :");
		dateDepartL.setFont(new Font("Serif", Font.PLAIN, 22));

		
		panel.add(nomL);
		panel.add(nameInput());
		panel.add(prenomL);
		panel.add(secondNameInput());
		panel.add(emailL);
		panel.add(mailInput());
		panel.add(passwordL);
		panel.add(passwordInput());
		panel.add(dateArriveeL);
		panel.add(DateArriveInput());
		panel.add(dateDepartL);
		panel.add(DateDepartInput());
		panel.add(addEmploye());
		panel.add(cancelAdd());
		return panel;
	}
	
	private JTextField nameInput()
	{
		JTextField nom = new JTextField();
		return nom;
	}
	
	private JTextField secondNameInput()
	{
		JTextField prenom = new JTextField();
		return prenom;
	}
	
	
	private  JTextField mailInput()
	{
		JTextField mail = new JTextField();
		return mail;
	}
	
	private  JTextField passwordInput()
	{
		JTextField pass = new JTextField();
		return pass;
	}
	
	private JFormattedTextField DateArriveInput()
	{
		DateFormat date = new SimpleDateFormat("Y-m-d");
		JFormattedTextField dateArrive = new JFormattedTextField(date);
		return dateArrive;
	}
	
	private JFormattedTextField DateDepartInput()
	{
		DateFormat date = new SimpleDateFormat("Y-m-d");
		JFormattedTextField dateDepart = new JFormattedTextField(date);
		return dateDepart;
	}
	
	
	
	private  JButton addEmploye()
	{
		JButton addbtn = new JButton("Ajouter");
		addbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ligue.addEmploye(nameInput().getText(), secondNameInput().getText(), mailInput().getText(), passwordInput().getText(), null,  null);
			}
		});
		return addbtn;
	}
	
	private JButton cancelAdd()
	{
		JButton cancelbtn = new JButton("Annuler");
		
		return cancelbtn;
	}
	
	private JPanel panelContainer()
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
		 AddChangeEmploye add = new AddChangeEmploye(gestionPersonnel, ligue, ligues);
		 add.addEmploye();
	  }
}
