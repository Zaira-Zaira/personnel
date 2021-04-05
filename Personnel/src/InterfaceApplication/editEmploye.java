package InterfaceApplication;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.SauvegardeImpossible;



public class editEmploye {
	
    private static Employe employe;
    GestionPersonnel gestionPersonnel;
    
	public editEmploye(GestionPersonnel gestionPersonnel, Employe employe) {
		   this.gestionPersonnel = gestionPersonnel;
		   this.employe = employe;
	}
	
	
	public static void listData()
	{
		frame().setVisible(true);
	}
	
	public static JFrame frame()
	{
		JFrame employes = new JFrame();
		employes.setSize(900,900);
		employes.setLocationRelativeTo(null);
		//employes.setJMenuBar(menuBar());
		employes.setLayout(new GridBagLayout());
		employes.add(panel());
		//employes.add(Container());
		employes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return employes;
	}
	
	private static JPanel panel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2, 25,25));
		panel.setPreferredSize(new Dimension(700,500));
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
	
	private static JButton addEmploye()
	{
		JButton addbtn = new JButton("Enregistrer");
		addbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			  employe.setNom(nameInput().getText());
			  employe.setPrenom(secondNameInput().getText());
			  employe.setMail(mailInput().getText());
			  employe.setPassword(passwordInput().getText());
			}
		});
		return addbtn;
	}
	
	private static JButton cancelAdd()
	{
		JButton cancelbtn = new JButton("Annuler");
		
		return cancelbtn;
	}
	
	private static JTextField nameInput()
	{
		JTextField nom = new JTextField();
		nom.setEditable(true);
		nom.setText(employe.getNom());
		return nom;
	}
	
	private static JTextField secondNameInput()
	{
		JTextField prenom = new JTextField();
		prenom.setEditable(true);
		prenom.setText(employe.getPrenom());
		return prenom;
	}
	
	
	private static JTextField mailInput()
	{
		JTextField mail = new JTextField();
		mail.setEditable(true);
		mail.setText(employe.getMail());
		return mail;
	}
	
	private static JTextField passwordInput()
	{
		JTextField pass = new JTextField();
		pass.setEditable(true);
		pass.setText(employe.getPassword());
		return pass;
	}
	
	private static JFormattedTextField DateArriveInput()
	{
		DateFormat date = new SimpleDateFormat("Y-m-d");
		JFormattedTextField dateArrive = new JFormattedTextField(date);
		dateArrive.setEditable(true);
		return dateArrive;
	}
	
	private static JFormattedTextField DateDepartInput()
	{
		DateFormat date = new SimpleDateFormat("Y-m-d");
		JFormattedTextField dateDepart = new JFormattedTextField(date);
		dateDepart.setEditable(true);
		return dateDepart;
	}
	
	
}
