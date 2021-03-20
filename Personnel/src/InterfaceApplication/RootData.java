package InterfaceApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.plaf.SeparatorUI;

import personnel.SauvegardeImpossible;

public class RootData {

	
	
	public static void AccountData()
	{
		JFrame account = new JFrame();
		account.setVisible(true);
		account.setTitle("Mon compte root");
		account.getContentPane().setLayout(new BorderLayout());
		account.setSize(600, 500);
		
		
		GridLayout data = new GridLayout(0,2);
		JPanel panel = new JPanel();
		panel.setSize(100,100);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(data);
		
		ArrayList<JLabel> labels = new ArrayList<>();
		labels.add(new JLabel("Nom : ", JLabel.CENTER));
		labels.add(new JLabel("Baudet "));
		labels.add(new JLabel("Prénom : ", JLabel.CENTER));
		labels.add(new JLabel("Alice"));
		labels.add(new JLabel("Email :", JLabel.CENTER));
		labels.add(new JLabel("alice@gmail.com"));
		labels.add(new JLabel("Password : ", JLabel.CENTER));
		labels.add(new JLabel("alice125! "));
		labels.add(new JLabel("Date d'arrivée (Y-m-d) : ", JLabel.CENTER));
		labels.add(new JLabel("2020-08-04  "));
		labels.add(new JLabel("Date de départ (Y-m-d) : ", JLabel.CENTER));
		
		for(JLabel jlabel : labels) 
		{
			panel.add(jlabel);
		}
		
		
		account.setPreferredSize(new Dimension(300,400));
		account.getContentPane().add(new JLabel("Mon compte"),  BorderLayout.NORTH);
		account.setLocationRelativeTo( null );
		account.getContentPane().add(panel, BorderLayout.CENTER);
		account.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		account.pack();
	}
	
	
	 public static void main(String[] args)  throws SauvegardeImpossible
	 {
		 AccountData();
	  }
}
