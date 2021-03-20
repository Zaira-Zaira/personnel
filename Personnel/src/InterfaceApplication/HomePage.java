package InterfaceApplication;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.SortedSet;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


import commandLine.EmployeConsole;
import commandLine.LigueConsole;
import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.Passerelle;
import personnel.SauvegardeImpossible;


public class HomePage {
	
	private Ligue ListLigues;
	private SortedSet<Ligue> Ligues;
	private Ligue ligueList;
	private GestionPersonnel gestionPersonnel;
    public final static int SERIALIZATION = 1, JDBC = 2, 
			TYPE_PASSERELLE = JDBC;  
	private static Passerelle passerelle = TYPE_PASSERELLE == JDBC ? new jdbc.JDBC() : new serialisation.Serialization();	
	Color selectCouleur = Color.RED;
	
	
	public HomePage(GestionPersonnel gestionPersonnel)
	{
		this.gestionPersonnel = gestionPersonnel;
	}
	
	
	
	public  SortedSet<Ligue> getLigue(){
		System.out.println(gestionPersonnel.getLigues());
		
		return gestionPersonnel.getLigues();
	}
	
	
	 public static void Home() {
    	 JFrame homePage = new JFrame();
    	 homePage.setVisible(true);
		 homePage.setTitle("Home page");
		 homePage.getContentPane().setLayout(new FlowLayout());
		 
		 String choix[] = {"Ligue1", " Ligue2", " Ligue2", "Ligue3", "Ligue4"};
		 JList listLigues = new JList(choix);
		 listLigues.setFixedCellWidth(80);
		 listLigues.setFixedCellHeight(50);
		 listLigues.setForeground(Color.RED);
		 homePage.getContentPane().add(listLigues);
		 homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 homePage.pack();
    }
	 
	 
	 
	 public static void main(String[] args)  throws SauvegardeImpossible
	 {
		 Home();
	  }
}
