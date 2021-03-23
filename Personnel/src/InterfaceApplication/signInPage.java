package InterfaceApplication;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.SortedSet;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

import jdbc.JDBC;
import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.Passerelle;
import personnel.SauvegardeImpossible;


public class signInPage {
	
	
    ButtonGroup group = new ButtonGroup();     
    JRadioButton radio1 = new JRadioButton("ON", true);
    JRadioButton radio2 = new JRadioButton("OFF", false);
    
   // group.add(radio1);
   // group.add(radio2);
    private GestionPersonnel gestionPersonnel;
    public final static int SERIALIZATION = 1, JDBC = 2, 
			TYPE_PASSERELLE = JDBC;  
	private static Passerelle passerelle = TYPE_PASSERELLE == JDBC ? new jdbc.JDBC() : new serialisation.Serialization();	
	
	
    public static void signIn()
    {
     JFrame frame = new JFrame();
     frame.setTitle("Sign In !");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setLayout(new BorderLayout());
     
     JPanel panel = new JPanel();
     panel.add(new JLabel("Login"));
     TextField login = new TextField();
     panel.add(login);
     login.setPreferredSize(new Dimension(150,30));
     panel.add(new JLabel("Mot de passe"));
     TextField passwordTxt = new TextField();
     passwordTxt.setPreferredSize(new Dimension(150,30));
     panel.add(passwordTxt);
     JButton btnconnexion = new JButton("Connexion");
     panel.add(btnconnexion);
     panel.setPreferredSize(new Dimension(50,70));
     panel.setBorder(BorderFactory.createLineBorder(Color.blue));
     btnconnexion.addActionListener(new ActionListener()
     {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(passwordTxt.getText().equals("root")) {
				passerelle.getGestionPersonnel();
				 frame.setVisible(false);
				 HomePage();
			}else {
				frame.getContentPane().add(new JTextArea("Password incorrect"));
			}
			
		}
    	 
     });
     frame.add(menuBar(), BorderLayout.NORTH);
     frame.add(panel, BorderLayout.CENTER);
     frame.setVisible(true);
     frame.pack();
    }
    
    private static JMenuBar menuBar()
	 {
		 JMenuBar menubar = new JMenuBar();
		 menubar.setPreferredSize(new Dimension(50,40));
		 JMenu menu = new JMenu("Gestion des ligues");
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
    	signIn();
	}
	
}
