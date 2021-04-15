package InterfaceApplication;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.SortedSet;

import javax.swing.BorderFactory;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;
import javax.swing.UIManager; 




/**
 * @author 33782
 *
 */
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
    public JFrame home = new JFrame();
    private static Employe employe;
    private  static Employe connectedEmploye;
    
    
    
	 public HomePage(GestionPersonnel gestionPersonnel, Employe connectedEmploye) {
		    this.gestionPersonnel = gestionPersonnel;
		    this.connectedEmploye = connectedEmploye;
	}


	public void Home() {
		frame().setVisible(true);
    }
	
	public Employe getEmploye(Employe employe) {
		return employe = employe;
	}
	 
	public JFrame frame()
	{
		JFrame home = new JFrame();
		home.getContentPane().setBackground(Color.decode("#cbc0d3"));
		home.setSize(700,700);
		home.setLocationRelativeTo(null);
		home.setTitle("Home page");
		home.setJMenuBar(menuBar());
		home.setLayout(new GridBagLayout());
		home.add(panelContainer());
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 return home;
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
		 addLigueBtn.setBackground(Color.decode("#540b0e"));
		 addLigueBtn.setForeground(Color.decode("#fafafa"));
		 addLigueBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputValue = JOptionPane.showInputDialog("Nom de la ligue"); 
				try {
					gestionPersonnel.addLigue(inputValue);
				} catch (SauvegardeImpossible e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame().setVisible(false);
				frame().setVisible(true);
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
		 JMenu menu = new JMenu("Compte root");
		 menu.add(menuItem());
		 menu.setFont(new Font("Serif", Font.BOLD, 20));
		 menu.setForeground(Color.decode("#fafafa"));
		 menubar.setBackground(Color.decode("#6f1d1b"));
		 menubar.add(menu);
		return menubar;
	 }
	 
	 
	 private JMenuItem menuItem()
	 {
		 JMenuItem itemMenu = new JMenuItem("Gérer le compte root");
		 itemMenu.setFont(new Font("Serif", Font.PLAIN, 20));
		 itemMenu.setBackground(Color.decode("#540b0e"));
		 itemMenu.setForeground(Color.decode("#fafafa"));
		 itemMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(connectedEmploye.equals(gestionPersonnel.getRoot())) {
					RootData root = new RootData(gestionPersonnel);
					root.AccountData();
				}else {
					JOptionPane.showMessageDialog(null, "Vous n'avez pas l'accès à cette page", "droits insuffisants", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		 //itemMenu.setSize(70,70);
		 return itemMenu;
	 }
	 
	  
	 public JList<Ligue>  listLigues()
	 {
		 SortedSet<Ligue> choix = getLigues();
		 JList<Ligue> listLigues = new JList<>();
		 listLigues.setOpaque(true);
		 DefaultListModel<Ligue> listLigue = new DefaultListModel<>();
		 listLigues.setFont(new Font("Serif", Font.BOLD, 22));
		 listLigues.setModel(listLigue);
		 for (Ligue ligue : choix) {
			   listLigue.addElement(ligue);
			}
		 listLigues.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()){
		            JList source = (JList)e.getSource();
		            Ligue selected = (Ligue) source.getSelectedValue();
		            listEmployes ligue = new listEmployes(gestionPersonnel,selected, connectedEmploye);
		            frame().setVisible(false);
		            ligue.listEmployes();
		        }
				
			}
		});
		 listLigues.setModel(listLigue);
		 listLigues.setBackground(Color.decode("#feeafa"));
		 listLigues.setForeground(Color.decode("#540b0e"));
		 DefaultListCellRenderer renderer =  (DefaultListCellRenderer)listLigues.getCellRenderer();  
		 renderer.setHorizontalAlignment(JLabel.CENTER);
		 //listLigues.setFixedCellWidth(700);
		 listLigues.setFixedCellHeight(50);
		 return listLigues;
	 }
	 
	 private JScrollPane scrollList()
	 {
	    JScrollPane scrollpane = new JScrollPane(listLigues());
	    scrollpane.setPreferredSize(new Dimension(450,300));
	    scrollpane.getViewport().setBackground(Color.decode("#feeafa"));
	    scrollpane.setBorder(BorderFactory.createLineBorder(Color.decode("#540b0e"), 1));
	    return scrollpane;
	 }
	 
	 private JPanel scrollListPanel()
	 {
		 JPanel panel = new JPanel();
		 panel.add(scrollList());
		 return panel;
	 }
	

	 /**
	 * @return
	 */
	private JPanel panelContainer()
	 {
		 JPanel panelContainer = new JPanel();
		 panelContainer.setBackground(Color.decode("#feeafa"));
		 panelContainer.setMinimumSize(new Dimension(500,350));
		 BorderLayout layout = new BorderLayout();
		 layout.setVgap(30);
		 panelContainer.setLayout(layout);
		 Box boxaddLigueBtn = Box.createHorizontalBox();
	     boxaddLigueBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		 boxaddLigueBtn.add(addLigueBtn());
		 	 
		 panelContainer.add(title(), BorderLayout.NORTH);
		 panelContainer.add(boxaddLigueBtn, BorderLayout.SOUTH);
		 panelContainer.add(scrollListPanel(), BorderLayout.CENTER);
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
		HomePage home = new HomePage(gestionPersonnel, connectedEmploye );
		home.Home();
	  }
}

