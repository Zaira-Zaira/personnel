package InterfaceApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
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

import personnel.SauvegardeImpossible;

public class listEmployes {
	
	
	private static void listEmployes()
	{
		JFrame employes = new JFrame();
		employes.setSize(400, 400);
		employes.setLocationRelativeTo(null);
		employes.setJMenuBar(menuBar());
		employes.setLayout(new FlowLayout());
		employes.add(listEmp());
		employes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employes.setVisible(true);
	}

	private static JMenuBar menuBar()
	{
		 JMenuBar menubar = new JMenuBar();
		 menubar.setPreferredSize(new Dimension(60,60));
		 JMenu menu = new JMenu("Mon compte");
		 menu.setSize(70,70);
		 menu.setFont(new Font("Serif", Font.BOLD, 20));
		 menu.setForeground(Color.white);
		 JMenuItem itemMenu = new JMenuItem("Gérer mon compte");
		 menu.add(itemMenu);
		 Border borderitem = new EmptyBorder(7,7,7,7);
		 itemMenu.setBorder(borderitem);
		 itemMenu.setSize(70,70);
		 itemMenu.setFont(new Font("Serif", Font.PLAIN, 17));
		 JMenu ligues = new JMenu("Gerer les ligues");
		 ligues.setFont(new Font("Serif", Font.BOLD, 20));
		 ligues.setForeground(Color.white);
		 JMenuItem itemaccount= new JMenuItem("Afficher les ligues");
		 itemaccount.setBorder(borderitem);
		 itemaccount.setFont(new Font("Serif", Font.PLAIN, 17));
		 JMenuItem addligue= new JMenuItem("Ajouter une ligues");
		 addligue.setBorder(borderitem);
		 addligue.setFont(new Font("Serif", Font.PLAIN, 17));
		 ligues.add(itemaccount);
		 ligues.addSeparator();
		 ligues.add(addligue);
		 menubar.add(menu);
		 menubar.add(ligues);
		 menubar.setBackground(Color.lightGray);
		return menubar;
	}
	
	private static JPanel listEmp()
	{
		JPanel panel = new JPanel();
		panel.setSize(700, 700);
		panel.setLayout(new BorderLayout());
		JLabel title = new JLabel("Les employes de ligue ...");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		Border margin = new EmptyBorder(20,20,20,20);
		title.setBorder(margin);
		title.setFont(new Font("Serif", Font.PLAIN, 27));
		title.setForeground(Color.blue);
		
		JPanel panelList = new JPanel();
		panelList.setLayout(new FlowLayout());
		String choix[] = {"Employe1", "employe2", "employe2", "employe3", "employe4"};
		String editer[] = {"Editer", "Editer", "Editer", "Editer", "Editer"};
		String supprimer[] = {"Supprimer", "Supprimer", "Supprimer", "Supprimer", "Supprimer"};
		JList listemp = new JList(choix);
		JList listedit = new JList(editer);
		JList suppr = new JList(supprimer);
		
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)listemp.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);
		
		DefaultListCellRenderer renderer2 =  (DefaultListCellRenderer)listedit.getCellRenderer();  
		renderer2.setHorizontalAlignment(JLabel.CENTER);
		
		DefaultListCellRenderer renderer3 =  (DefaultListCellRenderer)suppr.getCellRenderer();  
		renderer3.setHorizontalAlignment(JLabel.CENTER);
		
		Border borderitem = new EmptyBorder(7,7,7,7);
		listemp.setFixedCellWidth(100);
		listemp.setFixedCellHeight(70);
		listedit.setFixedCellWidth(100);
		listedit.setFixedCellHeight(70);
		suppr.setFixedCellWidth(100);
		suppr.setFixedCellHeight(70);
		listemp.setBorder(borderitem);
		listedit.setBorder(borderitem);
		suppr.setBorder(borderitem);
		panelList.add(listemp);
		panelList.add(listedit);
		panelList.add(suppr);
		panel.add(title, BorderLayout.NORTH);
		panel.add(panelList, BorderLayout.CENTER);
		return panel;
	}
	
	
	
	 public static void main(String[] args)  throws SauvegardeImpossible
	 {
		 listEmployes();
	  }

}
