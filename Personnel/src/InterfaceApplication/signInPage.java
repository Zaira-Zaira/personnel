package InterfaceApplication;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import personnel.Ligue;
import personnel.Employe;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import commandLine.EmployeConsole;
import commandLine.LigueConsole;
import commandLine.PersonnelConsole;
import personnel.GestionPersonnel;
import personnel.Passerelle;
import personnel.SauvegardeImpossible;


public class signInPage{
	
    static GestionPersonnel gestionPersonnel;
    HomePage homepage;
    listEmployes listemp;
    Ligue ligue;
    
	public signInPage(GestionPersonnel gestionPersonnel)
	{
		this.gestionPersonnel = gestionPersonnel;
		this.homepage =  new HomePage(gestionPersonnel, listemp);
		this.listemp =  new listEmployes(gestionPersonnel, ligue);
	}
	
    public static void signIn()
    {
    	frame();
    }
    
    private static JFrame frame()
    {
    	JFrame frame = new JFrame();
    	
    	 frame.setTitle("Sign In !");
         frame.setLayout(new GridBagLayout());
         frame.setPreferredSize(new Dimension(600,600));
         frame.setLocationRelativeTo(null);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setJMenuBar(menuBar());
         frame.add(container());
         frame.setVisible(true);
         frame.pack();
    	
    	return frame;
    }
    
    private static JLabel login()
    {
    	JLabel loginL = new JLabel("Login : ");
        loginL.setFont(new Font("Serif", Font.BOLD, 25));
        loginL.setForeground(Color.decode("#540b0e"));
        return loginL;
    }
    
    private static TextField loginInput()
    {
    	TextField login = new TextField();
        login.setPreferredSize(new Dimension(150,40));
        
        return login;
    }
    
    private static JLabel password()
    {
    	JLabel passwordL = new JLabel("Mot de passe : ");
        passwordL.setFont(new Font("Serif", Font.BOLD, 25));
        passwordL.setForeground(Color.decode("#540b0e"));
        return passwordL;
    }
    
    private static TextField passInput()
    {
    	TextField passwordTxt = new TextField();
        passwordTxt.setPreferredSize(new Dimension(150,50));
        
        return passwordTxt;
    }
    private static  JButton btnConnexion()
    {
    	 JButton btnconnexion = new JButton("Connexion");
         btnconnexion.setPreferredSize(new Dimension(200,50));
         btnconnexion.setBackground(Color.decode("#540b0e"));
         btnconnexion.setForeground(Color.decode("#fafafa"));
         btnconnexion.setFont(new Font("Serif", Font.PLAIN, 20));
         btnconnexion.addActionListener(new ActionListener()
         {

    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			if(passInput().getText().equals("root")) {
    				frame().setVisible(false);
    				 InterfaceApplication.HomePage.Home();
    			}else {
    				frame().getContentPane().add(new JTextArea("Password incorrect"));
    			}
    			
    				if(checkPassword(passInput().getText())) {
    					frame().setVisible(false);
    					 InterfaceApplication.HomePage.Home();
    				}else {
    					frame().getContentPane().add(new JTextArea("Password incorrect"));
    				}
    		   }
        	 
         });
         
         return btnconnexion;
    }
    
    private static JPanel container()
    {
    	JPanel panel = new JPanel();
    	GridLayout layout = new GridLayout(0,2);
    	layout.setVgap(40);
        panel.setLayout(layout);
        panel.setPreferredSize(new Dimension(400,200));
        panel.add(login());
        panel.add(loginInput());
        panel.add(password());
        panel.add(passInput());
        panel.add(btnConnexion());
        return panel;
    }
    
    private static boolean checkPassword(String password)
    {
    	boolean ok = gestionPersonnel.getRoot().checkPassword(password);
    	return ok;
    }
    
    
    
    private static JMenuBar menuBar()
	 {
		 JMenuBar menubar = new JMenuBar();
		 menubar.setPreferredSize(new Dimension(50,50));
		 menubar.setBackground(Color.decode("#540b0e"));
		 JMenu menu = new JMenu("Gestion des ligues");
		 menu.setAlignmentX(SwingConstants.WEST);
		 menu.setFont(new Font("Serif", Font.BOLD, 20));
		 menu.setForeground(Color.decode("#fafafa"));
		 menu.setSize(80,80);
		 menubar.add(menu);
		return menubar;
	 }
    
    public static void HomePage() {
    	 JFrame homePage = new JFrame();
    	 homePage.setVisible(true);
		 homePage.setTitle("Home page");
		 homePage.getContentPane().setLayout(new FlowLayout());
		 
		 homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 homePage.pack();
    }
    
    public static void main(String[] args) throws SauvegardeImpossible
    {
    	signInPage signInPage = 
				new signInPage(GestionPersonnel.getGestionPersonnel());
    	signInPage.gestionPersonnel.getRoot();
    	if (signInPage.checkPassword("toor")) {

	    }else {
		System.out.println("data uncharged");
	    }
    	
    	signIn();
	}
	
}
