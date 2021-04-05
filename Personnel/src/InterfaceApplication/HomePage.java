package InterfaceApplication;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.SortedSet;
import java.util.prefs.BackingStoreException;

import javax.swing.Box;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;




public class HomePage {
	
	private Ligue ListLigues;
	private SortedSet<Ligue> Ligues;
	private static Ligue ligue;
	private static GestionPersonnel gestionPersonnel;
	Color selectCouleur = Color.RED;
    private static listEmployes listemp;
    public static int idLigue;
    private HomePage homePage;
    public JTextField inputName;
    public JDialog add;
	 public HomePage(GestionPersonnel gestionPersonnel, listEmployes listemp) {
		    this.gestionPersonnel = gestionPersonnel;
			this.listemp = listemp;
	}


	public void Home() {
		frame().setVisible(true);
    }
	 
	public JFrame frame()
	{
		JFrame homePage = new JFrame();
		homePage.setSize(900,900);
		homePage.setLocationRelativeTo(null);
		 homePage.setTitle("Home page");
		 homePage.setJMenuBar(menuBar());
		 homePage.setLayout(new GridBagLayout());
		 homePage.add(panelContainer());
		 homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 return homePage;
	}
	
	 private JLabel title()
	 {
		 JLabel title = new JLabel("Liste des ligues");
		 title.setHorizontalAlignment(SwingConstants.CENTER);
		 title.setFont(new Font("Serif", Font.BOLD, 25));			
		 return title;
	 }
	 
	 private JButton addLigueBtn()
	 {
		 JButton addLigueBtn = new JButton("Ajouter une ligue");
		 addLigueBtn.setFont(new Font("Serif", Font.BOLD, 20));
		 addLigueBtn.setPreferredSize(new Dimension(220,30));
		 addLigueBtn.setBackground(Color.decode("#ffcad4"));
		 addLigueBtn.setForeground(Color.decode("#222"));
		 addLigueBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addLigue().setVisible(true);
			}
		});
		 return addLigueBtn;
	 }
	 
	 public JDialog addLigue()
	 {
		    add = new JDialog(frame(), "Ajouter ligue");
			add.setSize(400,400);
			add.setLocationRelativeTo(null);
		    add.add(dialog());
			return add;
	 }
	 
	 private JPanel dialog()
	 {
		 JPanel panelCont = new JPanel();
		 panelCont.setLayout(new FlowLayout());
		 JPanel panel = new JPanel();
		 GridLayout gridLayout = new GridLayout(0,2);
		 gridLayout.setVgap(10);
		 gridLayout.setHgap(10);
		 panel.setLayout(gridLayout);
		 panel.add(ligueNameLabel());
		 panel.add(ligueNameInput());
		 panel.add(saveLigue());
		 panel.add(cancelAddLigue());
		 panelCont.add(panel);
		 return panelCont;
	 }
	 
	 private JLabel ligueNameLabel()
	 {
		  JLabel  name = new JLabel("Nom :");
		  return name;
	 }
	 
	 public  JTextField ligueNameInput()
	 {
		 inputName = new JTextField();
		 return inputName;
	 }
	 
	 private JButton saveLigue()
	 {
		 JButton save = new JButton("Enregistrer");
		 save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						gestionPersonnel.addLigue(inputName.getText());
						add.setVisible(false);
					} catch (SauvegardeImpossible e1) {
						e1.printStackTrace();
					}
			}
		});
		 return save;
	 }
	 
	 
	 private JButton cancelAddLigue()
	 {
		 JButton cancel = new JButton("Annuler");
		 cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addLigue().setVisible(false);				
			}
		});
		 return cancel;
	 }
	 
	 private JMenuBar menuBar()
	 {
		 JMenuBar menubar = new JMenuBar();
		 menubar.setPreferredSize(new Dimension(60,60));
		 JMenu menu = new JMenu("Mon compte");
		 menu.setFont(new Font("Serif", Font.BOLD, 20));
		 menu.setSize(70,70);
		 menu.setForeground(Color.decode("#fafafa"));
		 menu.add(menuItem());
		 menubar.add(menu);
		 menubar.setBackground(Color.decode("#9a031e"));
		return menubar;
	 }
	 
	 private JMenuItem menuItem()
	 {
		 JMenuItem itemMenu = new JMenuItem("Gérer mon compte");
		 itemMenu.setFont(new Font("Serif", Font.PLAIN, 20));
		 itemMenu.setBackground(Color.decode("#9a031e"));
		 itemMenu.setForeground(Color.decode("#fafafa"));
		 itemMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			  RootData.AccountData();
			}
		});
		 itemMenu.setSize(70,70);
		 return itemMenu;
	 }
	 
	  
	 public JList<Ligue>  listLigues()
	 {
		 SortedSet<Ligue> choix = getLigues();
		 JList<Ligue> listLigues = new JList<>();
		 DefaultListModel<Ligue> listLigue = new DefaultListModel<>();
		 listLigues.setFont(new Font("Serif", Font.BOLD, 22));
		 listLigues.setModel(listLigue);
		 for (Ligue ligue : choix) {
			   listLigue.addElement(ligue);
			   listEmployes emplist = new listEmployes(gestionPersonnel,ligue);
				 emplist.getList(ligue);
			}
		 listLigues.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()){
		            JList source = (JList)e.getSource();
		            Ligue selected = (Ligue) source.getSelectedValue();
		            listEmployes ligue = new listEmployes(gestionPersonnel,selected);
		            ligue.listEmployes();
		        }
				
			}
		});
		 listLigues.setModel(listLigue);
		 listLigues.setBackground(Color.decode("#b2f7ef"));
		 listLigues.setForeground(Color.decode("#540b0e"));
		 DefaultListCellRenderer renderer =  (DefaultListCellRenderer)listLigues.getCellRenderer();  
		 renderer.setHorizontalAlignment(JLabel.CENTER);
		 listLigues.setFixedCellWidth(700);
		 listLigues.setFixedCellHeight(50);
		 return listLigues;
	 }
	

	 /**
	 * @return
	 */
	private JPanel panelContainer()
	 {
		 JPanel panelContainer = new JPanel();
		 GridLayout card = new GridLayout(4,1);
		 panelContainer.setLayout(card);
		 
		 Box boxaddLigueBtn = Box.createHorizontalBox();
	     boxaddLigueBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		 boxaddLigueBtn.add(addLigueBtn());
		 
		 Box backBtn = Box.createHorizontalBox();
		 backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		 backBtn.add(back());
			
		 //panelContainer.add(backBtn);
		 panelContainer.add(title());
		 panelContainer.add(boxaddLigueBtn);
		 panelContainer.add(listLigues());
		 return panelContainer;
	 }
	
	private JButton back()
	{
		JButton btn = new JButton("Retour");
		
		return btn;
	}
	
	 
	 public SortedSet<Ligue> getLigues()
	 {
		    signInPage signInPage = new signInPage(GestionPersonnel.getGestionPersonnel());
			InterfaceApplication.signInPage.gestionPersonnel.getRoot();
			SortedSet<Ligue>  ligues = signInPage.gestionPersonnel.getLigues();
			return ligues;
	 }
	 
	 
	 public  Ligue getLigue()
	 {
		 return ligue;
	 }
	 
	 public static void main(String[] args)  throws SauvegardeImpossible
	 {
		HomePage home = new HomePage(gestionPersonnel, listemp);
		home.Home();
	  }
}

