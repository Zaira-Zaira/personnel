package InterfaceApplication;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.SortedSet;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToolBar;

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
		 homePage.setSize(500,400);
		 homePage.setJMenuBar(menuBar());
		 homePage.add(panel());
		 homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 homePage.pack();
		 homePage.setLocationRelativeTo(null);
    }
	 
	 private static JMenuBar menuBar()
	 {
		 JMenuBar menubar = new JMenuBar();
		 menubar.setPreferredSize(new Dimension(60,60));
		 JMenu menu = new JMenu("Mon compte");
		 menu.setFont(new Font("Serif", Font.BOLD, 20));
		 menu.setSize(70,70);
		 menu.setForeground(Color.white);
		 JMenuItem itemMenu = new JMenuItem("Gérer mon compte");
		 itemMenu.setFont(new Font("Serif", Font.PLAIN, 20));
		 menu.add(itemMenu);
		 itemMenu.setSize(70,70);
		 JMenu ligues = new JMenu("Gerer les ligues");
		 ligues.setFont(new Font("Serif", Font.BOLD, 20));
		 ligues.setForeground(Color.white);
		 JMenuItem itemaccount= new JMenuItem("Afficher les ligues");
		 itemaccount.setFont(new Font("Serif", Font.PLAIN, 20));
		 JMenuItem addligue= new JMenuItem("Ajouter une ligues");
		 addligue.setFont(new Font("Serif", Font.PLAIN, 20));
		 ligues.add(itemaccount);
		 ligues.addSeparator();
		 ligues.add(addligue);
		 menubar.add(menu);
		 menubar.add(ligues);
		 menubar.setBackground(Color.lightGray);
		return menubar;
	 }
	 
	 private static JPanel toolBar()
	 {
		 JPanel paneltool = new JPanel();
		 JToolBar toolbar = new JToolBar();
		 toolbar.setPreferredSize(new Dimension(500,500));
		 JButton addligue = new JButton("Ajouter une ligues");
		 JButton editligue = new JButton("Modifier la ligue");
		 JButton deleteLigue = new JButton("Supprimer une ligue");
		 toolbar.add(addligue);
		 toolbar.add(editligue);
		 toolbar.add(deleteLigue);
		 paneltool.add(toolbar);
		 return paneltool;
	 }
	 
	 private static JPanel panel() 
	 {
		 JPanel panel = new JPanel();
		 panel.setPreferredSize(new Dimension(300,400));
		 panel.setLayout(new GridBagLayout());
		 
		 String choix[] = {"Ligue1", " Ligue2", " Ligue2", "Ligue3", "Ligue4"};
		 JList listLigues = new JList(choix);
		 listLigues.setPreferredSize(new Dimension(150,150));
		 panel.add(listLigues);
		 return panel;
	 }
	 public static void main(String[] args)  throws SauvegardeImpossible
	 {
		 Home();
	  }
}
