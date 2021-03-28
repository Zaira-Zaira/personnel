package InterfaceApplication;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.SortedSet;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;




public class HomePage {
	
	private Ligue ListLigues;
	private SortedSet<Ligue> Ligues;
	public static Ligue ligue;
	private GestionPersonnel gestionPersonnel;
	Color selectCouleur = Color.RED;
    private static int idLigue;
    private Employe employe;
    public static Ligue ligueItem;
    
    
    
    
	public HomePage(GestionPersonnel gestionPersonnel, Ligue ligue, Employe employe)
	{
		this.gestionPersonnel = gestionPersonnel;
		this.ligue= ligue;
		this.employe = employe;
	}
	
	
	 public static void Home() {
		 JFrame homePage = new JFrame();
    	 homePage.setVisible(true);
		 homePage.setTitle("Home page");
		 homePage.setPreferredSize(new Dimension(900,800));
		 homePage.setJMenuBar(menuBar());
		 homePage.setLayout(new BorderLayout());
		 homePage.add(panel(), BorderLayout.CENTER);
		 homePage.add(title(), BorderLayout.NORTH);
		 homePage.add(addLigueBtn(), BorderLayout.SOUTH);
		 homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 homePage.pack();
		 homePage.setLocationRelativeTo(null);
    }
	 
	 
	 private static JLabel title()
	 {
		 JLabel title = new JLabel("Liste des ligues");
		 title.setHorizontalAlignment(SwingConstants.CENTER);
		 Border bordertitle = new EmptyBorder(70,0,10,0);
		 title.setBorder(bordertitle);
		 title.setFont(new Font("Serif", Font.BOLD, 25));
		 return title;
	 }
	 
	 private  static JButton addLigueBtn()
	 {
		 JButton addLigueBtn = new JButton("Ajouter une ligue");
		 addLigueBtn.setFont(new Font("Serif", Font.BOLD, 20));
		 addLigueBtn.setPreferredSize(new Dimension(100,40));
		 return addLigueBtn;
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
		 JMenuItem itemMenu = new JMenuItem("Gérer mon compte");
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
	 
	 private static JPanel toolBar()
	 {
		 JPanel paneltool = new JPanel();
		 JToolBar toolbar = new JToolBar();
		 toolbar.setPreferredSize(new Dimension(500,500));
		 JButton addligue = new JButton("Ajouter une ligues");
		 JButton editligue = new JButton("Modifier la ligue");
		 JButton deleteLigue = new JButton("Supprimer une ligue");
		 toolbar.add(addligue);
		 toolbar.add(editligue);
		 toolbar.add(deleteLigue);
		 paneltool.add(toolbar);
		 return paneltool;
	 }
	 
	 private static JPanel panel() 
	 {
		 JPanel panel = new JPanel();
		 panel.setPreferredSize(new Dimension(300,400));
		 panel.setLayout(new GridBagLayout());
		 panel.add(listLigues());
		 return panel;
	 }
	  
	 private static JList<Ligue>  listLigues()
	 {
		 SortedSet<Ligue> choix = getLigues();
		 JList<Ligue> listLigues = new JList<>();
		 DefaultListModel<Ligue> listLigue = new DefaultListModel<>();
		 listLigues.setFont(new Font("Serif", Font.PLAIN, 22));
		 for (Ligue ligue : choix) {
			   listLigue.addElement(ligue);
			}
		
		 listLigues.addMouseListener(mouseEventOnJlist());
		 listLigues.setModel(listLigue);
		 listLigues.setPreferredSize(new Dimension(650,500));
		 listLigues.setBackground(Color.lightGray);
		 DefaultListCellRenderer renderer =  (DefaultListCellRenderer)listLigues.getCellRenderer();  
		 renderer.setHorizontalAlignment(JLabel.LEFT);
		 
		 
		 Border borderitem = new EmptyBorder(7,7,7,7);
		 listLigues.setBorder(borderitem);
		 listLigues.setFixedCellWidth(120);
		 listLigues.setFixedCellHeight(70);
		 listLigues.setBorder(borderitem);
		 return listLigues;
	 }
	 
	 private static MouseListener mouseEventOnJlist()
	 {
		 MouseListener mouseListener = new MouseAdapter() {
		      public void mouseClicked(MouseEvent mouseEvent) {
		        JList theList = (JList) mouseEvent.getSource();
		         System.out.println(theList.getSelectedValue());
		      }
		     
		    };
		    return mouseListener;
	 }
	 
	 private static SortedSet<Ligue> getLigues()
	 {
		    signInPage signInPage = new signInPage(GestionPersonnel.getGestionPersonnel());
			InterfaceApplication.signInPage.gestionPersonnel.getRoot();
			SortedSet<Ligue>  ligues = signInPage.gestionPersonnel.getLigues();
			return ligues;
	 }
	 public static void main(String[] args)  throws SauvegardeImpossible
	 {
		 Home();
	  }
}
