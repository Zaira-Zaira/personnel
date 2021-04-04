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
import javax.swing.JTable;
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
		frame();
	}
	
	public Ligue getList(Ligue ligue) {
		ligue = ligue;
		 return ligue;
	}
	
	private static JFrame frame()
	{
		JFrame employes = new JFrame();
		employes.setSize(900,900);
		employes.setLocationRelativeTo(null);
		employes.setJMenuBar(menuBar());
		employes.setLayout(new GridBagLayout());
		employes.add(Container());
		employes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employes.setVisible(true);
		return employes;
	}
	
	private static JPanel ContainerEmployes()
	{
		JPanel employes = new JPanel();
		employes.setLayout(new GridLayout(4,1));
		Box back = Box.createHorizontalBox();
		//back.add(backbtn());
		//employes.add(back);
		employes.add(titleLigue());
		employes.add(title());
		Box boxaddEmployeBtn = Box.createHorizontalBox();
		boxaddEmployeBtn.add(addEmploye());
		employes.add(boxaddEmployeBtn);
		employes.add(list());
		return employes;
	}
	private static JPanel Container()
	{
		JPanel cont = new JPanel();
		cont.setLayout(new FlowLayout());
		cont.add(ContainerEmployes());
		cont.add(renameAndDelete());
		return cont;
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
	
	public static JList<Employe> list()
	{
		SortedSet<Employe> emp = getEmployes();
		JList<Employe> empL = new JList<>();
		DefaultListModel<Employe> listEmp = new DefaultListModel<>();
		empL.setModel(listEmp);
		
		for(Employe employe : emp)
		{
			listEmp.addElement(employe);
		}
		 empL.setFont(new Font("Serif", Font.BOLD, 22));
		 empL.setBackground(Color.decode("#b2f7ef"));
		 empL.setForeground(Color.decode("#540b0e"));
		 DefaultListCellRenderer renderer =  (DefaultListCellRenderer)empL.getCellRenderer();  
		 renderer.setHorizontalAlignment(JLabel.CENTER);
		 empL.setFixedCellWidth(700);
		 empL.setFixedCellHeight(70);
		
		return empL;
	}
	
	 public static SortedSet<Employe> getEmployes()
	 {
			SortedSet<Employe> employes = ligue.getEmployes();
			return employes;
	 }
	
	private static JMenuItem itemMenuLigues()
	{
		JMenuItem itemaccount= new JMenuItem("Afficher les ligues");
		Border borderitem = new EmptyBorder(7,7,7,7);
		 itemaccount.setBorder(borderitem);
		 itemaccount.setFont(new Font("Serif", Font.PLAIN, 17));
		 return itemaccount;
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
	
	private static JPanel renameAndDelete()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		panel.setPreferredSize(new Dimension(300,400));
		panel.add(backbtn());
		panel.add(deleteLigue());
		panel.add(renameLigue());
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
