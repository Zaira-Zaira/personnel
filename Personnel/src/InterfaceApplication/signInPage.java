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
import javax.swing.SwingConstants;

import commandLine.EmployeConsole;
import commandLine.LigueConsole;
import commandLine.PersonnelConsole;
import personnel.GestionPersonnel;
import personnel.Passerelle;
import personnel.SauvegardeImpossible;


public class signInPage {
	
	
    ButtonGroup group = new ButtonGroup();     
    JRadioButton radio1 = new JRadioButton("ON", true);
    JRadioButton radio2 = new JRadioButton("OFF", false);
    
    public static GestionPersonnel gestionPersonnel;
    
	public signInPage(GestionPersonnel gestionPersonnel)
	{
		this.gestionPersonnel = gestionPersonnel;
	}
	
    public static void signIn()
    {
     JFrame frame = new JFrame();
     frame.setTitle("Sign In !");
     frame.setLayout(new GridBagLayout());
     JPanel panel = new JPanel();
     panel.setLayout(new GridLayout(0,2, 5,5));
     panel.setPreferredSize(new Dimension(400,100));
     JLabel loginL = new JLabel("Login : ");
     loginL.setFont(new Font("Serif", Font.BOLD, 20));
     panel.add(loginL);
     TextField login = new TextField();
     panel.add(login);
     login.setPreferredSize(new Dimension(150,50));
     JLabel passwordL = new JLabel("Mot de passe : ");
     passwordL.setFont(new Font("Serif", Font.BOLD, 20));
     panel.add(passwordL);
     TextField passwordTxt = new TextField();
     passwordTxt.setPreferredSize(new Dimension(150,50));
     panel.add(passwordTxt);
     JButton btnconnexion = new JButton("Connexion");
     btnconnexion.setPreferredSize(new Dimension(150,50));
     panel.add(btnconnexion);
     btnconnexion.addActionListener(new ActionListener()
     {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(passwordTxt.getText().equals("root")) {
				 frame.setVisible(false);
				 InterfaceApplication.HomePage.Home();
			}else {
				frame.getContentPane().add(new JTextArea("Password incorrect"));
			}
			
				if(checkPassword(passwordTxt.getText())) {
					frame.setVisible(false);
					 InterfaceApplication.HomePage.Home();
				}else {
					frame.getContentPane().add(new JTextArea("Password incorrect"));
				}
		   }
    	 
     });
     frame.setLocationRelativeTo(null);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setJMenuBar(menuBar());
     frame.add(panel);
     frame.setVisible(true);
     frame.pack();
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
		 menubar.setBackground(Color.LIGHT_GRAY);
		 JMenu menu = new JMenu("Gestion des ligues");
		 menu.setAlignmentX(SwingConstants.WEST);
		 menu.setFont(new Font("Serif", Font.BOLD, 20));
		 menu.setForeground(Color.white);
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
    		System.out.println("data charged");
	    }else {
		System.out.println("data uncharged");
	    }
    	signIn();
	}
	
}
