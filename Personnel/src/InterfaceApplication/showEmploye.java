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
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	
	private  GestionPersonnel gestionPersonnel;
	private  Employe selectedEmploye;
	private  Ligue ligue;
	private  Employe connectedEmploye;
	
	public showEmploye(GestionPersonnel gestionPersonnel, Employe selectedEmploye, Ligue ligue, Employe connectedEmploye) {
		   this.gestionPersonnel = gestionPersonnel;
		   this.selectedEmploye = selectedEmploye;
		   this.ligue = ligue;
		   this.connectedEmploye = connectedEmploye;
	}
	
	public void employeShow()
	{
		frame().setVisible(true);
	}

	public JFrame frame()
	{
		JFrame employeData = new JFrame();
		employeData.getContentPane().setBackground(Color.decode("#cbc0d3"));
		employeData.setLayout(new GridBagLayout());
		employeData.add(container());
		employeData.setSize(700,700);
		employeData.setLocationRelativeTo(null);
		employeData.setJMenuBar(menuBar());
		employeData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return employeData;
	}
	
	private JMenuBar menuBar()
	{
		 JMenuBar menubar = new JMenuBar();
		 menubar.setPreferredSize(new Dimension(60,60));
		 menubar.add(menuLigues());
		 menubar.setBackground(Color.decode("#540b0e"));
		return menubar;
	}
	private JMenu menuLigues()
	{
		JMenu ligues = new JMenu("Mon compte");
		 ligues.setFont(new Font("Serif", Font.BOLD, 20));
		 ligues.setForeground(Color.decode("#fafafa"));
		 ligues.add(menuItem());
		 ligues.addSeparator();
		 return ligues;
	}
	
	 private JMenuItem menuItem()
	 {
		 JMenuItem itemMenu = new JMenuItem("G�rer mon compte");
		 itemMenu.setFont(new Font("Serif", Font.PLAIN, 20));
		 itemMenu.setBackground(Color.decode("#540b0e"));
		 itemMenu.setForeground(Color.decode("#fafafa"));
		 itemMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				    frame().setVisible(false);
					RootData account = new RootData(gestionPersonnel, connectedEmploye);
					account.AccountData();
			}
		});
		 return itemMenu;
	 }
	private JPanel data()
	{
		JPanel panelLabels = new JPanel();
		panelLabels.setBorder(BorderFactory.createLineBorder(Color.decode("#540b0e"), 1));
		panelLabels.setBackground(Color.decode("#feeafa"));
		GridLayout layout = new GridLayout(0,2);
		layout.setVgap(9);
		panelLabels.setLayout(layout);
		ArrayList<JLabel> labels = new ArrayList<>();
		labels.add(new JLabel("Nom : "));
		labels.add(new JLabel(selectedEmploye.getNom()));
		labels.add(new JLabel("Pr�nom : "));
		labels.add(new JLabel(selectedEmploye.getPrenom()));
		labels.add(new JLabel("Email :"));
		labels.add(new JLabel(selectedEmploye.getMail()));
		labels.add(new JLabel("Password : "));
		labels.add(new JLabel(selectedEmploye.getPassword()));
		labels.add(new JLabel("Date d'arriv�e (Y-m-d) : "));
		labels.add(new JLabel(String.valueOf(selectedEmploye.getDateArrivee())));
		labels.add(new JLabel("Date de d�part (Y-m-d) : "));
		labels.add(new JLabel(String.valueOf(selectedEmploye.getDateDepart())));
		for(JLabel jlabel : labels) 
		{
			panelLabels.add(jlabel);
			jlabel.setFont(new Font("Serif", Font.PLAIN, 21));
			jlabel.setForeground(Color.decode("#540b0e"));
		}
		return panelLabels;
	}
	
	
	
	
	private JPanel container()
	{
		JPanel container = new JPanel();
		container.setBackground(Color.decode("#cbc0d3"));
		GridLayout layout = new GridLayout(3,1);
		layout.setVgap(30);
		container.setLayout(layout);
		container.setSize(700,600);
		
		Box boxtitle = Box.createHorizontalBox();
		 
		boxtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		boxtitle.add(title());
		
		container.add(boxtitle);
		container.add(data());
		container.add(contBtn());
		return container;
	}
	
	private  JLabel title()
	{
		JLabel title = new JLabel("Informations");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 27));
		title.setForeground(Color.decode("#fafafa"));
		return title;
	}
	
	private JPanel contBtn()
	{
		JPanel contBtn = new JPanel();
		contBtn.setBackground(Color.decode("#cbc0d3"));
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
		back.setBackground(Color.decode("#540b0e"));
		back.setFont(new Font("Serif", Font.BOLD, 19));
		back.setForeground(Color.decode("#fafafa"));
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					 frame().setVisible(false);
					 listEmployes list = new listEmployes(gestionPersonnel, ligue, connectedEmploye);
					 list.frame().setVisible(true);
			}
		});
		return back;
	}
	
	private JButton edit()
	{
		JButton edit = new JButton("Editer l'employ�");
		  if(!gestionPersonnel.haveWritePermission(ligue, connectedEmploye)) {
			  edit.setEnabled(false);
		 }
		edit.setPreferredSize(new Dimension(130, 30));
		edit.setFont(new Font("Serif", Font.BOLD, 19));
		edit.setBackground(Color.decode("#540b0e"));
		edit.setForeground(Color.decode("#fafafa"));
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame().setVisible(false);
				editEmploye edit = new editEmploye(gestionPersonnel, selectedEmploye, ligue, connectedEmploye);
				edit.listData();
			}
		});
		return edit;
	}
	
	private JButton delete()
	{
		JButton delete = new JButton("Supprimer l'employ�");
		if(!gestionPersonnel.haveWritePermission(ligue, connectedEmploye)) {
			delete.setEnabled(false);
		 }
		delete.setBackground(Color.decode("#540b0e"));
		delete.setForeground(Color.decode("#fafafa"));
		delete.setFont(new Font("Serif", Font.BOLD, 19));
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						selectedEmploye.remove();
					} catch (SauvegardeImpossible e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "L'employ� a �t� supprim�", "supprimer l'employ�", JOptionPane.INFORMATION_MESSAGE);
					frame().setVisible(false);
					frame().dispose();
					listEmployes employesPage = new listEmployes(gestionPersonnel, ligue, connectedEmploye);
					employesPage.listEmployes();
				}
		});
		return delete;
	}
	
	private JButton setAdmin()
	{
		JButton btn = new JButton();
		if(selectedEmploye.estAdmin(ligue)) {
			btn.setText("Admin de ligue");
		}
		else if(!selectedEmploye.estAdmin(ligue)) {
			btn.setText("Mettre en admin");
		}
		
		if(!gestionPersonnel.haveWritePermission(ligue, connectedEmploye)) {
			btn.setEnabled(false);
		 }
		btn.setBackground(Color.decode("#540b0e"));
		btn.setForeground(Color.decode("#fafafa"));
		btn.setFont(new Font("Serif", Font.BOLD, 19));
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!selectedEmploye.estAdmin(ligue)) {
					ligue.setAdministrateur(selectedEmploye);
					ligue.setAdmin(selectedEmploye);
					JOptionPane.showMessageDialog(null, "L'�mploy� est maintenant l'admin de la ligue" + ligue.getNom() + ".", "Nommer admin", JOptionPane.INFORMATION_MESSAGE);
					frame().setVisible(false);
					frame().dispose();
					listEmployes employesPage = new listEmployes(gestionPersonnel, ligue, connectedEmploye);
					employesPage.listEmployes();
				}
				else if(selectedEmploye.estAdmin(ligue)) {
					try {
						ligue.removeAdmin();
					} catch (SauvegardeImpossible e) {
						e.printStackTrace();
					} 
					frame().setVisible(false);
					frame().dispose();
					listEmployes employesPage = new listEmployes(gestionPersonnel, ligue, connectedEmploye);
					employesPage.listEmployes();
				}
			}
		});
		return btn;
	}
}
