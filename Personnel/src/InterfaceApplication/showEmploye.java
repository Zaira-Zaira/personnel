package InterfaceApplication;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;


public class showEmploye {
	
	private static GestionPersonnel gestionPersonnel;
	private static Employe employe;
	private static Ligue ligue;
	public showEmploye(GestionPersonnel gestionPersonnel, Employe employe, Ligue ligue) {
		   this.gestionPersonnel = gestionPersonnel;
		   this.employe = employe;
		   this.ligue = ligue;
	}
	
	public void employeShow()
	{
		frame().setVisible(true);
	}

	public JFrame frame()
	{
		JFrame employeData = new JFrame();
		employeData.setLayout(new GridBagLayout());
		employeData.add(container());
		employeData.setSize(800,800);
		employeData.setLocationRelativeTo(null);
		employeData.setJMenuBar(menuBar());
		employeData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return employeData;
	}
	
	private JMenuBar menuBar()
	{
		 JMenuBar menubar = new JMenuBar();
		 menubar.setPreferredSize(new Dimension(60,60));
		 menubar.add(menuCompte());
		 menubar.add(menuLigues());
		 menubar.setBackground(Color.decode("#9a031e"));
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
		 itemMenu.setBackground(Color.decode("#9a031e"));
		 itemMenu.setForeground(Color.decode("#fafafa"));
		 return itemMenu;
	}
	
	private JPanel data()
	{
		JPanel panelLabels = new JPanel();
		Border EtchedBorderLowered = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		panelLabels.setBorder(EtchedBorderLowered);
		panelLabels.setBackground(Color.decode("#f5f3f4"));
		panelLabels.setLayout(new GridLayout(0,2));
		panelLabels.setPreferredSize(new Dimension(400,330));
		ArrayList<JLabel> labels = new ArrayList<>();
		labels.add(new JLabel("Nom : "));
		labels.add(new JLabel(employe.getNom()));
		labels.add(new JLabel("Prénom : "));
		labels.add(new JLabel(employe.getPrenom()));
		labels.add(new JLabel("Email :"));
		labels.add(new JLabel(employe.getMail()));
		labels.add(new JLabel("Password : "));
		labels.add(new JLabel(employe.getPassword()));
		labels.add(new JLabel("Date d'arrivée (Y-m-d) : "));
		labels.add(new JLabel(" "));
		labels.add(new JLabel("Date de départ (Y-m-d) : "));
		labels.add(new JLabel("  "));
		for(JLabel jlabel : labels) 
		{
			panelLabels.add(jlabel);
			jlabel.setFont(new Font("Serif", Font.BOLD, 21));
			jlabel.setForeground(Color.decode("#023e8a"));
		}
		return panelLabels;
		
	}
	
	
	private JPanel container()
	{
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setSize(700,600);
		
		Box boxtitle = Box.createHorizontalBox();
		 
		boxtitle.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		boxtitle.add(title());
		
		container.add(boxtitle);
		container.add(data());
		container.add(contBtn());
		return container;
	}
	
	private  JLabel title()
	{
		JLabel title = new JLabel("L'employé " + employe.getNom() + " " + employe.getPrenom() );
		title.setFont(new Font("Serif", Font.BOLD, 27));
		title.setForeground(Color.decode("#9a031e"));
		Border margin = new EmptyBorder(0,0,70,0);
		title.setBorder(margin);
		return title;
	}
	
	private JPanel contBtn()
	{
		JPanel contBtn = new JPanel();
		contBtn.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		contBtn.add(back());
		contBtn.add(edit());
		contBtn.add(delete());
		contBtn.add(setAdmin());
		return contBtn;
	}
	
	private JButton back()
	{
		JButton back = new JButton("Retour");
		back.setPreferredSize(new Dimension(125,30));
		back.setBackground(Color.decode("#0096c7"));
		back.setFont(new Font("Serif", Font.BOLD, 19));
		back.setForeground(Color.decode("#fafafa"));
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					 frame().setVisible(false);
					 listEmployes list = new listEmployes(gestionPersonnel, ligue);
					 list.frame().setVisible(true);
			}
		});
		return back;
	}
	
	private JButton edit()
	{
		JButton edit = new JButton("Editer l'employé");
		edit.setPreferredSize(new Dimension(130, 30));
		edit.setFont(new Font("Serif", Font.BOLD, 19));
		edit.setBackground(Color.decode("#0096c7"));
		edit.setForeground(Color.decode("#fafafa"));
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame().setVisible(false);
				editEmploye editEmploye = new editEmploye(gestionPersonnel, employe);
				editEmploye.frame().setVisible(true);
			}
		});
		return edit;
	}
	
	private JButton delete()
	{
		JButton delete = new JButton("Supprimer l'employé");
		delete.setBackground(Color.decode("#0096c7"));
		delete.setForeground(Color.decode("#fafafa"));
		delete.setFont(new Font("Serif", Font.BOLD, 19));
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					employe.remove();
				} catch (SauvegardeImpossible e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "L'employé a été supprimé", "supprimer l'employé", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		return delete;
	}
	
	private JButton setAdmin()
	{
		JButton btn = new JButton("Mettre en admin");
		btn.setBackground(Color.decode("#0096c7"));
		btn.setForeground(Color.decode("#fafafa"));
		btn.setFont(new Font("Serif", Font.BOLD, 19));
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					employe.getLigue().changeAdmin(employe);
				} catch (SauvegardeImpossible e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "L'émployé est maintenant l'admin de la ligue" + ligue.getNom() + ".", "Nommer admin", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		return btn;
	}
}
