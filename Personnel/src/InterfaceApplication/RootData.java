package InterfaceApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.plaf.SeparatorUI;

import personnel.SauvegardeImpossible;


public class RootData {
	public static void AccountData()
	{
		JFrame account = new JFrame();
		account.setVisible(true);
		account.setTitle("Mon compte root");
		account.getContentPane().setLayout(new BoxLayout(account, BoxLayout.Y_AXIS));
		account.setSize(600, 500);
		
		
		account.setPreferredSize(new Dimension(700,550));
		account.setLocationRelativeTo( null );
		account.add(editEmployeBtn());
		account.add(panelCobtainer());
		account.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		account.pack();
	}
	
	private static JPanel panelLabels()
	{
		JPanel panelLabels = new JPanel();
		panelLabels.setLayout(new GridLayout(0,2));
		panelLabels.setPreferredSize(new Dimension(700,550));
		ArrayList<JLabel> labels = new ArrayList<>();
		labels.add(new JLabel("Nom : "));
		labels.add(new JLabel("Baudet "));
		labels.add(new JLabel("Prénom : "));
		labels.add(new JLabel("Alice"));
		labels.add(new JLabel("Email :"));
		labels.add(new JLabel("alice@gmail.com"));
		labels.add(new JLabel("Password : "));
		labels.add(new JLabel("alice125! "));
		labels.add(new JLabel("Date d'arrivée (Y-m-d) : "));
		labels.add(new JLabel("2020-08-04  "));
		labels.add(new JLabel("Date de départ (Y-m-d) : "));
		labels.add(new JLabel("  "));
		for(JLabel jlabel : labels) 
		{
			panelLabels.add(jlabel);
		}
		return panelLabels;
	}
	
	private static JPanel panelCobtainer()
	{
		JPanel panelContainer = new JPanel();
		panelContainer.setLayout(new BorderLayout());
		panelContainer.add(panelLabels(), BorderLayout.CENTER);
		JLabel titleAccount = new JLabel("Mon compte");
		titleAccount.setHorizontalAlignment(SwingConstants.CENTER);
		titleAccount.setFont(new Font("Serif", Font.BOLD, 20));
		panelContainer.add(titleAccount, BorderLayout.NORTH);
		return panelContainer;
	}
	
	private static JButton editEmployeBtn()
	{
		 JButton editEmpBtn = new JButton("Editer");
		 return editEmpBtn;
	}
	
	 public static void main(String[] args)  throws SauvegardeImpossible
	 {
		 AccountData();
	  }
}
