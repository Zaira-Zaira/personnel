package InterfaceApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
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
	
	
	 public listEmployes(GestionPersonnel gestionPersonnel, Ligue ligue) {
		    this.ligue = ligue;
		    this.gestionPersonnel = gestionPersonnel;
	}
	 
	public static void listEmployes()
	{
		frame();
	}
	
	public Ligue getList(Ligue ligue) {
		ligue = ligue;
		 //System.out.println(ligueitem);
		 return ligue;
	}
	
	private static JFrame frame()
	{
		JFrame employes = new JFrame();
		employes.setSize(900,900);
		employes.setLocationRelativeTo(null);
		employes.setJMenuBar(menuBar());
		employes.setLayout(new GridLayout(0,1));
		employes.add(titleLigue());
		employes.add(Container());
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
		panel.add(title());
		Box boxaddEmployeBtn = Box.createHorizontalBox();
		boxaddEmployeBtn.setAlignmentX(Component.RIGHT_ALIGNMENT);
		boxaddEmployeBtn.add(addEmploye());
		panel.add(boxaddEmployeBtn);
		panel.add(listEmploye());
		return panel;
	}
	
	
	private static JLabel titleLigue()
	{
		JLabel title = new JLabel("La ligue " + ligue.getNom() + " administrée par  " + ligue.getAdministrateur().getNom());
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.PLAIN, 27));
		Border margin = new EmptyBorder(0,0,30,0);
		title.setBorder(margin);
		return  title;
	}
	
	
	private static JButton backbtn()
	{
		JButton backbtn = new JButton("Retour");
		
		return backbtn;
	}
	
	private static JPanel Container() {
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(0,2);
		panel.setLayout(layout);
		panel.add(listEmp());
		panel.add(infoLigue());
		return panel;
	}
	
	private static JButton renameLigue()
	{
	    JButton renameLigue = new JButton("Renommer la ligue");
	    renameLigue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rename().setVisible(true);
				
			}
		});
	    return renameLigue;
	}
	
	
	private static JButton deleteLigue()
	{
		JButton deleteLigue = new JButton("Supprimer la ligue");
		deleteLigue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogDeleteLigue().setVisible(true);
			}
		});
		return deleteLigue;
	}
	
	private static JLabel deleteMsg()
	{
		JLabel label = new JLabel("La ligue a bien été supprimée");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		return label;
	}
	
	public static JDialog  dialogDeleteLigue()
	{
		JDialog d = new JDialog(frame(), "Supprimer la ligue");
		d.setLayout(new GridLayout(0,1));
		d.setSize(400,400);
		d.setLocationRelativeTo(null);
		d.add(deleteMsg());
		d.add(ok());
		
		return d;
	}
	
	
	private static JDialog rename()
	{
		JDialog d = new JDialog(frame(), "Supprimer la ligue");
		d.setLayout(new GridLayout(0,1));
		d.setSize(400,400);
		d.setLocationRelativeTo(null);
		return d;
	}
	
	
	private static JButton ok()
	{
		JButton btn = new JButton("Ok");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dialogDeleteLigue().setVisible(false);
			}
		});
		return btn;
	}
	
	
	private  static JLabel title()
	{
		JLabel title = new JLabel("La liste des employées");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.PLAIN, 27));
		title.setForeground(Color.blue);
		return title;
	}
	
	
	private static JList<Employe> listEmploye()
	{
		
		 SortedSet<Employe> choix = ligue.getEmployes();
		 JList<Employe> listemp = new JList<>();
		 listemp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 listemp.setLayoutOrientation(JList.VERTICAL_WRAP);
		 DefaultListModel<String> listemploye = new DefaultListModel<>();
		 listemp.setFont(new Font("Serif", Font.PLAIN, 22));
		 for (Employe employe : choix) {
			 listemploye.addElement(employe.getNom());
			}
		 
		 DefaultListCellRenderer renderer =  (DefaultListCellRenderer)listemp.getCellRenderer();  
		 renderer.setHorizontalAlignment(JLabel.CENTER);
		 listemp.setFixedCellWidth(700);
		 listemp.setFixedCellHeight(70);
		return listemp;
	}
	
	
	private static JPanel infoLigue()
	{
		JPanel info = new JPanel();
		info.add(deleteLigue());
		info.add(renameLigue());
		return info;
	}
	
	
	private static JButton addEmploye()
	{
		JButton addEmploye = new JButton("Ajouter un employé");
		addEmploye.setFont(new Font("Serif", Font.BOLD, 20));
		addEmploye.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddChangeEmploye add = new AddChangeEmploye(ligue);
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
