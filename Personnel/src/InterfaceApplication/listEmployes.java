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
	
	private static GestionPersonnel gestionPersonnel;
	private static Ligue ligue;
	private static HomePage homePage;
	
	 public listEmployes(GestionPersonnel gestionPersonnel, Ligue ligue) {
		    this.ligue = ligue;
		    this.gestionPersonnel = gestionPersonnel;
	}
	 
	public static void listEmployes()
	{
		for(Employe employe : ligue.getEmployes()) {
			System.out.println(listEmploye());
		}
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
		 JMenuItem itemMenu = new JMenuItem("G�rer mon compte");
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
		JLabel title = new JLabel("La ligue " + ligue.getNom() + " administr�e par  " + ligue.getAdministrateur().getNom());
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
		GridLayout layout = new GridLayout(0,1);
		layout.setVgap(10);
		panel.setLayout(layout);
		panel.add(infoLigue());
		panel.add(listEmp());
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
		JLabel label = new JLabel("La ligue a bien �t� supprim�e");
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
				try {
					ligue.remove();
				} catch (SauvegardeImpossible e1) {
					e1.printStackTrace();
				}
				dialogDeleteLigue().setVisible(false);
			}
		});
		return btn;
	}
	
	
	private  static JLabel title()
	{
		JLabel title = new JLabel("La liste des employ�es");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.PLAIN, 27));
		title.setForeground(Color.blue);
		return title;
	}
	
	
	private static JList listEmploye()
	{
		
		  DefaultListModel model = new DefaultListModel();
		 for (Employe employe : ligue.getEmployes()) {
			    model.addElement(employe.getNom());
			}
		 JList names = new JList(model);
		 DefaultListCellRenderer renderer =  (DefaultListCellRenderer)names.getCellRenderer();  
		 renderer.setHorizontalAlignment(JLabel.CENTER);
		return names;
	}
	
	private static JList<String> EmployesName()
	{
		SortedSet<Employe> choix = ligue.getEmployes();
		JList<String> EmployesName = new JList<>();
		DefaultListModel<String> names = new DefaultListModel<>();
		
		for(Employe employe : choix) {
			names.addElement(employe.getNom());
		}
		EmployesName.setModel(names);
		return EmployesName;
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
		JButton addEmploye = new JButton("Ajouter un employ�");
		addEmploye.setFont(new Font("Serif", Font.BOLD, 20));
		addEmploye.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddChangeEmploye add = new AddChangeEmploye(gestionPersonnel, ligue, homePage);
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
