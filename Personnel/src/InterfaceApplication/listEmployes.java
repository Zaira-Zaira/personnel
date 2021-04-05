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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;




public class listEmployes {
	
	private  GestionPersonnel gestionPersonnel;
	private  Ligue ligue;
	private  HomePage homePage;
	private  editEmploye employe;
	
	
	 public listEmployes(GestionPersonnel gestionPersonnel, Ligue ligue) {
		    this.gestionPersonnel = gestionPersonnel;
		    this.ligue = ligue;
	}
	 
	public void listEmployes()
	{
		frame();
	}
	
	public Ligue getList(Ligue ligue) {
		ligue = ligue;
		 return ligue;
	}
	
	private JFrame frame()
	{
		JFrame employes = new JFrame();
		employes.setSize(900,900);
		employes.setLocationRelativeTo(null);
		employes.setJMenuBar(menuBar());
		employes.setLayout(new GridBagLayout());
		employes.add(ContainerEmployes());
		employes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employes.setVisible(true);
		return employes;
	}
	
	private  JPanel ContainerEmployes()
	{
		JPanel employes = new JPanel();
		employes.setLayout(new GridLayout(5,1));
		Box back = Box.createHorizontalBox();
		employes.add(titleLigue());
		employes.add(renameAndDelete());
		employes.add(title());
		Box boxaddEmployeBtn = Box.createHorizontalBox();
		boxaddEmployeBtn.add(addEmploye());
		employes.add(boxaddEmployeBtn);
		employes.add(list());
		return employes;
	}
	private  JPanel Container()
	{
		JPanel cont = new JPanel();
		FlowLayout layout = new FlowLayout();
		layout.setHgap(60);
		cont.setLayout(layout);
		cont.add(ContainerEmployes());
		cont.add(renameAndDelete());
		return cont;
	}

	private JMenuBar menuBar()
	{
		 JMenuBar menubar = new JMenuBar();
		 menubar.setPreferredSize(new Dimension(60,60));
		 menubar.add(menuCompte());
		 menubar.add(menuLigues());
		 menubar.setBackground(Color.lightGray);
		return menubar;
	}
	
	private JMenu menuCompte()
	{
		 JMenu menu = new JMenu("Mon compte");
		 menu.add(itemMenuCompte());
		 menu.setSize(70,70);
		 menu.setFont(new Font("Serif", Font.BOLD, 20));
		 menu.setForeground(Color.white);
		 return menu;
	}
	
	private JMenu menuLigues()
	{
		JMenu ligues = new JMenu("Gerer les ligues");
		ligues.add(itemMenuLigues());
		 ligues.setFont(new Font("Serif", Font.BOLD, 20));
		 ligues.setForeground(Color.white);
		 ligues.addSeparator();
		 return ligues;
	}
	
	private JMenuItem itemMenuCompte() {
		 JMenuItem itemMenu = new JMenuItem("Gérer mon compte");
		 Border borderitem = new EmptyBorder(7,7,7,7);
		 itemMenu.setBorder(borderitem);
		 itemMenu.setSize(70,70);
		 itemMenu.setFont(new Font("Serif", Font.PLAIN, 17));
		 return itemMenu;
	}
	
	public JList<Employe> list()
	{
		SortedSet<Employe> emp = getEmployes();
		JList<Employe> empL = new JList<>();
		DefaultListModel<Employe> listEmp = new DefaultListModel<>();
		empL.setModel(listEmp);
		
		for(Employe employe : emp)
		{
			listEmp.addElement(employe);
		}
		empL.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()){
		            JList source = (JList)e.getSource();
		            Employe selectedEmploye = (Employe) source.getSelectedValue();
		            //editEmploye employe = new editEmploye(gestionPersonnel, selectedEmploye);
		            //editEmploye.listData();
		            showEmploye employe = new showEmploye(gestionPersonnel, selectedEmploye);
		            showEmploye.employeData();
		        }
				
			}
		});
		 empL.setFont(new Font("Serif", Font.BOLD, 22));
		 empL.setBackground(Color.decode("#b2f7ef"));
		 empL.setForeground(Color.decode("#540b0e"));
		 DefaultListCellRenderer renderer =  (DefaultListCellRenderer)empL.getCellRenderer();  
		 renderer.setHorizontalAlignment(JLabel.CENTER);
		 empL.setFixedCellWidth(700);
		 empL.setFixedCellHeight(40);
		return empL;
	}
	
	 public SortedSet<Employe> getEmployes()
	 {
			SortedSet<Employe> employes = ligue.getEmployes();
			return employes;
	 }
	
	private JMenuItem itemMenuLigues()
	{
		JMenuItem itemaccount= new JMenuItem("Afficher les ligues");
		Border borderitem = new EmptyBorder(7,7,7,7);
		 itemaccount.setBorder(borderitem);
		 itemaccount.setFont(new Font("Serif", Font.PLAIN, 17));
		 return itemaccount;
	}
	

	
	private JLabel titleLigue()
	{
		JLabel title = new JLabel("La ligue " + ligue.getNom() + " administrée par  " + ligue.getAdministrateur().getNom());
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.PLAIN, 27));
		Border margin = new EmptyBorder(0,0,30,0);
		title.setBorder(margin);
		return  title;
	}
	
	
	private JButton backbtn()
	{
		JButton backbtn = new JButton("Retour");
		return backbtn;
	}
	
	private JPanel renameAndDelete()
	{
		JPanel panel = new JPanel();
		FlowLayout layout = new FlowLayout();
		panel.setLayout(layout);
		Box delete = Box.createHorizontalBox();
		delete.add(deleteLigue());
		Box rename = Box.createHorizontalBox();
		rename.add(renameLigue());
		
		Box changeAdmin = Box.createHorizontalBox();
		rename.add(changeAdmin());
		
		
		panel.add(deleteLigue());
		panel.add(renameLigue());
        panel.add(changeAdmin());
		return panel;
	}
	
	private JButton renameLigue()
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
	
	
	private JButton deleteLigue()
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
	
	private JButton changeAdmin()
	{
		JButton btn = new JButton("Changer l'administrateur");
		
		return btn;
	}
	
	
	private JLabel deleteMsg()
	{
		JLabel label = new JLabel("La ligue a bien été supprimée");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		return label;
	}
	
	
	public JDialog  dialogDeleteLigue()
	{
		JDialog d = new JDialog(frame(), "Supprimer la ligue");
		d.setLayout(new GridLayout(0,1));
		d.setSize(400,400);
		d.setLocationRelativeTo(null);
		d.add(deleteMsg());
		d.add(ok());
		
		return d;
	}
	
	
	private JDialog rename()
	{
		JDialog d = new JDialog(frame(), "Renommer la ligue");
		d.setLayout(new GridBagLayout());
		d.setSize(400,400);
		d.add(renameLigueDialog());
		d.setLocationRelativeTo(null);
		return d;
	}
	
	private JPanel renameLigueDialog()
	{
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300,100));
		GridLayout layout = new GridLayout(2,2);
		layout.setVgap(25);
		panel.setLayout(layout);
        panel.add(new JLabel("Nom :"));
        panel.add(new JTextField());
        panel.add(new JButton("Enregistrer"));
        panel.add(new JButton("Annuler"));
		return panel;
	}
	
	
	private JButton ok()
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
				frame().dispose();
				homePage.Home();
			}
		});
		return btn;
	}
	
	
	private JLabel title()
	{
		JLabel title = new JLabel("La liste des employées");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.PLAIN, 27));
		title.setForeground(Color.blue);
		return title;
	}
	
	
	private JButton addEmploye()
	{
		JButton addEmploye = new JButton("Ajouter un employé");
		addEmploye.setFont(new Font("Serif", Font.BOLD, 20));
		addEmploye.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddChangeEmploye add = new AddChangeEmploye(gestionPersonnel, ligue, homePage);
				add.AddEmploye();
			}
		});
		return addEmploye;
	}

}
