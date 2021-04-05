package InterfaceApplication;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;


public class showEmploye {
	
	private static GestionPersonnel gestionPersonnel;
	private static Employe employe;
	
	public showEmploye(GestionPersonnel gestionPersonnel, Employe employe) {
		   this.gestionPersonnel = gestionPersonnel;
		   this.employe = employe;
	}
	

	public static JFrame employeData()
	{
		JFrame employeData = new JFrame();
		employeData.setLayout(new GridBagLayout());
		employeData.add(container());
		employeData.setSize(800,800);
		employeData.setLocationRelativeTo(null);
		employeData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employeData.setVisible(true);
		
		return employeData;
		
	}
	private static JPanel data()
	{
		JPanel panelLabels = new JPanel();
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
			jlabel.setFont(new Font("Serif", Font.PLAIN, 20));
		}
		return panelLabels;
		
	}
	
	
	private static JPanel container()
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
	
	private static JLabel title()
	{
		JLabel title = new JLabel("Les informations de l'employé");
		title.setFont(new Font("Serif", Font.PLAIN, 27));
		Border margin = new EmptyBorder(0,0,70,0);
		title.setBorder(margin);
		return title;
	}
	
	private static JPanel contBtn()
	{
		JPanel contBtn = new JPanel();
		contBtn.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		contBtn.add(back());
		contBtn.add(edit());
		contBtn.add(delete());
		contBtn.add(setAdmin());
		return contBtn;
	}
	
	private static JButton back()
	{
		JButton back = new JButton("Retour");
		back.setPreferredSize(new Dimension(125,30));
		return back;
	}
	
	private static JButton edit()
	{
		JButton edit = new JButton("Editer l'employé");
		edit.setPreferredSize(new Dimension(130, 30));
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				editEmploye editEmploye = new editEmploye(gestionPersonnel, employe);
				editEmploye.frame().setVisible(true);
				
			}
		});
		return edit;
	}
	
	private static JButton delete()
	{
		JButton delete = new JButton("Supprimer l'employé");
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					employe.remove();
				} catch (SauvegardeImpossible e1) {
					e1.printStackTrace();
				}
				
			}
		});
		return delete;
	}
	
	private static JButton setAdmin()
	{
		JButton btn = new JButton("Mettre en admin");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					employe.getLigue().changeAdmin(employe);
				} catch (SauvegardeImpossible e) {
					e.printStackTrace();
				}
				System.out.println("L'employe " + employe.getNom() + employe.getPrenom() + " est nommé en tant qu'administrateur de ligue " + employe.getLigue());
				
			}
		});
		return btn;
	}
	
	
	public static void main(String[] args)  throws SauvegardeImpossible
	 {
		employeData();
	  }
}
