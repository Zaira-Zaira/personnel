package InterfaceApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.SortedSet;

import javax.swing.Box;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
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
	private  JTextField newLigue;
	private Employe connectedEmploye;
	
	 public listEmployes(GestionPersonnel gestionPersonnel, Ligue ligue, Employe connectedEmploye) {
		    this.gestionPersonnel = gestionPersonnel;
		    this.ligue = ligue;
		    this.connectedEmploye = connectedEmploye;
	}
	 
	public void listEmployes()
	{
		frame().setVisible(true);
	}
	
	public Ligue getList(Ligue ligue) {
		ligue = ligue;
		 return ligue;
	}
	
	public JFrame frame()
	{
		JFrame employes = new JFrame();
		employes.getContentPane().setBackground(Color.decode("#cbc0d3"));
		employes.setSize(750,750);
		employes.setLocationRelativeTo(null);
		employes.setJMenuBar(menuBar());
		employes.setLayout(new GridBagLayout());
		employes.add(container());
		employes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return employes;
	}
	private JPanel container()
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#cbc0d3"));
		panel.setMinimumSize(new Dimension(500,500));
		BorderLayout layout = new BorderLayout();
		layout.setVgap(25);
		panel.setLayout(layout);
		panel.add(backAndTitleComponent(), BorderLayout.NORTH);
		panel.add(employesList(), BorderLayout.CENTER);
		panel.add(renameAndDelete(), BorderLayout.SOUTH);
		return panel;
	}
	
	
	private JPanel backAndTitleComponent()
	{
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(2,1);
		layout.setVgap(15);
		panel.setLayout(layout);
		panel.setBackground(Color.decode("#cbc0d3"));
		Box back = Box.createHorizontalBox();
		back.add(back());
		panel.add(back);
		panel.add(titleLigue());
		return panel;
	}
	
	private JPanel employesList()
	{
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200,500));
		panel.setBackground(Color.decode("#feeafa"));
		if(getEmployes().size() > 0)
		{
			panel.add(list());
		}else {
			panel.add(notEmployesFunded());
		}
		return panel;
	}
	
	private JLabel notEmployesFunded()
	{
		JLabel label = new JLabel("Il y a aucun employ� dans cette ligue");
		label.setFont(new Font("Serif", Font.BOLD, 22));
		label.setForeground(Color.decode("#cbc0d3"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		return label;
	}

	public JMenuBar menuBar()
	{
		 JMenuBar menubar = new JMenuBar();
		 menubar.setPreferredSize(new Dimension(60,60));
		 menubar.add(menuCompte());
		 menubar.add(menuLigues());
		 menubar.setBackground(Color.decode("#540b0e"));
		return menubar;
	}
	
	private JMenu menuCompte()
	{
		 JMenu menu = new JMenu("Mon compte");
		 menu.add(itemMenuCompte());
		 menu.setSize(70,70);
		 menu.setFont(new Font("Serif", Font.BOLD, 20));
		 menu.setForeground(Color.decode("#fafafa"));
		 return menu;
	}
	
	private JMenu menuLigues()
	{
		JMenu ligues = new JMenu("Quitter");
		 ligues.setFont(new Font("Serif", Font.BOLD, 20));
		 ligues.setForeground(Color.decode("#fafafa"));
		 ligues.addSeparator();
		 return ligues;
	}
	
	private JMenuItem itemMenuCompte() {
		 JMenuItem itemMenu = new JMenuItem("G�rer mon compte");
		 Border borderitem = new EmptyBorder(7,7,7,7);
		 itemMenu.setBorder(borderitem);
		 itemMenu.setSize(70,70);
		 itemMenu.setFont(new Font("Serif", Font.PLAIN, 17));
		 itemMenu.setBackground(Color.decode("#540b0e"));
		 itemMenu.setForeground(Color.decode("#fafafa"));
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
		            showEmploye employe = new showEmploye(gestionPersonnel, selectedEmploye, ligue, connectedEmploye);
		            employe.employeShow();
		        }
			}
		});
		 empL.setFont(new Font("Serif", Font.BOLD, 22));
		 empL.setBackground(Color.decode("#feeafa"));
		 empL.setForeground(Color.decode("#540b0e"));
		 DefaultListCellRenderer renderer =  (DefaultListCellRenderer)empL.getCellRenderer();  
		 renderer.setHorizontalAlignment(JLabel.CENTER);
		 empL.setFixedCellWidth(500);
		 empL.setFixedCellHeight(40);
		return empL;
	}
	
	 public SortedSet<Employe> getEmployes()
	 {
			SortedSet<Employe> employes = ligue.getEmployes();
			return employes;
	 }

	

	
	private JLabel titleLigue()
	{
		JLabel title = new JLabel("La ligue " + ligue.getNom() + " administr�e par  " + ligue.getAdministrateur().getNom());
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 27));
		title.setForeground(Color.decode("#540b0e"));
		return  title;
	}
	
	private JPanel renameAndDelete()
	{
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(650,150));
		panel.setBackground(Color.decode("#cbc0d3"));
		FlowLayout layout = new FlowLayout();
		panel.setLayout(layout);
		
		Box delete = Box.createHorizontalBox();
		delete.add(deleteLigue());
		
		
		Box rename = Box.createHorizontalBox();
		rename.add(renameLigue());
		
		
		Box addEmploye = Box.createHorizontalBox();
		addEmploye.add(addEmploye());
		
		panel.add(deleteLigue());
		panel.add(renameLigue());
		panel.add(addEmploye);
		return panel;
	}
	
	private JButton renameLigue()
	{
	    JButton renameLigue = new JButton("Renommer la ligue");
	    if(!gestionPersonnel.haveWritePermission(ligue, connectedEmploye)) {
	    	renameLigue.setEnabled(false);
	 }
	    renameLigue.setFont(new Font("Serif", Font.BOLD, 18));
	    renameLigue.setForeground(Color.decode("#fafafa"));
	    renameLigue.setBackground(Color.decode("#540b0e"));
	    renameLigue.setPreferredSize(new Dimension(200,35));
	    renameLigue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputValue = JOptionPane.showInputDialog("Nom de la ligue"); 
				ligue.setNom(inputValue);
				HomePage pageLigues = new HomePage(gestionPersonnel, connectedEmploye);
				frame().setVisible(false);
				frame().dispose();
				pageLigues.frame().setVisible(true);
			}
		});
	    return renameLigue;
	}
	
	
	private JButton deleteLigue()
	{
		JButton deleteLigue = new JButton("Supprimer la ligue");
		 if(!gestionPersonnel.haveWritePermission(ligue, connectedEmploye)) {
			      deleteLigue.setEnabled(false);
		 }
		deleteLigue.setFont(new Font("Serif", Font.BOLD, 18));
		deleteLigue.setForeground(Color.decode("#fafafa"));
		deleteLigue.setBackground(Color.decode("#540b0e"));
		deleteLigue.setPreferredSize(new Dimension(200,35));
		deleteLigue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ligue.remove();
				} catch (SauvegardeImpossible e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "la ligue a �t� supprim�e", "supprimer la ligue", JOptionPane.INFORMATION_MESSAGE);
				HomePage pageLigues = new HomePage(gestionPersonnel, connectedEmploye);
				frame().setVisible(false);
				frame().dispose();
				pageLigues.frame().setVisible(true);
			}
		});
		return deleteLigue;
	}
	
	private JButton back()
	{
		JButton btn = new JButton("Retour");
		btn.setBackground(Color.decode("#48cae4"));
		btn.setForeground(Color.decode("#fafafa"));
		btn.setPreferredSize(new Dimension(130,30));
		btn.setFont(new Font("Serif", Font.PLAIN, 22));
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HomePage pageLigues = new HomePage(gestionPersonnel, connectedEmploye);
				frame().setVisible(false);
				pageLigues.frame().setVisible(true);
			}
		});
		return btn;
	}
	
		
	private JLabel title()
	{
		JLabel title = new JLabel("La liste des employ�es");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.PLAIN, 27));
		title.setForeground(Color.decode("#540b0e"));
		return title;
	}
	
	
	private JButton addEmploye()
	{
		JButton addEmploye = new JButton("Ajouter un employ�");
		if(!gestionPersonnel.haveWritePermission(ligue, connectedEmploye)) {
			addEmploye.setEnabled(false);
	 }
		addEmploye.setFont(new Font("Serif", Font.BOLD, 20));
		addEmploye.setBackground(Color.decode("#540b0e"));
		addEmploye.setForeground(Color.decode("#fafafa"));
		addEmploye.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddChangeEmploye add = new AddChangeEmploye(gestionPersonnel, ligue, homePage, connectedEmploye);
				frame().setVisible(false);
				add.AddEmploye();
			}
		});
		return addEmploye;
	}

}
