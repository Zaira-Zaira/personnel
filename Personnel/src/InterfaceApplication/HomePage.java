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
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.SortedSet;

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
import javax.swing.JToolBar;
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




public class HomePage {
	
	private Ligue ListLigues;
	private SortedSet<Ligue> Ligues;
	private static Ligue ligue;
	private static GestionPersonnel gestionPersonnel;
	Color selectCouleur = Color.RED;
    private listEmployes listemp;
    public static int idLigue;
    
    
	
	 public HomePage(GestionPersonnel gestionPersonnel, listEmployes listemp) {
		    this.gestionPersonnel = gestionPersonnel;
			this.listemp = listemp;
	}


	public static void Home() {
		frame().setVisible(true);
    }
	 
	public static JFrame frame()
	{
		JFrame homePage = new JFrame();
		 homePage.setLayout(new GridBagLayout());
		 homePage.setTitle("Home page");
		 homePage.setSize(700,600);
		 homePage.setJMenuBar(menuBar());
		 homePage.add(panelContainer());
		 homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 homePage.pack();
		 homePage.setLocationRelativeTo(null);
		 return homePage;
	}
	 
	 private static JLabel title()
	 {
		 JLabel title = new JLabel("Liste des ligues");
		 title.setHorizontalAlignment(SwingConstants.CENTER);
		 title.setFont(new Font("Serif", Font.BOLD, 25));			
		 return title;
	 }
	 
	 private  static JButton addLigueBtn()
	 {
		 JButton addLigueBtn = new JButton("Ajouter une ligue");
		 addLigueBtn.setFont(new Font("Serif", Font.BOLD, 20));
		 addLigueBtn.setPreferredSize(new Dimension(220,30));
		 addLigueBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addLigue().setVisible(true);
			}
		});
		 return addLigueBtn;
	 }
	 
	 private static JDialog addLigue()
	 {
		    JDialog add = new JDialog(frame(), "Ajouter ligue");
			add.setSize(400,400);
			add.setLocationRelativeTo(null);
		    add.add(dialog());
			return add;
	 }
	 
	 private static JPanel dialog()
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
	 
	 private static JLabel ligueNameLabel()
	 {
		  JLabel  name = new JLabel("Nom :");
		  return name;
	 }
	 
	 private static TextField ligueNameInput()
	 {
		 TextField inputName = new TextField();
		 return inputName;
	 }
	 
	 private static JButton saveLigue()
	 {
		 JButton save = new JButton("Enregistrer");
		 save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						gestionPersonnel.addLigue("Marketing2");
					} catch (SauvegardeImpossible e1) {
						e1.printStackTrace();
					}
				
				
			}
		});
		 return save;
	 }
	 
	 
	 private static JButton cancelAddLigue()
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
	 
	 private static JMenuBar menuBar()
	 {
		 JMenuBar menubar = new JMenuBar();
		 menubar.setPreferredSize(new Dimension(60,60));
		 JMenu menu = new JMenu("Mon compte");
		 menu.setFont(new Font("Serif", Font.BOLD, 20));
		 menu.setSize(70,70);
		 menu.setForeground(Color.white);
		 menu.add(menuItem());
		 menubar.add(menu);
		 menubar.setBackground(Color.lightGray);
		return menubar;
	 }
	 
	 private static JMenuItem menuItem()
	 {
		 JMenuItem itemMenu = new JMenuItem("G�rer mon compte");
		 itemMenu.setFont(new Font("Serif", Font.PLAIN, 20));
		 itemMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			  RootData.AccountData();
			}
		});
		 itemMenu.setSize(70,70);
		 return itemMenu;
	 }
	 
	  
	 public static JList<Ligue>  listLigues()
	 {
		 SortedSet<Ligue> choix = getLigues();
		 JList<Ligue> listLigues = new JList<>();
		 listLigues.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 listLigues.setLayoutOrientation(JList.VERTICAL_WRAP);
		 DefaultListModel<Ligue> listLigue = new DefaultListModel<>();
		 listLigues.setFont(new Font("Serif", Font.PLAIN, 22));
		 for (Ligue ligue : choix) {
			   listLigue.addElement(ligue);
			   listEmployes emplist = new listEmployes(gestionPersonnel,ligue);
				 emplist.getList(ligue);
			}
		
		 listLigues.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//JList theList = (JList) ListSelectionEvent.getSource();
		         //System.out.println(listLigue.getSelectedValue());
				if (!e.getValueIsAdjusting()){
		            JList source = (JList)e.getSource();
		            Ligue selected = (Ligue) source.getSelectedValue();
		            listEmployes ligue = new listEmployes(gestionPersonnel,selected);
		            listEmployes.listEmployes();
		        }
				
			}
		});
		 listLigues.setModel(listLigue);
		 listLigues.setBackground(Color.lightGray);
		 DefaultListCellRenderer renderer =  (DefaultListCellRenderer)listLigues.getCellRenderer();  
		 renderer.setHorizontalAlignment(JLabel.CENTER);
		 listLigues.setFixedCellWidth(700);
		 listLigues.setFixedCellHeight(70);
		 return listLigues;
	 }

	 /**
	 * @return
	 */
	private static JPanel panelContainer()
	 {
		 JPanel panelContainer = new JPanel();
		 panelContainer.setPreferredSize(new Dimension(600,500));
		 GridLayout layout = new GridLayout(0,1);
		 layout.setVgap(-40);
		 panelContainer.setLayout(layout);
		 panelContainer.add(title());
		 
		Box boxaddLigueBtn = Box.createHorizontalBox();
		 
		 boxaddLigueBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		 boxaddLigueBtn.add(addLigueBtn());
			
			
		 panelContainer.add(boxaddLigueBtn);
		 panelContainer.add(listLigues());
		 return panelContainer;
	 }
	
	 
	 private static SortedSet<Ligue> getLigues()
	 {
		    signInPage signInPage = new signInPage(GestionPersonnel.getGestionPersonnel());
			InterfaceApplication.signInPage.gestionPersonnel.getRoot();
			SortedSet<Ligue>  ligues = signInPage.gestionPersonnel.getLigues();
			return ligues;
	 }
	 
	 public static Ligue getLigue()
	 {
		 return ligue;
	 }
	 public static void main(String[] args)  throws SauvegardeImpossible
	 {
		 Home();
	  }
}
