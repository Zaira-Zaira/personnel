package InterfaceApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.SortedSet;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;

public class listEmployes {
	
	private GestionPersonnel gestionPersonnel;
	private static Ligue ligue;
	
	public listEmployes(GestionPersonnel gestionPersonnel, Ligue ligue)
	{
		     this.gestionPersonnel = gestionPersonnel;
		     this.ligue = ligue;
	}
	
	static void listEmployes()
	{
		frame();
	}
	private static JFrame frame()
	{
		JFrame employes = new JFrame();
		employes.setSize(700,700);
		employes.setLocationRelativeTo(null);
		employes.setJMenuBar(menuBar());
		employes.setLayout(new GridBagLayout());
		employes.add(listEmp());
		employes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employes.setVisible(true);
		return employes;
	}

	private static JMenuBar menuBar()
	{
		 JMenuBar menubar = new JMenuBar();
		 menubar.setPreferredSize(new Dimension(60,60));
		 menubar.add(menuCompte());
		 menubar.add(menuLigues());
		 menubar.setBackground(Color.lightGray);
		return menubar;
	}
	
	private static JMenu menuCompte()
	{
		 JMenu menu = new JMenu("Mon compte");
		 menu.add(itemMenuCompte());
		 menu.setSize(70,70);
		 menu.setFont(new Font("Serif", Font.BOLD, 20));
		 menu.setForeground(Color.white);
		 return menu;
	}
	
	private static JMenu menuLigues()
	{
		JMenu ligues = new JMenu("Gerer les ligues");
		ligues.add(itemMenuLigues());
		 ligues.setFont(new Font("Serif", Font.BOLD, 20));
		 ligues.setForeground(Color.white);
		 ligues.addSeparator();
		 return ligues;
	}
	
	private static JMenuItem itemMenuCompte() {
		 JMenuItem itemMenu = new JMenuItem("Gérer mon compte");
		 Border borderitem = new EmptyBorder(7,7,7,7);
		 itemMenu.setBorder(borderitem);
		 itemMenu.setSize(70,70);
		 itemMenu.setFont(new Font("Serif", Font.PLAIN, 17));
		 return itemMenu;
	}
	private static JMenuItem itemMenuLigues()
	{
		JMenuItem itemaccount= new JMenuItem("Afficher les ligues");
		Border borderitem = new EmptyBorder(7,7,7,7);
		 itemaccount.setBorder(borderitem);
		 itemaccount.setFont(new Font("Serif", Font.PLAIN, 17));
		 return itemaccount;
	}
	private static JPanel listEmp()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel titleAdd = new JPanel();
		titleAdd.setLayout(new GridBagLayout());
		titleAdd.add(title());
		titleAdd.add(addEmploye());
		panel.add(titleAdd, BorderLayout.NORTH);
		panel.add(listEmploye(), BorderLayout.CENTER);
		return panel;
	}
	
	private  static JLabel title()
	{
		JLabel title = new JLabel("Les employes de ligue ...");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		Border margin = new EmptyBorder(0,0,150,0);
		title.setBorder(margin);
		title.setFont(new Font("Serif", Font.PLAIN, 27));
		title.setForeground(Color.blue);
		
		return title;
	}
	
	private static JList listEmploye()
	{
		String choix[] = {"Employe1", "employe2", "employe2", "employe3", "employe4"};
		JList listemp = new JList(choix);
		
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)listemp.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);
		
		Border borderitem = new EmptyBorder(7,7,7,7);
		listemp.setFixedCellWidth(600);
		listemp.setFixedCellHeight(70);
		listemp.setBorder(borderitem);
		return listemp;
	}
	private static JButton addEmploye()
	{
		JButton addEmploye = new JButton("Ajouter un employé");
		addEmploye.setForeground(Color.WHITE);
		addEmploye.setFont(new Font("Serif", Font.BOLD, 20));
		addEmploye.setBackground(Color.BLUE);
		addEmploye.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddChangeEmploye.AddEmploye();
			}
		});
		return addEmploye;
	}
	
	
	 public static void main(String[] args)  throws SauvegardeImpossible
	 {
		 listEmployes();
	  }

}
