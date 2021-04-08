package InterfaceApplication;

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
	
	 public listEmployes(GestionPersonnel gestionPersonnel, Ligue ligue) {
		    this.gestionPersonnel = gestionPersonnel;
		    this.ligue = ligue;
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
		employes.setSize(900,900);
		employes.setLocationRelativeTo(null);
		employes.setJMenuBar(menuBar());
		employes.setLayout(new GridBagLayout());
		employes.add(ContainerEmployes());
		employes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return employes;
	}
	
	private  JPanel ContainerEmployes()
	{
		JPanel employes = new JPanel();
		GridLayout layout = new GridLayout(5,1);
		layout.setVgap(65);
		employes.setLayout(layout);
		Box back = Box.createHorizontalBox();
		back.add(back());
		employes.add(back);
		employes.add(titleLigue());
		employes.add(title());
		if(getEmployes().size() > 0)
		{
			employes.add(list());
		}else {
			employes.add(notEmployesFunded());
		}
		employes.add(renameAndDelete());
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
	
	private JLabel notEmployesFunded()
	{
		JLabel label = new JLabel("Il y a aucun employé dans cette ligue");
		label.setFont(new Font("Serif", Font.BOLD, 22));
		label.setForeground(Color.decode("#fbb1bd"));
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
		 JMenuItem itemMenu = new JMenuItem("Gérer mon compte");
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
		            //editEmploye employe = new editEmploye(gestionPersonnel, selectedEmploye);
		            //editEmploye.listData();
		            showEmploye employe = new showEmploye(gestionPersonnel, selectedEmploye, ligue);
		            employe.employeShow();
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

	

	
	private JLabel titleLigue()
	{
		JLabel title = new JLabel("La ligue " + ligue.getNom() + " administrée par  " + ligue.getAdministrateur().getNom());
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 27));
		title.setForeground(Color.decode("#9a031e"));
		return  title;
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
	    renameLigue.setFont(new Font("Serif", Font.BOLD, 18));
	    renameLigue.setForeground(Color.decode("#fafafa"));
	    renameLigue.setBackground(Color.decode("#48cae4"));
	    renameLigue.setPreferredSize(new Dimension(200,35));
	    renameLigue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputValue = JOptionPane.showInputDialog("Nom de la ligue"); 
				ligue.setNom(inputValue);
			}
		});
	    return renameLigue;
	}
	
	
	private JButton deleteLigue()
	{
		JButton deleteLigue = new JButton("Supprimer la ligue");
		deleteLigue.setFont(new Font("Serif", Font.BOLD, 18));
		deleteLigue.setForeground(Color.decode("#fafafa"));
		deleteLigue.setBackground(Color.decode("#48cae4"));
		deleteLigue.setPreferredSize(new Dimension(200,35));
		deleteLigue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ligue.remove();
				} catch (SauvegardeImpossible e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "la ligue a été supprimée", "supprimer la ligue", JOptionPane.INFORMATION_MESSAGE); 
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
				HomePage pageLigues = new HomePage(gestionPersonnel);
				frame().setVisible(false);
				pageLigues.frame().setVisible(true);
			}
		});
		return btn;
	}
	
		
	private JLabel title()
	{
		JLabel title = new JLabel("La liste des employées");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.PLAIN, 27));
		title.setForeground(Color.decode("#222"));
		return title;
	}
	
	
	private JButton addEmploye()
	{
		JButton addEmploye = new JButton("Ajouter un employé");
		addEmploye.setFont(new Font("Serif", Font.BOLD, 20));
		addEmploye.setBackground(Color.decode("#48cae4"));
		addEmploye.setForeground(Color.decode("#fafafa"));
		addEmploye.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddChangeEmploye add = new AddChangeEmploye(gestionPersonnel, ligue, homePage);
				frame().setVisible(false);
				add.AddEmploye();
			}
		});
		return addEmploye;
	}

}
